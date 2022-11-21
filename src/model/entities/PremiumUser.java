package model.entities;

public class PremiumUser extends User{

	public PremiumUser(String name, String address, String cpf) {
		super(name, address, cpf);
	}
	
	@Override
	public String toString() {
		return "Type: Premium User; Name: " + getName() + "; CPF: " + getCpf();
	}
	

}
