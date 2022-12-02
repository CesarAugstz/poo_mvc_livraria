package model.entities;

import java.util.Date;

public class Rent {
	private User user;
	private Date dateStart;
	private Date dateEnd;
	private Book book;
	
	
	public Rent(User user, Date dateStart, Date dateEnd, Book book) {
		this.user = user;
		this.dateStart = dateStart;
		this.dateStart = dateEnd;
		this.book = book;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getDateStart() {
		return dateStart;
	}


	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}


	public Date getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}

	
	
	
}
