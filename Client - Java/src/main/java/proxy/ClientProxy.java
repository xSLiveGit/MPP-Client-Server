package proxy;

import Generated.Protobuf.AppServiceGrpc;
import Generated.Protobuf.Request;
import Generated.Protobuf.Response;
import Generated.Protobuf.UserDTO;
import controller.ISellTicketsClient;
import controller.ISellTicketsServer;
import controller.SaleHouseException;
import controller.ServiceException;
import dto.DTOUtils;
import entity.Match;
import entity.Sale;
import entity.User;
import exceptions.ControllerException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.rmi.RemoteException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Logger;

/**
 * Created by Sergiu on 4/30/2017.
 */
public class ClientProxy implements ISellTicketsServer {
    private User user = null;
    private BlockingQueue<Response> queue;
    private StreamObserver<Request> streamObserver;
    private AppServiceGrpc.AppServiceStub stub;
    private ISellTicketsClient client;
    Logger logger;

    public ClientProxy(String host,Integer port){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host,port).usePlaintext(true).build();
        stub = AppServiceGrpc.newStub(channel);
        user = null;
        queue = new LinkedBlockingDeque<>();
        logger = Logger.getLogger(ClientProxy.class.getName());
    }

    public void setClient(ISellTicketsClient client) {
        this.client = client;
    }

    public Response readResponse() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void login(User user, ISellTicketsClient client) throws SaleHouseException {
        Response response;

        if (null != this.user) {
            throw new SaleHouseException("An user is allready logged in.");
        }

        this.streamObserver = stub.sendRequest(new StreamObserver<Response>() {
            @Override
            public void onNext(Response value) {
                if(null == value){
                    logger.info("onNext: null value");
                    return;
                }
                else if(value.getType().equals(Response.Type.SHOW_UPDATED_ENTITIES)){
                    logger.info("notify for update");
                    try {
                        client.showUpdates(DTOUtils.getFromDTO(value.getMatch()));
                    } catch (ControllerException | SaleHouseException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    logger.info("added response in queue");
                    queue.add(value);
                }
            }

            @Override
            public void onError(Throwable t) {
                logger.warning("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                logger.info("Complete");
            }
        });
        logger.info("Username: " + user.getId() + " Password: " + user.getPassword());
        UserDTO userDTO = DTOUtils.getDTO(user);
        streamObserver.onNext(Request
                .newBuilder()
                .setType(Request.Type.LOGIN)
                .setUser(userDTO)
                .build());
        response = this.readResponse();
        logger.info("Response type for login:" + response.getType().toString());
        if(!response.getType().equals(Response.Type.OK)){
//            streamObserver.onCompleted();
            logger.warning("!Ok at login");
            throw new SaleHouseException(response.getError());
        }
        this.user = user;
    }

    @Override
    public void logout(User user, ISellTicketsClient client) throws SaleHouseException {
        Response response;

        streamObserver.onNext(Request
                .newBuilder()
                .setType(Request.Type.LOGOUT)
                .setUser(DTOUtils.getDTO(user))
                .build());
        response = readResponse();
        if(!response.getType().equals(Response.Type.OK)){
            logger.warning("!OK at logout");
            throw new SaleHouseException(response.getError());
        }
        streamObserver.onCompleted();
        user = null;
        logger.info("Successfully logged out");
    }

    @Override
    public void sellTickets(String idMatch, String quantity, String buyerPerson, String username) throws SaleHouseException {
        Response response = null;

        streamObserver.onNext(Request
                .newBuilder()
                .setType(Request.Type.SELL_TICKETS)
                .setSale(DTOUtils.getDTO(new Sale(Integer.parseInt(idMatch),Integer.parseInt(quantity),buyerPerson),username))
                .build());
        response = readResponse();
        logger.info("SellTickets type: " + response.getType());
        if(!response.getType().equals(Response.Type.OK)){
            logger.info("response is !ok at sell tickets");

            throw new SaleHouseException(response.getError());
        }
    }

    @Override
    public List<Match> getAllMatches() throws SaleHouseException  {
        logger.info("GetAllMatches");
        return this.getMatches(Request.Type.GET_ALL);

    }

    @Override
    public List<Match> getFilteredAndSortedMatches() throws SaleHouseException {
        logger.info("GetAllFilteredAndSortedMatches");
        return this.getMatches(Request.Type.GET_ALL_FILTERED_SORTED);
    }


    private List<Match> getMatches(Request.Type type) throws SaleHouseException {
        Response response = null;
        streamObserver.onNext(Request.newBuilder().setType(type).build());
        response = this.readResponse();
        if(!response.getType().equals(Response.Type.OK)){
            logger.warning("GetAll is !ok");
            throw new SaleHouseException(response.getError());
        }
        logger.info("Get all is ok");
        return DTOUtils.getMatchesListFromDTO(response.getMatchListList());
    }
}
