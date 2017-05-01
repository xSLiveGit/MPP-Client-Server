using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Generated.Protobuf;
using Grpc.Core;
using Server.repository;
using Server.service;
using Server.utils;
using Server.utils.validator;

namespace Server
{
    class StartServer
    {
        static void Main(string[] args)
        {
            DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();

            UserValidator userValidator = new UserValidator();
            MatchValidator matchValidator = new MatchValidator();
            TicketValidator ticketValidator = new TicketValidator();

            UserRepository userRepository = new UserRepository(databaseConnectionManager,"users",userValidator);
            TicketRepository ticketRepository = new TicketRepository(databaseConnectionManager,"tickets", ticketValidator);
            MatchRepository matchRepository = new MatchRepository(databaseConnectionManager,"matches",matchValidator);


            UserService userService = new UserService(userRepository);
            MatchService matchService = new MatchService(matchRepository);
            TicketService ticketService = new TicketService(ticketRepository,matchRepository);

            SellTicketsServer sellTicketsServer = new SellTicketsServer(ticketService,userService,matchService);

            var server = new Grpc.Core.Server
            {
                Services = { AppService.BindService(sellTicketsServer) },
                Ports = { new ServerPort("localhost", 5555, ServerCredentials.Insecure) }
            };
            server.Start();
            while (true)
            {
                var line = Console.ReadLine();
                if (line != null && line.ToLower().Equals("exit"))
                {
                    server.ShutdownAsync().Wait();
                    break;
                }
            }

        }
    }
}
