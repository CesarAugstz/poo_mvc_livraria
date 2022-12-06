package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.entities.Book;
import model.entities.Promotion;
import model.entities.User;
import view.util.Alerts;

public class RegisterPromotionController implements Initializable {

	@FXML
	private ChoiceBox<String> choiceBox;
	@FXML
	private ChoiceBox<String> choiceBox1;
	@FXML
	private DatePicker datePicker1;
	@FXML 
	private TextField txtName, txtDescription;

	private List<Book> books = MainController.mainDB.getBookList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		for (Book b : books)
			choiceBox1.getItems().add(books.indexOf(b), b.toString());
		choiceBox1.getSelectionModel().selectFirst();

		datePicker1.setValue(LocalDate.now());
	}
	

	public void onBtAddNewPromotion() {
		
		MainController.mainDB.addPromotion(new Promotion(txtName.getText(), null, txtDescription.getText()));
		
		Alerts.showAlert("New Promotion", "Promotion registered", null, AlertType.INFORMATION);
	}

}
