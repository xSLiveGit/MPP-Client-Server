using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Generated.Protobuf;
using Server.domain;

namespace Server.dto
{
    class DtoUtils
    {
        public static MatchDTO ToDto(Match match)
        {
            MatchDTO matchDto;
           
            return new MatchDTO
            {
                Id = match.Id,
                Price = match.Price,
                Stage = match.Stage,
                Team1 = match.Team1,
                Team2 = match.Team1,
                Tickets = match.Tickets
            };
        }
        public static List<MatchDTO> ToDto(List<Match> initialList)
        {
            var newList = new List<MatchDTO>();
            foreach(var match in initialList)
            {
                newList.Add(ToDto(match));
            }
            return newList;
        }
    }
}
