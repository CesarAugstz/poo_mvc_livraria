package model.entities;

public class GeekUser extends User {

	public GeekUser(String name, String address, String cpf) {
		super(name, address, cpf);
	}	
	
	@Override
	public String toString() {
		return "Type: Geek User; Name: " + getName() + "; CPF: " + getCpf();
	}
	
	@Override
	public double sellBook(int quantity, double price) {
		this.setPurchasedBooks(this.getPurchasedBooks() + quantity);
		return price - (0.1*price);
	}
}
