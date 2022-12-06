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
import model.entities.Promotion;
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
	private List<Promotion> promotionList = new ArrayList<>();

	public MainDB() {
		bookList = initializeBooks(bookList);
		userList = initializeUsers(userList);
		promotionList = initializePromotions(promotionList);
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

	public List<Promotion> getPromotionList() {
		return promotionList;
	}

	public void setPromotionList(List<Promotion> promotionList) {
		this.promotionList = promotionList;
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
		list.add(new BookwormUser("Fred Deus", "Rua ferias, 14, Centro, Cuiaba-MT", "66987654323"));
		return list;
	}

	private static List<Promotion> initializePromotions(List<Promotion> list) {
		list.add(new Promotion("Sextou", 1, "Toda sexta 5% de desconto"));
		list.add(new Promotion("FDS", 2, " 10% sabado e domingo"));
		list.add(new Promotion("Black fraude", 7, "15% de desconto por 7 dias"));
		list.add(new Promotion("Duplo livro", 3, "20% de desconto na compra de 2 livros"));
		list.add(new Promotion("Segundou", 1, "5% de desconto toda segunda"));
		return list;
	}

}
