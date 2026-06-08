package library;

import java.util.Scanner;
import java.util.InputMismatchException;

public class BookInventoryManager {
	//establishes an inventory and a scanner as private.
	private Inventory inventory;
	private Scanner scnr;

	//Creates a new inventory, Scanner, and BookInventoryManager which takes the inventory and scanner.
	//Generates the menuState for the bim.
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		Scanner scnr = new Scanner(System.in);
		BookInventoryManager bim = new BookInventoryManager(inventory, scnr);
		bim.menuState(inventory,scnr);

	}
	//Constructor for the BookInventoryManager.
	public BookInventoryManager(Inventory inventory, Scanner scnr) {
		this.inventory = inventory;
		this.scnr = scnr;
	}
	//Menu calls specific methods when a menu number is selected. Exits on 6.
	public void menuState(Inventory inventory, Scanner scnr) {
		int userInput = -1;
		
		do {
			try {
				System.out.println("1. Add Book		3. Return Book		5. Print All Books");
				System.out.println("2. Borrow Book		4. Search by Title	6. Exit");
				userInput = scnr.nextInt();
				scnr.nextLine();
				if(userInput == 1) {
					addBook(inventory, scnr);
					
					System.out.println();
				}
				else if (userInput == 2) {
					borrow(inventory, scnr);
				}
				else if (userInput == 3) {
					inventory.printAllBorrowed();
					bookReturn(inventory,scnr);
				}
				else if (userInput == 4) {
					searchTitle(inventory,scnr);
				}
				else if (userInput == 5) {
					inventory.printAllBooks();
				}
				else if (userInput == 6) {
					System.out.println("Exiting the program. Goodbye!");
				}
				else {
					System.out.println("Please enter a number between 1 and 6.");
				}
			}catch(InputMismatchException e) {
				System.out.println("Please enter the number corresponding to the action you want to perform.");
				scnr.nextLine();
			}
		}while(userInput != 6);
		
	}
	//Addbook method. Prompts the user to provide user input related to the books they want to add to inventory.
	public void addBook(Inventory inventory, Scanner scnr) {
		int id = -1;
		String title = null;
		String author = null;
		String is