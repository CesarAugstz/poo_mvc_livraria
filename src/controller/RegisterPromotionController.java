package controller;

import java.net.URL;
import java.util.ResourceBundle;

import db.MainDB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import view.util.Alerts;

public class RegisterPromotionController implements Initializable{

	@FXML private ChoiceBox<String> choiceBox;
	@FXML private ChoiceBox<String> choiceBox1;
	@FXML private ChoiceBox<String> choiceBox2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	choiceBox.getItems().addAll("5%", "10%", "15%", "20%");
    	choiceBox.getSelectionModel().selectFirst();
    	
    	
    	//choiceBox1.getItems().setAll(null)
    	//choiceBox1.getSelectionModel().selectFirst();
    	
    	//choiceBox2.getItems().addAll(days);
    	//choiceBox2.getSelectionModel().selectFirst();
    }
    
    public void onBtAddNewPromotion(){
		Alerts.showAlert("New Promotion", "Promotion registered", null, AlertType.INFORMATION);
	}

 
}
