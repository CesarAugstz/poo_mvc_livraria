package model.entities;

import java.util.Date;

public class Read {
	private User user;
	private Date date;
	private Book book;
	
	
	public Read(User user, Date date, Book book) {
		this.user = user;
		this.date = date;
		this.book = book;
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
