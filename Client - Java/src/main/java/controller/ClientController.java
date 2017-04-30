package controller;

import entity.Match;
import entity.User;
import exceptions.ControllerException;
import gui.OperationGUIController;

import javax.xml.ws.Response;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import Generated.Protobuf.*;
/**
 * Created by Sergiu on 4/1/2017.
 */
public class ClientController implements ISellTicketsClient{

    private User user = null;
    private OperationGUIController operationGUIController = null;
    ISellTicketsServer server;

    public ClientController(ISellTicketsServer server,OperationGUIController operationGUIController) {
        this.operationGUIController = operationGUIController;
        this.server = server;
        server.setClient(this);
    }

    @Override
    public User login(String username, String password) throws SaleHouseException {
        User userL = new User(username, password);
        server.login(userL, this);
        user = userL;
        return  user;
    }

    @Override
    public void logout() throws SaleHouseException {
        this.server.logout(user,this);
        user = null;
    }

    @Override
    public void sellTickets(String idMatch, String quantity, String buyerPerson) throws SaleHouseException {
        this.server.sellTickets(idMatch,quantity,buyerPerson,user.getUsername());
    }

    @Override
    public List<Match> getAllMatches() throws  SaleHouseException {
        try {
            return this.server.getAllMatches();
        } catch (SaleHouseException e) {
            throw new SaleHouseException(e.getMessage());
        }
    }

    @Override
    public List<Match> getFilteredAndSortedMatches() throws SaleHouseException {
        return this.server.getFilteredAndSortedMatches();
    }

    @Override
    public void Update(Match match) throws SaleHouseException {
        showUpdates(match);
    }

//    public void register(String username,String paswword){
//        //TODO
//    }
//
//    public void addMatch(String team1,String team2,String stage,String noTickets,String price){
//        //TODO
//    }
//
//    public void updateMatch(String id,String team1,String team2,String stage,String noTickets,String price){
//        //TODO
//    }
//
//    public void deleteMatch(String id){
//        //TODO
//    }

    @Override
    public void showUpdates(Match match) throws SaleHouseException {
        System.out.println("Client server : Notified" + operationGUIController);
        if(null!= operationGUIController){
            System.out.println("Client server : Notified will be done");
            try {
                operationGUIController.update(match);
            } catch (ControllerException e) {
                throw new SaleHouseException(e.getMessage());
            }
        }
    }

    public void setOperationGUIController(OperationGUIController operationGUIController){
//        System.out.println("Setted controller");
        this.operationGUIController = operationGUIController;
    }
}
