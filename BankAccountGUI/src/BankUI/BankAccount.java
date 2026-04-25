package BankUI;


public class BankAccount {

	double balance;
	public boolean noFund;
	
	//Generalized constructor.
	public  BankAccount() {
		balance = 0.0;
	}
	//Parameterized constructor.
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	//Adds money to the balance variable. Also checks if the money request is greater than zero.
	public double deposit(double addMoney) {
		if (addMoney > 0 ) {
			balance = balance + addMoney;
			
		}
		return balance;	
	}
	//Withdraws money from the balance variable. Checks to see that the input is greater than zero,
	//if false is returned the actionPerformed will return insufficient funds or incorrect input.
	public boolean withdrawal(double takeMoney) {
		if(takeMoney <= 0) {
			return false;
			
		}
		if(balance >= takeMoney) {
			balance -= takeMoney;
			return true;
		}
		return false;
	}
	
	public double getBalance() {
		return balance;
	}

}
