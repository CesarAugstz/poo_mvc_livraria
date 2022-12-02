package controller;

import java.net.URL;
import java.time.Duration;
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
import model.entities.Rent;
import model.entities.User;
import view.util.Alerts;10

public class RegisterRentController implements Initializable{

	@FXML private ChoiceBox<String> choiceBoxUser;
	@FXML private ChoiceBox<String> choiceBoxBook;
	@FXML private ChoiceBox<String> choiceQnt;
	@FXML private Button btnSave;
	@FXML private DatePicker datePicker1;
	@FXML private DatePicker datePicker2;
	
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
    	
    	datePicker1.setValue(LocalDate.now()); 
    	datePicker2.setValue(LocalDate.now()); 
    }
    
    
    
    
    @FXML
    private void onBtnSave() {
    	try {
    		
    		//user and book selected
    		User user = users.get(choiceBoxUser.getSelectionModel().getSelectedIndex());
    		Book book = books.get(choiceBoxBook.getSelectionModel().getSelectedIndex());
    		Date dateStart = Date.from(datePicker1.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    		Date dateEnd = Date.from(datePicker2.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
    		LocalDate lDateStart = datePicker1.getValue();
    		LocalDate lDateEnd = datePicker2.getValue();
    		Duration d1 = Duration.between(lDateStart.atStartOfDay(), lDateEnd.atStartOfDay());
    		int d2 = (int)d1.toDays();
    		System.out.println(d2);
    		
    		if (!(book instanceof BestSellerBook)) {
    			if (lDateStart.isAfter(LocalDate.now().minusDays(1)) && lDateStart.isBefore(LocalDate.now().plusDays(3)) && lDateEnd.isAfter(lDateStart.plusWeeks(1)) && lDateEnd.isBefore(lDateStart.plusMonths(1))) {
    			
		    		//info Rent
		    		StringBuilder sb = new StringBuilder();
		    		
		    		//calculando o aluguel
					double totalPrice = book.readBook(user) * d2;
					double increase = totalPrice - ((book.getPrice() / 5));
					
					//calculando desconto
					if (user instanceof GeekUser || user instanceof PremiumUser) {
						totalPrice = 0.0;
					}
					
					
					sb.append("---Rent INFO---");
					sb.append("\n");
					sb.append("User =  " + user.toString());
					sb.append("\n");
					sb.append("Book =  " + book.toString());
					sb.append("\n");
					sb.append("Total days: " + d2 + "days");
					sb.append("\n");
					sb.append("Increase = $" + String.format("%.2f", increase));
					sb.append("\n");
					sb.append("Total Price = " + String.format("%.2f", totalPrice));
					sb.append("\n");
		    		
					
		    		//confirm Rent
		    		Alert alert = new Alert(AlertType.CONFIRMATION);
		    	    alert.initStyle(StageStyle.UTILITY);
		    	    alert.setHeaderText("Confirm Rent?");
		    	    Optional<ButtonType> choose = alert.showAndWait();
		    	    alert.getButtonTypes().addAll(ButtonType.CANCEL);
		    	    
		    	    
		    	    if (choose.get() == ButtonType.OK) {
		    	    	//saving Rent
		        		Rent Rent = new Rent(user, dateStart, dateEnd, book);
		        		MainController.mainDB.addNewRent(Rent);
		        		Alerts.showAlert("New Rent", "Rent registered!" + sb.toString(), null, AlertType.INFORMATION);
		    	    }
		    	    else
		    	    	Alerts.showAlert("New Rent", "Rent not registered!", null, AlertType.WARNING);
    			}
    			//incorrect date
    			else
    				Alerts.showAlert("Register Rent", "Error!  Incorrect Date", null, AlertType.ERROR);
    		}
    		//book not available
    		else 
    			Alerts.showAlert("Register Rent", "Error!  Book not available" , null, AlertType.ERROR);
	    	    
    	}
    	catch (Exception e) {
    		Alerts.showAlert("Register Rent", "Error!  " + e.getMessage(), null, AlertType.ERROR);
    	}
    	
    }
    
    
    
}

