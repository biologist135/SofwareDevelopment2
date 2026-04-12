package banking;

public class Test {

	public static void main(String[] args) {
		BankAccount a = new BankAccount("Benjamin", "Platt", 123);
		CheckingAccount c = new CheckingAccount("Christopher", "Platt", 234);
		
		a.deposit(200.0);
		c.deposit(300.0);
		a.withdrawal(100.0);
		c.processWithdrawal(400);
		System.out.println();
		c.displayAccount();
		System.out.println();
		a.accountSummary();
		System.out.println();
	}

}
