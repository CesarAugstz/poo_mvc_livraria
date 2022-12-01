package db;

import java.util.ArrayList;
import java.util.List;

import model.entities.BestSellerBook;
import model.entities.Book;
import model.entities.BookwormUser;
import model.entities.GeekUser;
import model.entities.NewlyReleasedBook;
import model.entities.PremiumBook;
import model.entities.PremiumUser;
import model.entities.Read;
import model.entities.Rent;
import model.entities.Sale;
import model.entities.User;

public class MainDB {

	private List<Book> bookList = new ArrayList<>();
	private List<User> userList = new ArrayList<>();
	private List<Sale> saleList = new ArrayList<>();
	private List<Rent> rentList = new ArrayList<>();
	private List<Read> readList = new ArrayList<>();
	
	
	public MainDB() {
		bookList = initializeBooks(bookList);
		userList = initializeUsers(userList);
	}
	
	public void addNewUser(User user) {
		userList.add(user);
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public void addNewBook(Book book) {
		bookList.add(book);
	}
	
	
	public List<Sale> getSaleList() {
		return saleList;
	}

	public List<Rent> getRentList() {
		return rentList;
	}

	public List<Read> getReadList() {
		return readList;
	}

	public void addNewSale(Sale sale) {
		saleList.add(sale);
	}
	
	public void addNewRead(Read read) {
		readList.add(read);
	}
	
	public void addNewRent(Rent rent) {
		rentList.add(rent);
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
