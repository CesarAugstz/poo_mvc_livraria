package controller;


import java.io.IOException;
import java.util.List;

import db.MainDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.User;


public class MainController {
	
	MainDB mainDB = new MainDB();

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
		
		System.out.println("User added");
			
		
	}
	
	//show users on system
	@FXML
	private TableView<User> tableShowUsers;
	private TableColumn<User, String> userName, userCategory , userCPF;
	private List<User> users;
	public void onBtShowUsers() {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/ShowUsers.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
	    } catch (IOException e) {
            e.printStackTrace();
	    }
		
		userName.setCellValueFactory(new PropertyValueFactory<User, String>("NAME"));
        userCategory.setCellValueFactory(new PropertyValueFactory<User, String>("CATEGORY"));
        userCPF.setCellValueFactory(new PropertyValueFactory<User, String>("CPF"));
		
		
		users = mainDB.getUserList();
		for (User u: users)
			System.out.println(u.toString());
		tableShowUsers.getItems().setAll(this.users);
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
}
