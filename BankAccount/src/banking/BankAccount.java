package banking;

public class BankAccount {
	String firstName;
	String lastName;
	int accountID;
	double balance;
	
	public  BankAccount() {
		firstName = "NO FIRST NAME";
		lastName = "NO LAST NAME";
		accountID = -1;
		balance = 0.0;
	}
	
	public BankAccount(String firstName, String lastName, int accountID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		this.balance = 0.0;
	}
	
	public double deposit(double addMoney) {
		if (addMoney > 0 ) {
			balance = balance + addMoney;
			
		}
		else {
			System.out.println("This is not a valid deposit.");
					
		}
		return balance;
	}
	public double withdrawal(double takeMoney) {
		if (takeMoney > 0) {
			balance = balance - takeMoney;
		}
		else {
			System.out.println("This is not a valid withdrawal.");
		}
		return balance;
	}
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

	
	public void accountSummary() {
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Account ID: " + accountID);
		System.out.println("Account Balance: " + balance);
	}

}
