package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.StageStyle;
import model.entities.Book;
import model.entities.Sale;
import model.entities.User;
import view.util.Alerts;

public class RegisterSellController implements Initializable{

	@FXML private ChoiceBox<String> choiceBoxUser;
	@FXML private ChoiceBox<String> choiceBoxBook;
	@FXML private ChoiceBox<String> choiceQnt;
	@FXML private Button btnSave;
	@FXML private TextArea txtInfo;
	@FXML private DatePicker datePicker;
	
	private List<User> users = MainController.mainDB.getUserList();
	private List<Book> books= MainController.mainDB.getBookList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	for (User u : users) 
    		choiceBoxUser.getItems().add(users.indexOf(u), u.toString());
    	choiceBoxUser.getSelectionModel().selectFirst();
    	
    
    	for (Book b : books) 
    		choiceBoxBook.getItems().add(books.indexOf(b), b.toString());
    	choiceBoxBook.getSelectionModel().selectFirst();
    	
    	datePicker.setValue(LocalDate.now()); 
    	
    	showQnt();
    	
    	choiceBoxBook.getSelectionModel()
        .selectedItemProperty()
        .addListener( (ObservableValue<? extends String> observable, String oldValue, String newValue) ->  showQnt());
    }
    
    private void showQnt() {
    	choiceQnt.getItems().clear();
    	int qnt = books.get(choiceBoxBook.getSelectionModel().getSelectedIndex()).getQuantity();
    
    	for (int i = 1; i <= qnt; i++){
    		choiceQnt.getItems().add(String.valueOf(i));
    	}
    }
    
    @FXML
    private void onBtnSave() {
    	try {
    		
    		//user and book selected
    		User user = users.get(choiceBoxUser.getSelectionModel().getSelectedIndex());
    		Book book = books.get(choiceBoxBook.getSelectionModel().getSelectedIndex());
    		Date date = Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    		
    		
    		//confirm sale
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    	    alert.initStyle(StageStyle.UTILITY);
    	    alert.setHeaderText("Confirm Sale?");
    	    Optional<ButtonType> choose = alert.showAndWait();
    	    alert.getButtonTypes().addAll(ButtonType.CANCEL);
    	    
    	    
    	    if (choose.get() == ButtonType.OK) {
    	    	//saving sale
        		Sale sale = new Sale(user, date, book, Integer.parseInt(choiceQnt.getSelectionModel().getSelectedItem()));
        		MainController.mainDB.addNewSale(sale);
        		Alerts.showAlert("New Sale", "Sale registered!", null, AlertType.INFORMATION);
    	    }
    	    else
    	    	Alerts.showAlert("New Sale", "Sale not registered!", null, AlertType.WARNING);
    	    
    	    
    	}
    	catch (Exception e) {
    		Alerts.showAlert("Register Sell", "Error!  " + e.getMessage(), null, AlertType.ERROR);
    	}
    	
    }
    
    
    
}

