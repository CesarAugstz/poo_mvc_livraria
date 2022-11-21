package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.BestSellerBook;
import model.entities.Book;
import model.entities.BookwormUser;
import model.entities.GeekUser;
import model.entities.NewlyReleasedBook;
import model.entities.PremiumBook;
import model.entities.PremiumUser;
import model.entities.User;

public class Program{
	public static void main(String[] args) {
		int op = 0;
		
		Locale.setDefault(Locale.US);
		List<Book> bookList = new ArrayList<>();
		List<User> userList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		bookList = initializeBooks(bookList);
		userList = initializeUsers(userList);
		
		do { 
			System.out.println();
			System.out.println("Livraria Martelo de Assis");
			System.out.println("(1) - Register User");
			System.out.println("(2) - Register Book");
			System.out.println("(3) - Register Sell");
			System.out.println("(4) - Register Rent");
			System.out.println("(5) - Register Read");
			System.out.println("(6) - Register Promotion");
			System.out.println("(0) - Exit");
			op = sc.nextInt();

			if(op < 0 || op > 5)
				System.out.println("Invalid command.");

			switch (op) {
				case 1:
					try {
						
						System.out.print("Name: ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.print("Adress: ");
						String adress = sc.nextLine();
						System.out.print("CPF: ");
						String cpf = sc.nextLine();

						
						System.out.println("Type of user: ");
						System.out.println("(1) - Bookworm");
						System.out.println("(2) - Geek");
						System.out.println("(3) - Premium");
						int type = sc.nextInt();
						
						while (type < 1 || type >3) {
							System.out.print("Invalid command. Try again: ");
							type = sc.nextInt();
						}
						
						if(type == 1)
							userList.add(new User(name, adress, cpf));
						else if(type == 2)
							userList.add(new GeekUser(name, adress, cpf));
						else if(type == 3)
							userList.add(new PremiumUser(name, adress, cpf));
						
						System.out.println("User registered");
						System.out.println();
					}
					catch(Exception e) {
						System.out.println("Error: " + e);
						sc.next();
					}
					break;
					
				case 2: 
					try {
						System.out.print("Title: ");
						sc.nextLine();
						String title = sc.nextLine();
						System.out.print("Author: ");
						String author = sc.nextLine();
						System.out.print("Editorial: ");
						String editorial = sc.nextLine();
						System.out.print("Category: ");
						String category = sc.nextLine();
						System.out.print("Price: ");
						double price = sc.nextDouble();
						System.out.print("Quantity: ");
						int quantity = sc.nextInt();
						
						int type = 0;

						while(type < 1 || type > 3) {
							System.out.println("Type of book: ");
							System.out.println("(1) - Commom ");
							System.out.println("(2) - Premium ");
							System.out.println("(3) - Newly Released");
							System.out.println("(3) - Best Seller");
							type = sc.nextInt();
						}System.out.println(type);
						if(type == 1)
							bookList.add(new Book(title, author, editorial, category, price, quantity));
						else if(type == 2)
							bookList.add(new PremiumBook(title, author, editorial, category, price, quantity));
						else if(type == 3)
							bookList.add(new NewlyReleasedBook(title, author, editorial, category, price, quantity));
						else if(type == 4)
							bookList.add(new BestSellerBook(title, author, editorial, category, price, quantity));
						
						System.out.println("Book registered");
						System.out.println();
			
					}
					catch(Exception e) {
						System.out.println("Error: " + e);
						sc.next();
					}
					break;
					
				case 3: //sell book 
					try {
						System.out.println();
						System.out.println("Users on system:");
						for(User user: userList) 
							System.out.println("ID: [" + userList.indexOf(user) + "] " + user.toString());
						
						//seleciona o usuario,
						System.out.println();
						System.out.print("Type the user id: ");
						int idUser = sc.nextInt();
						while (findUser(userList, idUser) < 0) {
							System.out.println("Id not found. Try again.");
							idUser = sc.nextInt();
						}
						int indexUser = findUser(userList, idUser);
						
						System.out.println("Books on system:");
						System.out.println();
						for(Book book: bookList) 
							System.out.println("ID: [" + bookList.indexOf(book) + "] " + book.toString());
						
						//seleciona o livro
						System.out.println();
						System.out.print("Type the book id: ");
						int idBook = sc.nextInt();
						while (findBook(bookList, idBook) < 0) {
							System.out.println("Id not found. Try again.");
							idBook = sc.nextInt();
						}
						int indexBook = findBook(bookList, idBook);
						
						//quantidade de livros
						System.out.print("Quantity: ");
						int quantity = sc.nextInt();
						while(quantity > bookList.get(indexBook).getQuantity()) {
							System.out.print("Invalid quantity. Type another quantity: ");
							quantity = sc.nextInt();
						}
						
						//calculando a venda
						double totalPrice = bookList.get(indexBook).sellBook(userList.get(indexUser), quantity);
						double increase = totalPrice - (bookList.get(indexBook).getPrice() * quantity);
						double discount = totalPrice;
						totalPrice = userList.get(indexUser).sellBook(quantity, totalPrice);
						discount = discount - totalPrice;
						
						//possivel upgrade de usuario
						if (userList.get(indexUser).upgrade()) {
							userList.add(userList.get(indexUser).doUpgrade());
							userList.remove(userList.get(indexUser));
						}
						
						
						//informacoes da venda
						System.out.println();
						System.out.println("---SELL INFO---");
						System.out.println("User =  " + userList.get(indexUser).toString());
						System.out.println("Book =  " + bookList.get(indexBook).toString());
						System.out.println();
						System.out.println("Increase = $" + String.format("%.2f", increase));
						System.out.println("Discount = $" + String.format("%.2f", discount));
						System.out.println("Total Price = " + String.format("%.2f", totalPrice));
						System.out.println();
						
						
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 4: //rent book
					try {
						System.out.println();
						System.out.println("Users on system:");
						for(User user: userList) 
							System.out.println("ID: [" + userList.indexOf(user) + "] " + user.toString());
						
						//seleciona o usuario,
						System.out.println();
						System.out.print("Type the user id: ");
						int idUser = sc.nextInt();
						while (findUser(userList, idUser) < 0) {
							System.out.println("Id not found. Try again.");
							idUser = sc.nextInt();
						}
						int indexUser = findUser(userList, idUser);
						
						System.out.println("Books on system:");
						System.out.println();
						for(Book book: bookList) {
							if (!(book instanceof BestSellerBook)) {
								if (userList.get(indexUser) instanceof PremiumUser)
									System.out.println("ID: [" + bookList.indexOf(book) + "] " + book.toString());
								else if (!(book instanceof PremiumBook))
									System.out.println("ID: [" + bookList.indexOf(book) + "] " + book.toString());
							}
						}
						//seleciona o livro
						System.out.println();
						System.out.print("Type the book id: ");
						int idBook = sc.nextInt();
						while (findBook(bookList, idBook) < 0) {
							System.out.println("Id not found. Try again.");
							idBook = sc.nextInt();
						}
						int indexBook = findBook(bookList, idBook);
						
						
						//calculando o aluguel
						double totalPrice = bookList.get(indexBook).rentBook(userList.get(indexUser));
						double increase = totalPrice - ((bookList.get(indexBook).getPrice() / 3));
						
						
						//informacoes do aluguel
						System.out.println();
						System.out.println("---RENT INFO---");
						System.out.println("User =  " + userList.get(indexUser).toString());
						System.out.println("Book =  " + bookList.get(indexBook).toString());
						System.out.println();
						System.out.println("Increase = $" + String.format("%.2f", increase));
						System.out.println("Total Price = " + String.format("%.2f", totalPrice));
						System.out.println("Total rents/reads = " + bookList.get(indexBook).getCount());
						System.out.println();
						
						
						
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 5: //read book 
					try {
						System.out.println();
						System.out.println("Users on system:");
						for(User user: userList) 
							System.out.println("ID: [" + userList.indexOf(user) + "] " + user.toString());
						
						//seleciona o usuario,
						System.out.println();
						System.out.print("Type the user id: ");
						int idUser = sc.nextInt();
						while (findUser(userList, idUser) < 0) {
							System.out.println("Id not found. Try again.");
							idUser = sc.nextInt();
						}
						int indexUser = findUser(userList, idUser);
						
						System.out.println("Books on system:");
						System.out.println();
						for(Book book: bookList) {
							if (!(book instanceof BestSellerBook)) 
									System.out.println("ID: [" + bookList.indexOf(book) + "] " + book.toString());
						}
						
						//seleciona o livro
						System.out.println();
						System.out.print("Type the book id: ");
						int idBook = sc.nextInt();
						while (findBook(bookList, idBook) < 0) {
							System.out.println("Id not found. Try again.");
							idBook = sc.nextInt();
						}
						int indexBook = findBook(bookList, idBook);
						
						
						//calculando o aluguel
						double totalPrice = bookList.get(indexBook).readBook(userList.get(indexUser));
						double increase = totalPrice - ((bookList.get(indexBook).getPrice() / 5));
						
						//calculando desconto
						if (userList.get(indexUser) instanceof GeekUser || userList.get(indexUser) instanceof PremiumUser) {
							totalPrice = 0.0;
						}
						
						
						//informacoes do aluguel
						System.out.println();
						System.out.println("---READ INFO---");
						System.out.println("User =  " + userList.get(indexUser).toString());
						System.out.println("Book =  " + bookList.get(indexBook).toString());
						System.out.println();
						System.out.println("Increase = $" + String.format("%.2f", increase));
						System.out.println("Total Price = $" + String.format("%.2f", totalPrice));
						System.out.println();
						
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;

				case 6: //promotion
				
					break;

				case 0: 
					System.out.println("System off");
				default:
					break;
				}
		}while(op != 0);
		sc.close();
	}
	
	public static int findUser(List<User> list, int id) {
		for (User user: list)
			if (list.indexOf(user) == id)
				return list.indexOf(user);
		return -1;
	}
	public static int findBook(List<Book> list, int id) {
		for (Book book: list)
			if (list.indexOf(book) == id)
				return list.indexOf(book);
		return -1;
	}
	
	private static List<Book> initializeBooks(List<Book> list) {
		list.add(new Book("O alienista", "Machado de Assis", "Principis", "Ficcao", 14.50, 22));
		list.add(new BestSellerBook("O Codigo de Da Vinci", "Dan Brown", "Handom House", "Suspense", 58.50, 1));
		list.add(new BestSellerBook("O menino grande", "Dan Brown", "Random House", "Suspense", 80.25, 23));
		list.add(new PremiumBook("O martelo", "Joseph Mbappe", "Mullan Bruks", "Acao", 60.50, 13));
		list.add(new NewlyReleasedBook("Um novo mundo", "Lucy", "Amazon", "Romance", 10.50, 22));
		return list;
	}
	private static List<User> initializeUsers(List<User> list) {
		list.add(new User("Leandro Pet", "Rua dubai, 7, Boa esperanca, Cuiaba-MT", "54876859784"));
		list.add(new GeekUser("Cesar Pombo", "Rua alakasam, 22, Boa esperanca, Cuiaba-MT", "74876845784"));
		list.add(new PremiumUser("Guilherme Seni", "Rua muamba, 13, Coxipo, Cuiaba-MT", "78876669784"));
		list.add(new BookwormUser("Casemiro Vasco", "Rua laura, 50, Santa rosa, Cuiaba-MT", "56976859784"));
		return list;
	}
}
