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
    @FXML private TableColumn<User, String> colUserAddress;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	try {
	    	colUserName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
	    	colUserCPF.setCellValueFactory(new PropertyValueFactory<User, String>("cpf"));
	    	colUserAddress.setCellValueFactory(new PropertyValueFactory<User, String>("address"));
	 
	    	tableShowUsers.getItems().setAll(MainController.mainDB.getUserList());
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
	
}
