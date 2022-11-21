package model.entities;

public class PremiumBook extends Book{

	public PremiumBook(String title, String author, String editorial, String category, double price, int quantity) {
		super(title, author, editorial, category, price, quantity);
	}
	
	@Override
	public String toString() {
		return "Type: Premium Book; Title: " + getTitle() + "; Author: " + getAuthor() + "; Editorial: " + getEditorial() + "; Category " + getCategory() + "; Price: " + getPrice() + "; Quantity: " + getQuantity();
	}
	
	@Override
	public double sellBook(User user, int quantity) {
		double price = getPrice() * quantity * 1.1;
		this.setQuantity(this.getQuantity() - quantity); 
		return price;		 
	}
	
	@Override
	public double rentBook(User user) {
		double price = getPrice() / 3;
		super.setCount(getCount() + 1);
		super.isMostUsed();
		return price;		 
	}
}