package banking;

public class Test {

	public static void main(String[] args) {
		BankAccount account = new BankAccount("Benjamin", "Platt", 123);
		CheckingAccount checking = new CheckingAccount("Christopher", "Platt", 234);
		
		
		//Testing BankAccount Class
		account.deposit(500.00);
		System.out.printf("$%.2f%n",account.getBalance());
		//Expected result is 500 dollar balance.
		
		account.withdrawal(200.00);
		System.out.printf("$%.2f%n",account.getBalance());
		//Expected result is 300 dollar balance.
		
		account.withdrawal(400);
		//Expected "Insufficient funds"
		
		System.out.printf("$%.2f%n",account.getBalance());
		//Expected Balance would be 300 dollars due to no withdrawal occurring.
		
		account.accountSummary();
		
		checking.deposit(300.0);
		checking.processWithdrawal(400);
		checking.displayAccount();
	}

}
