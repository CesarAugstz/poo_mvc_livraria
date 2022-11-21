package model.entities;

public class Book {
	private String title;
	private String author;
	private String editorial;
	private String category;
	private double price;
	private int quantity;
	private Integer count;
	private boolean mostUsed;
	
	public Book(String title, String author, String editorial, String category, double price, int quantity) {
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.count = 0;
		this.mostUsed = false;
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Type: Common Book; Title: " + getTitle() + "; Author: " + getAuthor() + "; Editorial: " + getEditorial() + "; Category " + getCategory() + "; Price: " + getPrice() + "; Quantity: " + getQuantity();
	}
	
	public double sellBook(User user, int quantity) {
		double price = getPrice() * quantity;
		this.setQuantity(this.getQuantity() - quantity); 
		return price;		 
	}
	
	public double rentBook(User user) {
		double price = getPrice() / 3;
		this.count += 1;
		isMostUsed();
		return price;		 
	}
	
	public double readBook(User user) {
		double price = getPrice() / 5;
		this.count += 1;
		isMostUsed();
		return price;
	}
	public void isMostUsed() {
    	if(this.getCount() >= 100 && !mostUsed) {
    		this.price = price * 0.4;
    	}
	}
	
}
