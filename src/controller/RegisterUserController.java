package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.entities.Book;

public class RegisterUserController implements Initializable{

	@FXML private ChoiceBox<String> choiceBox;
	@FXML private Button btNewBook;
	@FXML private TextField txtTitle, txtAuthor, txtEditorial, txtCategory, txtPrice, txtQuantity;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	
    	choiceBox.getItems().addAll("Commom", "Geek", "Premium");
    }
    
    @FXML
    private void onBtAddNewUser() {
    	choiceBox.getItems();
    	Book book = new Book(txtTitle.getText(), txtAuthor.getText(), txtEditorial.getText(), txtCategory.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQuantity.getText()));
    }
   
	
}
