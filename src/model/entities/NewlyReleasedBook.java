package model.entities;

public class NewlyReleasedBook extends Book{

	public NewlyReleasedBook(String title, String author, String editorial, String category, double price,
			int quantity) {
		super(title, author, editorial, category, price, quantity);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double sellBook(User user, int quantity) {
		double price = getPrice() * quantity * 1.2;
		this.setQuantity(this.getQuantity() - quantity); 
		return price;		 
	}
	
	@Override
	public String toString() {
		return "Type: Newly Released Book; Title: " + getTitle() + "; Author: " + getAuthor() + "; Editorial: " + getEditorial() + "; Category " + getCategory() + "; Price: " + getPrice() + "; Quantity: " + getQuantity();
	}
	
	@Override
	public double rentBook(User user) {
		double price = getPrice() / 3 * 1.3;
		super.setCount(getCount() + 1);
		super.isMostUsed();
		return price;		 
	}
}
