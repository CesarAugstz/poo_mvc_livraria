package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.entities.BestSellerBook;
import model.entities.Book;
import model.entities.NewlyReleasedBook;
import model.entities.PremiumBook;
import view.util.Alerts;

public class RegisterBookController implements Initializable{

	@FXML private ChoiceBox<String> choiceBox;
	@FXML private Button btNewBook;
	@FXML private TextField txtTitle, txtAuthor, txtEditorial, txtCategory, txtPrice, txtQuantity;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	choiceBox.getItems().addAll("Commom", "NewlyReleased", "BestSeller", "Premium");
    	choiceBox.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void onBtAddNewBook() {
    	int sel = choiceBox.getSelectionModel().getSelectedIndex();
    	
    	try {
	    	switch (sel) {
			case 0:
				MainController.mainDB.addNewBook(new Book (txtTitle.getText(), txtAuthor.getText(), txtEditorial.getText(), txtCategory.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQuantity.getText())));
				
				Alerts.showAlert("New Book", "Book registered!", null, AlertType.INFORMATION);
				break;
				
			case 1:
				MainController.mainDB.addNewBook(new NewlyReleasedBook(txtTitle.getText(), txtAuthor.getText(), txtEditorial.getText(), txtCategory.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQuantity.getText())));
				
				Alerts.showAlert("New Book", "Book registered!", null, AlertType.INFORMATION);
				break;
			
			case 2:
				MainController.mainDB.addNewBook(new BestSellerBook(txtTitle.getText(), txtAuthor.getText(), txtEditorial.getText(), txtCategory.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQuantity.getText())));
				Alerts.showAlert("New Book", "Book registered!", null, AlertType.INFORMATION);
				break;
					
			case 3:
				MainController.mainDB.addNewBook(new PremiumBook(txtTitle.getText(), txtAuthor.getText(), txtEditorial.getText(), txtCategory.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQuantity.getText())));
				Alerts.showAlert("New Book", "Book registered!", null, AlertType.INFORMATION);
				break;
	
			default:
				break;
			}
    	}
	    catch (Exception e) {
	    	System.out.println(e.getMessage());
	    	Alerts.showAlert("New User", "Error!  " + e.getMessage(), null, AlertType.ERROR);
	    }
    }
}
