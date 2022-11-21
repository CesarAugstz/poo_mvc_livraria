package model.entities;

public class User {

	private String name;
	private String address;
	private String cpf;
	private Integer purchasedBooks;
	

	public User(String name, String address, String cpf) {
		this.name = name;
		this.address = address;
		this.cpf = cpf;
		this.purchasedBooks = 0;
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	public Integer getPurchasedBooks() {
		return purchasedBooks;
	}

	public void setPurchasedBooks(Integer purchasedBooks) {
		this.purchasedBooks = purchasedBooks;
	}

	@Override
	public String toString() {
		return "Type: Common User; Name: " + getName() + "; CPF: " + getCpf();
	}
	
	public boolean upgrade() {
		if (this.getPurchasedBooks() >= 5)
			return true;
		return false;
	}
	
	public User doUpgrade() {
		if (this.getPurchasedBooks() >= 20) {
			PremiumUser user = new PremiumUser(name, address, cpf);
			user.setPurchasedBooks(this.purchasedBooks);
			return user;
		}
		else if (this.getPurchasedBooks() >= 10) {
			GeekUser user = new GeekUser(name, address, cpf);
			user.setPurchasedBooks(this.purchasedBooks);
			return user;
		}
		else if (this.getPurchasedBooks() >= 5) {
			BookwormUser user = new BookwormUser(name, address, cpf);
			user.setPurchasedBooks(this.purchasedBooks);
			return user;
		}
		return this;
	}
	
	public double sellBook(int quantity, double price) {
		this.setPurchasedBooks(this.getPurchasedBooks() + quantity);
		return price;
	}
	
	
	 
	
	
}
