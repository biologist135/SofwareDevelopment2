package banking;

public class Test {

	public static void main(String[] args) {

		testDeposit();
		testWithdrawal();
		testInsufficientFunds();
		testAccountSummary();
		testProcessWithdrawal();
		testDisplayAccount();
		
		
	}
	//Testing BankAccount Deposit Method.
	public static void testDeposit() {
		BankAccount account = new BankAccount("Benjamin", "Platt", 123);
		account.deposit(200.0);
		double expected = 200.0;
		double actual = account.getBalance();
		
		if (actual != expected) {
			System.out.println("FAIL: Deposit test - Expected " + expected + " but got " + actual);
		}
		else {
			System.out.println("PASS: Deposit Test");
		}
	}
	
	//Testing BankAccount Withdrawal Method.
	public static void testWithdrawal() {
		BankAccount account = new BankAccount("Benjamin", "Dixon", 234);
		account.deposit(200.0);
		account.withdrawal(50.0);
		
		double expected = 150.0;
		double actual = account.getBalance();
		
		if(actual != expected) {
			System.out.println("Fail: Withdrawal test - Expected " + expected + " but got " + actual);
		}
		else {
			System.out.println("PASS: Withdrawal test");
		}
	}
	//Testing BankAccounts Withdrawal Method for edge cases that indicate insufficient funds for withdrawal
	public static void testInsufficientFunds() {
		BankAccount account = new BankAccount("Matthew", "Dixon", 145);
		account.deposit(200.0);
		account.withdrawal(250.0);
		
		double expected = 200.0;
		double actual = account.getBalance();
		
		if (actual != expected) {
			System.out.println("Fail: Withdrawal test - insufficient funds - Expected " + expected + " but got " + actual);
		}
		else {
			System.out.println("PASS: Withdrawal test - insufficient funds.");
		}
	}
	//visual check of BankAccount accountSummary method.
	public static void testAccountSummary() {
		BankAccount account = new BankAccount("Christopher", "Platt", 456);
		
		System.out.println();
		System.out.println("EXPECTED VALUE");
		System.out.println("First Name: Christopher");
		System.out.println("Last Name: Platt");
		System.out.println("Account ID: 456");
		System.out.println("Account Balance: $0.00");
		
		System.out.println();
		System.out.println("ACTUAL VALUE");
		account.accountSummary();
		System.out.println();
		
	}
	
	public static void testProcessWithdrawal() {
		CheckingAccount checking = new CheckingAccount("Benjamin", "Platt", 567);
		checking.deposit(200.00);
		checking.processWithdrawal(50);
		
		double expected = 150.0;
		double actual = checking.getBalance();
		
		if(actual != expected) {
			System.out.println("Fail: Process Withdrawal test - Expected " + expected + " but got " + actual);
			System.out.println();
		}
		else {
			System.out.println("PASS: Process Withdrawal test");
			System.out.println();
		}
		
		checking.processWithdrawal(250.0);
		
		expected = -130.0;
		actual = checking.getBalance();
		
		if(actual != expected) {
			System.out.println("Fail: Process Withdrawal Overdraft test - Expected " + expected + " but got " + actual);
		}
		else {
			System.out.println("PASS: Process withdrawal Overdraft test");
		}
		
		
	}
	
	public static void testDisplayAccount() {
		CheckingAccount checking = new CheckingAccount("Benjamin", "Platt", 1354);
		checking.deposit(250);
		
		System.out.println();
		System.out.println("EXPECTED VALUE");
		System.out.println("First Name: Benjamin");
		System.out.println("Last Name: Platt");
		System.out.println("Account ID: 1354");
		System.out.println("Account Balance: $250.00");
		System.out.println("Interest Rate: 0.07%");
		
		System.out.println();
		System.out.println("ACTUAL VALUE");
		checking.displayAccount();
	}

}
