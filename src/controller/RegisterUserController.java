package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.entities.GeekUser;
import model.entities.PremiumUser;
import model.entities.User;
import view.util.Alerts;

public class RegisterUserController implements Initializable{

	@FXML private ChoiceBox<String> choiceBox;
	@FXML private TextField txtName, txtAddress, txtCPF;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	choiceBox.getItems().addAll("Commom", "Geek", "Premium");
    	choiceBox.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void onBtAddNewUser() {
    	int sel = choiceBox.getSelectionModel().getSelectedIndex();
    	
    	try {    	
	    	switch (sel) {
			case 0:
				MainController.mainDB.addNewUser(new User(txtName.getText(), txtAddress.getText(), txtCPF.getText()));
				
				Alerts.showAlert("New User", "User registered!", null, AlertType.INFORMATION);
				break;
				
			case 1:
				MainController.mainDB.addNewUser(new GeekUser(txtName.getText(), txtAddress.getText(), txtCPF.getText()));
				
				Alerts.showAlert("New User", "User registered!", null, AlertType.INFORMATION);
				break;
			
			case 2:
				MainController.mainDB.addNewUser(new PremiumUser(txtName.getText(), txtAddress.getText(), txtCPF.getText()));
				
				Alerts.showAlert("New User", "User registered!", null, AlertType.INFORMATION);
				break;
	
			default:
				break;
			}
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    		Alerts.showAlert("New User", "Error!  " + e.getMessage(), null, AlertType.ERROR);
    	}

    	
    }
   
	
}
