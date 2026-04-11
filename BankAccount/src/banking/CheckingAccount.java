package banking;

public class CheckingAccount extends BankAccount {
	double interestRate = 0.0007;
	double overDraftFee = 30.0;
	BankAccount account = new BankAccount();
	
	public void processWithdrawal(double takeMoney) {
		account.withdrawal(takeMoney);
		if(account.getBalance() < 0) {
			account.setBalance(account.getBalance() - overDraftFee);
			System.out.println(account.getBalance());
			System.out.println("A feel has been applied to your account: -");
			System.out.printf("$%.2f%n", account.getBalance());
			System.out.println();
		}
		else {
			System.out.printf("$%.2f%n", account.getBalance());
		}
	}
	
	public void displayAccount() {
		account.accountSummary();
		System.out.println("Interest Rate: %" + (interestRate * 100));
		
	}
}
