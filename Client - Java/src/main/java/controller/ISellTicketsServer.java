package controller;


import entity.Match;
import entity.User;
import exceptions.ControllerException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISellTicketsServer extends Remote {
    public void login(User user, ISellTicketsClient client) throws SaleHouseException;
    public void logout(User user, ISellTicketsClient client) throws SaleHouseException;
    public void sellTickets(String idMatch, String quantity, String buyerPerson, String username) throws SaleHouseException;

    List<Match> getAllMatches() throws SaleHouseException;
    List<Match> getFilteredAndSortedMatches() throws SaleHouseException;
    void setClient(ISellTicketsClient client);
}