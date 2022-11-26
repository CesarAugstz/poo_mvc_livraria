package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.User;

public class ShowUsersController implements Initializable{

	@FXML private TableView<User> tableShowUsers;
    @FXML private TableColumn<User, String> colUserName;
    @FXML private TableColumn<User, String> colUserCPF;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	colUserName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
    	colUserCPF.setCellValueFactory(new PropertyValueFactory<User, String>("cpf"));
 
    	tableShowUsers.getItems().setAll(MainController.mainDB.getUserList());
    }
	
}
