package model.entities;

public class BestSellerBook extends Book{

	public BestSellerBook(String title, String author, String editorial, String category, double price, int quantity) {
		super(title, author, editorial, category, price, quantity);
	}
	@Override
	public double sellBook(User user, int quantity) {
		double price = getPrice() * quantity * 1.3;
		this.setQuantity(this.getQuantity() - quantity); 
		return price;		 
	}
	
	@Override
	public String toString() {
		return "Type: BestSeller Book; Title: " + getTitle() + "; Author: " + getAuthor() + "; Editorial: " + getEditorial() + "; Category " + getCategory() + "; Price: " + getPrice() + "; Quantity: " + getQuantity();
	}

}
