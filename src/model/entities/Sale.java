package model.entities;

import java.util.Date;

public class Sale {
	private User user;
	private Date date;
	private Book book;
	private int quantity;
	
	
	public Sale(User user, Date date, Book book, int quantity) {
		this.user = user;
		this.date = date;
		this.book = book;
		this.quantity = quantity;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}

	
	
	
}
