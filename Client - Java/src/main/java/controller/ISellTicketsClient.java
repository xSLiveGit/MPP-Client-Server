package controller;


import entity.Match;
import entity.User;
import exceptions.ControllerException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISellTicketsClient {
     void showUpdates(Match match) throws ControllerException, SaleHouseException;

     User login(String username, String password) throws SaleHouseException, ControllerException, RemoteException;

     void logout() throws SaleHouseException;

     void sellTickets(String idMatch, String quantity, String buyerPerson) throws SaleHouseException;

     List<Match> getAllMatches() throws SaleHouseException ;

     List<Match> getFilteredAndSortedMatches() throws SaleHouseException;

     void Update(Match match) throws SaleHouseException;
}
