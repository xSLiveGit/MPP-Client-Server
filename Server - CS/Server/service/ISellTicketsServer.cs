using System;
using System.Collections.Generic;
using Server.domain;

namespace Server.service
{
    public interface ISellTicketsServer
    {
        void Login(User user, ISellTicketsClient client);
        void Logout(User user, ISellTicketsClient client);
        void SellTickets(String idMatch, String quantity, String buyerPerson, String username);

        List<Match> GetAllMatches() ;
        List<Match> GetFilteredAndSortedMatches();

    }
}
