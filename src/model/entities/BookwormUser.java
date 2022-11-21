package model.entities;

//Leitores Bookworm s˜ao os leitores que compraram pelo menos 5 livros e ganham desconto de 5% na
//compra de qualquer livro.

public class BookwormUser extends User{

	public BookwormUser(String name, String address, String cpf) {
		super(name, address, cpf);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Type: Bookworm User; Name: " + getName() + "; CPF: " + getCpf();
	}
	
	@Override
	public double sellBook(int quantity, double price) {
		this.setPurchasedBooks(this.getPurchasedBooks() + quantity);
		return price - (0.05*price);
	}

}
