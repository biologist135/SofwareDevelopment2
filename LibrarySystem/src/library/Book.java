package library;

public class Book {
	
	private int id;
	private String title;
	private String author;
	private String isbn;
	private int numPages;
	
	// Non paramaterized constructor.
	public Book() {
		id = -1;
		title = "NO TITLE";
		author = "NO AUTHOR";
		isbn = "978-0-12-345678-9";
		numPages = -1;
	}
	//Paramaterized constructor. Utilized the set methods as a way to manage inputs when building the book object.
	public Book(int id, String title, String author, String isbn, int numPages) {
		setID(id);
		setTitle(title);
		setAuthor(author);
		setISBN(isbn);
		setNumPages(numPages);
	}
	//getters and setters.
	public void setID (int id) {
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	
	public void setTitle(String title) {
		if (title == null || title.trim().isEmpty()) {
			this.title = "NO TITLE";
		}
		else {
			this.title = title.trim();
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setAuthor(String author) {
		if(author == null || author.trim().isEmpty()) {
			this.author ="NO AUTHOR";
		}
		else {
			this.author = author;
		}
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setISBN (String isbn) {
		if (isbn == null || isbn.trim().isEmpty()) {
			this.isbn = "NO ISBN";
		}
		else {
			this.isbn = isbn;
		}
	}
	
	public String getISBN() {
		return isbn;
	}
	
	public void setNumPages(int numPages) {
		if(numPages > 0) {
			this.numPages = numPages;
		}
		else {
			this.numPages = 1;
		}
	}
	
	public int getNumPages() {
		return numPages;
	}
	
	//Required meth