import controller.ClientController;
import controller.ISellTicketsServer;
import gui.GUI;
import javafx.application.Application;
import javafx.stage.Stage;
import proxy.ClientProxy;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

/**
 * Created by Sergiu on 3/30/2017.
 */
public class StartClient extends Application {
    private static String defaultServer="127.0.0.1";
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        try{
            ISellTicketsServer server = new ClientProxy(defaultServer,5555);
            ClientController clientController = new ClientController(server,null);//
            GUI gui = new GUI(clientController);
            gui.start();
        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
