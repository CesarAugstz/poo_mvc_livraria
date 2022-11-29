package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Book;

public class ShowBooksController implements Initializable{

	@FXML private TableView<Book> tableShowBooks;
    @FXML private TableColumn<Book, String> colTitle;
    @FXML private TableColumn<Book, String> colAuthor;
    @FXML private TableColumn<Book, String> colEditorial;
    @FXML private TableColumn<Book, String> colCategory;
    @FXML private TableColumn<Book, String> colPrice;
    @FXML private TableColumn<Book, String> colQuantity;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	colTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
    	colAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
    	colEditorial.setCellValueFactory(new PropertyValueFactory<Book, String>("editorial"));
    	colCategory.setCellValueFactory(new PropertyValueFactory<Book, String>("category"));
    	colPrice.setCellValueFactory(new PropertyValueFactory<Book, String>("price"));
    	colQuantity.setCellValueFactory(new PropertyValueFactory<Book, String>("quantity"));
 
    	tableShowBooks.getItems().setAll(MainController.mainDB.getBookList());
    }
	
}
