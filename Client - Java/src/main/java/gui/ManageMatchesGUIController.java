package gui;

import controller.ClientController;
import controller.SaleHouseException;
import entity.Match;
import exceptions.ControllerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.rmi.RemoteException;


/**
 * Created by Sergiu on 3/19/2017.
 */
public class ManageMatchesGUIController {
    ClientController clientController = null;
    ObservableList<Match> model;
    private Match currentSelectedMatch = null;

    private static final String INVALID_COLUMN = "SOLD OUT";


    @FXML
    private TableView<Match> tableView_Match;
    @FXML
    private TableColumn<Match,String> tableColumn_Team1;
    @FXML
    private TableColumn<Match,String> tableColumn_Team2;
    @FXML
    private TableColumn<Match,String> tableColumn_Stage;
    @FXML
    private TableColumn<Match,String> tableColumn_NoTickets;
    @FXML
    private TableColumn<Match,Double> tableColumn_Price;

    @FXML
    private TextField textField_Team1;
    @FXML
    private TextField textField_Team2;
    @FXML
    private TextField textField_Stage;
    @FXML
    private TextField textField_NoTickets;
    @FXML
    private TextField textField_Price;

    public ManageMatchesGUIController() {

    }

    public void initComponents(ClientController clientController) throws SaleHouseException {
        this.clientController = clientController;
        model = FXCollections.observableList(clientController.getAllMatches());
        this.tableView_Match.setItems(model);
        linkColumns();
        tableView_Match.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            currentSelectedMatch = newSelection;
            if(null != currentSelectedMatch) {
                textField_Team1.setText(currentSelectedMatch.getTeam1());
                textField_Team2.setText(currentSelectedMatch.getTeam2());
                textField_Stage.setText(currentSelectedMatch.getStage());
                textField_NoTickets.setText(currentSelectedMatch.getTickets().toString());
                textField_Price.setText(currentSelectedMatch.getPrice().toString());
            }
        });
        actualiseList();
    }

    private void linkColumns(){
        tableColumn_Team1.setCellValueFactory(new PropertyValueFactory<Match, String>("team1"));
        tableColumn_Team2.setCellValueFactory(new PropertyValueFactory<Match, String>("team2"));
        tableColumn_Stage.setCellValueFactory(new PropertyValueFactory<Match, String>("stage"));
        tableColumn_NoTickets.setCellValueFactory(new PropertyValueFactory<Match, String>("ticketsString"));
        tableColumn_Price.setCellValueFactory(new PropertyValueFactory<Match, Double>("price"));
        tableColumn_NoTickets.setCellFactory(column -> {
            return new TableCell<Match, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(super.getText());
                    } else {
                        setText(item);
                        if(item.equals(INVALID_COLUMN))
                            setTextFill(Color.RED);
                        else
                            setTextFill(Color.BLACK);
                    }

                }
            };
        });
    }

    public void button_AddTicket_Handler(){

        try {
//            clientController.addMatch(textField_Team1.getText(),textField_Team2.getText(),textField_Stage.getText(),textField_NoTickets.getText(),textField_Price.getText());
            actualiseList();
        } catch (SaleHouseException e) {
            StaticHelperClass.showWarningMessage(e.getMessage());
        }
    }

    public void button_UpdateTicket_Handler(){
        if(null == currentSelectedMatch){
            StaticHelperClass.showWarningMessage("You must select 1 match.");
            return;
        }
        try {
//            clientController.updateMatch(currentSelectedMatch.getId().toString(),textField_Team1.getText(),textField_Team2.getText(),textField_Stage.getText(),textField_NoTickets.getText(),textField_Price.getText());
            actualiseList();
        } catch (SaleHouseException e) {
            StaticHelperClass.showWarningMessage(e.getMessage());
        }
    }

    public  void button_DeleteTicket_Handler(){
        if(null == currentSelectedMatch){
            StaticHelperClass.showWarningMessage("You must select 1 match.");
            return;
        }
        try {
//            clientController.deleteMatch(currentSelectedMatch.getId().toString());
            actualiseList();
        } catch (SaleHouseException e) {
            StaticHelperClass.showWarningMessage(e.getMessage());
        }
    }

    public void actualiseList() throws SaleHouseException {
        model.setAll(clientController.getAllMatches());
    }
}
