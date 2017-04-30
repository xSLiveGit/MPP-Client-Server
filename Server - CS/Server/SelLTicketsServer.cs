using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Generated.Protobuf;
using Grpc.Core;
using Grpc.Core.Logging;
using Grpc.Core.Utils;
using SellTicketsModel.exception;
using SellTicketsServices;
using Server.domain;
using Server.dto;
using Server.service;
using static Generated.Protobuf.AppService;

namespace Server
{
    class SellTicketsServer : AppService.AppServiceBase
    {
        private readonly UserService _userService = null;
        private readonly TicketService _ticketService = null;
        private readonly MatchService _matchService = null;
        private readonly IDictionary<String, IServerStreamWriter<Response>> _loggedClients;
        private readonly ConsoleLogger _logger;
        public SellTicketsServer(TicketService ticketService, UserService userService, MatchService matchService)
        {
            this._ticketService = ticketService;
            this._userService = userService;
            this._loggedClients = new Dictionary<string, IServerStreamWriter<Response>>();
            this._matchService = matchService;
            this._logger = new ConsoleLogger();
        }

        public override async Task sendRequest(IAsyncStreamReader<Request> requestStream,
            IServerStreamWriter<Response> responseStream, ServerCallContext context)
        {
            await requestStream.ForEachAsync(async o =>
            {
                try
                {
                    await responseStream.WriteAsync(GetResponse(responseStream, o));
                }
                catch (Exception e)
                {
                    Console.WriteLine(e);
                }
            });
        }

        public Response GetResponse(IServerStreamWriter<Response> responseStream, Request request)
        {
            _logger.Info("Request: " + request.Type.ToString());
            Response response;
            switch (request.Type)
            {
                case Request.Types.Type.Login:
                {
                    response = Login(request,responseStream);
                    break;
                }
                case Request.Types.Type.Logout:
                {
                    response = Logout(request);
                    break;
                }
                case Request.Types.Type.GetAllFilteredSorted:
                {
                    response = GetFilteredAndSortedMatches();
                    break;
                }
                case Request.Types.Type.GetAll:
                {
                    response = GetAllMatches();
                    break;
                }
                case Request.Types.Type.SellTickets:
                {
                    response = SellTickets(request);
                    break;
                }
                default:
                {
                    response = new Response {Type = Response.Types.Type.Error};
                    break;
                }
            }
            _logger.Info(response.Type.ToString());

            return response;
        }

        public Response Login(Request request, IServerStreamWriter<Response> responseStream)
        {
            try
            {
                this._userService.LogIn(request.User.Id, request.User.Password);
                this._loggedClients.Add(request.User.Id, responseStream);
                return new Response { Type = Response.Types.Type.Ok};
            }
            catch (ControllerException e)
            {
                return new Response {Type = Response.Types.Type.Error,Error = e.Message};
            }
        }

        public Response Logout(Request request)
        {
            Response response;
            if (!_loggedClients.ContainsKey(request.User.Id))
            {
                response =
                    new Response
                    {
                        Type = Response.Types.Type.Error,
                        Error = "This user isn't logged in"
                    };
                _logger.Warning("It failed");
            }
            else
            {
                response = new Response { Type = Response.Types.Type.Ok };
                _logger.Info("Successfully logout");
            }
            this._loggedClients.Remove(key: request.User.Id);
            return response;
        }

        public Response SellTickets(Request request)
        {
            try
            {
                this._ticketService.Add(quantityS: request.Sale.Quantity.ToString(), idMatchS: request.Sale.IdMatch.ToString(), person: request.Sale.Person);
                Match m = this._matchService.FindById(id: request.Sale.IdMatch);
                Notify(usernameI: request.Sale.Username, match: m);
                return new Response { Type = Response.Types.Type.Ok};
            }
            catch (ControllerException e)
            {
                return new Response { Type = Response.Types.Type.Error,Error = e.Message};
            }
        }

        public Response GetAllMatches()
        {
            try
            {
                return new Response {Type = Response.Types.Type.Ok,MatchList = { DtoUtils.ToDto(_matchService.GetAll())}};
            }
            catch (ControllerException e)
            {
                return new Response {Type = Response.Types.Type.Error,Error = e.Message};
            }
        }

        public Response GetFilteredAndSortedMatches()
        {
            try
            {
                return new Response { Type = Response.Types.Type.Ok, MatchList = { DtoUtils.ToDto(_matchService.GetAllMatchesWithRemainingTickets()) } };
            }
            catch (ControllerException e)
            {
                return new Response { Type = Response.Types.Type.Error, Error = e.Message };
            }
        }

        private void Notify(String usernameI,Match match)
        {
            _logger.Info("Notify by:" + usernameI);
            foreach (var username in this._loggedClients.Keys)
            {
                if (!username.Equals(usernameI))
                {
                    _logger.Info("Notified : " + username);
                    this._loggedClients[username].WriteAsync(new Response
                    {
                        Type = Response.Types.Type.ShowUpdatedEntities,
                        Match = DtoUtils.ToDto(match)
                    });
                }
            }
        }
    }
}
