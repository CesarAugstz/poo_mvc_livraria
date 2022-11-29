package controller;


import java.io.IOException;
import java.util.List;

import db.MainDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Book;
import model.entities.User;
import view.util.Alerts;


public class MainController {
	
	static MainDB mainDB = new MainDB();
	private List<User> users;

	@FXML
	private Button btNewUser;

	@FXML //open newUserWindow
	public void onBtNewUserAction() {		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/RegisterUser.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
			
	    } catch (IOException e) {
            e.printStackTrace();
	    }	
	}
	
	
	//open add new user on system
	@FXML
	private TextField txtName, txtAddress, txtCPF;
	public void onBtAddNewUser() {
		
		//adding user
		User user = new User(txtName.getText(), txtAddress.getText(), txtCPF.getText());
		mainDB.addNewUser(user);
		

		Alerts.showAlert("New User", "User registered!", null, AlertType.INFORMATION);
		
		users = mainDB.getUserList();
		for (User u: users)
			System.out.println(u.toString());
		
	}
	
	//show users on system
	@FXML
	public void onBtShowUsers() {
		users = mainDB.getUserList();
		
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/ShowUsers.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
	    } catch (IOException e) {
            e.getMessage();
	    }
	}
	
	@FXML
	private Button btRegisterRent;

	@FXML //open registerRentWindow
	public void onBtRegisterRent() {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/RegisterRent.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
	    } catch (IOException e) {
            e.printStackTrace();
	    }
	}

	@FXML
	private Button btNewRegisterRead;

	@FXML //open registerReadWindow
	public void onBtRegisterRead() {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/RegisterRead.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
	    } catch (IOException e) {
            e.printStackTrace();
	    }
	}

	@FXML
	private Button btNewBook;

	@FXML //open registerBookWindow
	public void onBtNewBook() {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/RegisterBook.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
	    } catch (IOException e) {
            e.printStackTrace();
	    }
	}
	
	//open add new book on system
		@FXML
		private TextField txtTitle, txtAuthor, txtEditorial, txtCategory, txtPrice, txtQuantity;
		public void onBtAddNewBook() {
			
			//adding book
			try
			{
			Book book = new Book(txtTitle.getText(), txtAuthor.getText(), txtEditorial.getText(), txtCategory.getText(), Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtQuantity.getText()));
			mainDB.addNewBook(book);
			
			Alerts.showAlert("New Book", "Book registered!", null, AlertType.INFORMATION);
			
			List<Book> books = mainDB.getBookList();
			for (Book u: books)
				System.out.println(u.toString());
			}
			catch(Exception e) {
				e.getMessage();
				Alerts.showAlert("New Book", "Book unregistered", null, AlertType.ERROR);
			}
		}

	@FXML	
	private Button btNewPromotion;

	@FXML	//open registerPromotiontWindow
	public void onBtNewPromotion() {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/RegisterPromotion.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
	    } catch (IOException e) {
            e.printStackTrace();
	    }
	}

	@FXML
	private Button btRegisterSell;

	@FXML	//open registerSellWindow
	public void onBtRegisterSell() {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/RegisterSell.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
	    } catch (IOException e) {
            e.printStackTrace();
	    }
	}
	
	public void onBtRegisterRent1() {
		Alerts.showAlert("New Rent", "Rent registered", null, AlertType.INFORMATION);
	}
	
	public void onBtRegisterRead1() {
		Alerts.showAlert("New Read", "Read registered", null, AlertType.INFORMATION);
	}
	
	public void onBtRegisterSell1() {
		Alerts.showAlert("New Sell", "Sell registered", null, AlertType.INFORMATION);
	}
	
	@FXML
	private Button btShowBooks;

	@FXML	//open ShowBoooks
	public void onBtShowBooks() {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/ShowBooks.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
	    } catch (IOException e) {
            e.printStackTrace();
	    }
	}
	
	@FXML
	private Button btShowPromotions;

	@FXML	//open ShowPromotions
	public void onBtShowPromotions() {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/ShowPromotions.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
	    } catch (IOException e) {
            e.printStackTrace();
	    }
	}
}
