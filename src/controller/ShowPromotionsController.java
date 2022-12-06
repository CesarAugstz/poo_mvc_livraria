package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Promotion;

public class ShowPromotionsController implements Initializable{

	@FXML private TableView<Promotion> tableShowPromotions;
    @FXML private TableColumn<Promotion, String> colName;
    @FXML private TableColumn<Promotion, Integer> colDays;
    @FXML private TableColumn<Promotion, String> colDescription;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	colName.setCellValueFactory(new PropertyValueFactory<Promotion, String>("name"));
    	colDays.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("days"));
    	colDescription.setCellValueFactory(new PropertyValueFactory<Promotion, String>("description"));
    	
    	tableShowPromotions.getItems().setAll(MainController.mainDB.getPromotionList());
    }
	
}
