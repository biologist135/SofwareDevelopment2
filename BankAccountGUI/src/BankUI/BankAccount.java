package BankUI;


public class BankAccount {

	String firstName;
	String lastName;
	int accountID;
	double balance;
	public boolean noFund;
	
	//Generalized constructor.
	public  BankAccount() {
		firstName = "NO FIRST NAME";
		lastName = "NO LAST NAME";
		accountID = -1;
		balance = 0.0;
	}
	//Parameterized constructor.
	public BankAccount(String firstName, String lastName, int accountID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = 0.0;
	}
	public BankAccount(double balance) {
		this.balance = balance;
	}
	//Adds money to the balance variable. Also checks if the money request is greater than zero.
	public double deposit(double addMoney) {
		if (addMoney > 0 ) {
			balance = balance + addMoney;
			
		}
		return balance;
		/*
		else {
			System.out.println("This is not a valid deposit.");
				
		}
		return balance;
		*/	
	}
	//Subtracts a set amount of money from the balance variable. Also checks if the money request is greater than zero.
	//also checks that the withdrawal does not overdraft.
	/*public double withdrawal(double takeMoney) {
		noFund = false;
		if (takeMoney > 0) {
			if (balance - takeMoney >= 0) {
				balance = balance - takeMoney;
			}
			else {
				noFund = true;
			}
		}
		else {
			System.out.println("This is not a valid withdrawal request.");
		}
		if (noFund == true) {
			System.out.println("Insufficient Funds");
		}
		return balance;
	}*/
	//Getters and Setters
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAccountID() {
		return this.accountID;
	}
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public double getBalance() {
		return balance;
	}

	// Prints out all data for the account.
	public void accountSummary() {
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Account ID: " + accountID);
		System.out.print("Account Balance: ");
		System.out.printf("$%.2f%n", balance);
	}
	public boolean withdrawalCheck(double takeMoney) {
		if(takeMoney <= 0) {
			return false;
			
		}
		if(balance >= takeMoney) {
			balance -= takeMoney;
			return true;
		}
		return false;
	}

}
