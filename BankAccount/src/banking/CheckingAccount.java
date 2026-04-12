package banking;

public class CheckingAccount extends BankAccount {
	private double interestRate;
	private double overDraftFee;
	
	public CheckingAccount(String firstName, String lastName, int accountID) {
		super(firstName, lastName, accountID);
		interestRate = 0.0007;
		overDraftFee = 30.0;
		
	}
	
	public void processWithdrawal(double takeMoney) {
		super.withdrawal(takeMoney);
		if(super.getBalance() < 0) {
			super.withdrawal(overDraftFee);
			System.out.print("A fee has been applied to your account: ");
			System.out.printf("%.2f", super.getBalance());
			System.out.println(" Dollars");
		}
		else {
			System.out.printf("$%.2f%n", super.getBalance());
		}
	}
	
	public void displayAccount() {
		super.accountSummary();
		System.out.println("Interest Rate: %" + (interestRate * 100));
		
	}
}
