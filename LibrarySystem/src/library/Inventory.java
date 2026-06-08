package library;

import java.util.ArrayList;


public class Inventory {
	
	//instantiation of the Book ArrayLists for inventory and borrowed, as well as a bookIDIncrement value.
	static int bookIDIncrement = 0;
	ArrayList<Book> inventory = new ArrayList<Book>();
	ArrayList<Book> borrowed = new ArrayList<Book>();
	
	//method to add book using the setters to establish the object.
	public void addBook(int id, String title, String author, String isbn, int numPages) {
		Book newBook = new Book();
		newBook.setID(id);
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setISBN(isbn);
		newBook.setNumPages(numPages);
		
		inventory.add(newBook);	
	}
	
	//Possible solution to unique ID implementation that would automatically assign a unique ID to a book object.
	public static int incrementID() {
		return bookIDIncrement++;
	}
	
	//Implemented as a refactor to allow for users to select their own book ID. logic checks both the inventory and borrowed for existing matching IDs.
	public boolean uniqueIDCheck(int ID) {
		boolean match = false;
		
		for (int i = 0; i < inventory.size(); i++) {
			if (ID == inventory.get(i).getID()) {
				match = true;
				break;
			}
		}
		for (int i = 0; i < borrowed.size(); i++) {
			if (ID == borrowed.get(i).getID()) {
				match = true;
				break;
			}
		}
		
	return match;
	}
	//returns a message indicating that the book was borrowed, or lets the user know the book doesnt exist or is currently checked out depending on the input entered.
	public String borrowBook(int id) {
		//Checks borrowed first to ensure that the book is not already checked out
		for (int i = 0; i < borrowed.size(); i++) {
			if(borrowed.get(i).getID() == id) {
				return "The book is currently being borrowed.";
			}
		}
		//Checks if there are any books.
		if (inventory.isEmpty()) {
			return "There are currently no available books to borrow."