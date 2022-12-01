package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.StageStyle;
import model.entities.BestSellerBook;
import model.entities.Book;
import model.entities.GeekUser;
import model.entities.PremiumUser;
import model.entities.Read;
import model.entities.User;
import view.util.Alerts;

public class RegisterReadController implements Initializable{

	@FXML private ChoiceBox<String> choiceBoxUser;
	@FXML private ChoiceBox<String> choiceBoxBook;
	@FXML private Button btnSave;
	@FXML private DatePicker datePicker;
	
	private List<User> users = MainController.mainDB.getUserList();
	private List<Book> books= MainController.mainDB.getBookList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    	for (User u : users) 
    		choiceBoxUser.getItems().add(users.indexOf(u), u.toString());
    	choiceBoxUser.getSelectionModel().selectFirst();
    	
    
    	//only books available for read
    	for (Book b : books) 
    		if (!(b instanceof BestSellerBook)) 
    			choiceBoxBook.getItems().add(books.indexOf(b), b.toString());
    	choiceBoxBook.getSelectionModel().selectFirst();
    	
    	datePicker.setValue(LocalDate.now()); 
    	
    }
    
    
    
    
    
    @FXML
    private void onBtRegisterRead() {
    	try {
    		
    		//user and book selected
    		User user = users.get(choiceBoxUser.getSelectionModel().getSelectedIndex());
    		Book book = books.get(choiceBoxBook.getSelectionModel().getSelectedIndex());
    		Date date = Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    		
    		
    		/*
    		 * 	VER A DATA SE NÃO ESTA SENDO ALUGADO JA
    		 * 
    		 * O usu´ario pode reservar para leitura qualquer livro que tamb´em esteja dispon´ıvel para aluguel, informando
    		 *		o dia da reserva. S´o ´e poss´ıvel reservar um livro para leitura por per´ıodo igual a 1 dia e a reserva n˜ao pode
    		 *		ser feita em data futura superior `a 3 dias da data atual da reserva.
    		 * 
    		 * 
    		 * 
    		 * 
    		 */
    	
    		
    		//calculando o aluguel
			double totalPrice = book.readBook(user);
			double increase = totalPrice - ((book.getPrice() / 5));
			
			//calculando desconto
			if (user instanceof GeekUser || user instanceof PremiumUser) {
				totalPrice = 0.0;
			}
			
			
			//informacoes do aluguel
			StringBuilder sb = new StringBuilder();
			sb.append("\n");
			sb.append("---READ INFO---");
			sb.append("User =  " + user.toString());
			sb.append("\n");
			sb.append("Book =  " + book.toString());
			sb.append("\n");
			sb.append("Increase = $" + String.format("%.2f", increase));
			sb.append("Total Price = $" + String.format("%.2f", totalPrice));
			sb.append("\n");
    		
			
    		//confirm Read
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    	    alert.initStyle(StageStyle.UTILITY);
    	    alert.setHeaderText("Confirm Read?");
    	    Optional<ButtonType> choose = alert.showAndWait();
    	    alert.getButtonTypes().addAll(ButtonType.CANCEL);
    	    
    	    
    	    if (choose.get() == ButtonType.OK) {
    	    	//saving Read
        		Read read = new Read(user, date, book);
        		MainController.mainDB.addNewRead(read);
        		Alerts.showAlert("New Read", "Read registered!" + sb.toString(), null, AlertType.INFORMATION);
    	    }
    	    else
    	    	Alerts.showAlert("New Read", "Read not registered!", null, AlertType.WARNING);
    	    
    	    
    	}
    	catch (Exception e) {
    		Alerts.showAlert("Register Read", "Error!  " + e.getMessage(), null, AlertType.ERROR);
    	}
    	
    }
    
    
    
}

