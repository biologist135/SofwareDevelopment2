package banking;

public class CheckingAccount extends BankAccount {
	private double interestRate;
	private double overDraftFee;
	
	//Checking account parameterized constructor including the superclass information.
	//I did this because I wanted to be able to call the method accountSummary and getBalance.
	public CheckingAccount(String firstName, String lastName, int accountID) {
		super(firstName, lastName, accountID);
		interestRate = 0.0007;
		overDraftFee = 30.0;
		
	}
	//Overrode the withdrawal method because I wanted to allow checking accounts to overdraft.
	//For the superclass there is an if statement that prevents users from pulling out more money than was in the account.
	@Override
	public double withdrawal(double takeMoney) {
		if (takeMoney > 0) {
			balance = balance - takeMoney;
		}
		else {
			System.out.println("This is not a valid withdrawal.");
		}
		return balance;
	}
	//implemented using the overridden withdrawal method and printed out if a fee was incurred.
	public void processWithdrawal(double takeMoney) {
		withdrawal(takeMoney);
		if(super.getBalance() < 0) {
			withdrawal(overDraftFee);
			System.out.print("A $30.00 overdraft fee has been applied to your account.\nCurrent Balance: ");
			System.out.printf("%.2f", super.getBalance());
			System.out.println(" Dollars");
		}
		else {
			System.out.printf("Current Balance: $%.2f%n", super.getBalance());
		}
	}
	
	public void displayAccount() {
		super.accountSummary();
		System.out.print("Interest Rate: ");
		System.out.printf("%.2f",interestRate * 100.0);
		System.out.println("%");
		
	}
}
