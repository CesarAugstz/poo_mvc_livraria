package db;

import java.util.ArrayList;
import java.util.List;

import model.entities.Book;
import model.entities.User;

public class MainDB {

	private List<Book> bookList = new ArrayList<>();
	private List<User> userList = new ArrayList<>();
	
	
	public MainDB() {

	}
	
	public void addNewUser(User user) {
		userList.add(user);
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void addNewBook(Book book) {
		bookList.add(book);
	}
	
	
}
