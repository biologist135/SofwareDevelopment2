package banking;

public class Test {

	public static void main(String[] args) {

		testDeposit();
		testWithdrawal();
		testInsufficientFunds();
		testProcessWithdrawal();
		testAccountSummary();
		testDisplayAccount();
		
		
	}
	//Testing BankAccount Deposit Method.
	public static void testDeposit() {
		//checking for normal function.
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
		//checking for zero input
		account.deposit(0.0);
		expected = 200.0;
		actual = account.getBalance();
		
		if(actual != expected) {
			System.out.println("FAIL: Deposit Test(0.0) - Expected " + expected + " but got " + actual);
		}
		else {
			System.out.println("PASS: Deposit Test (0.0)");
		}
		//checking for negative input
		account.deposit(-100.0);
		expected = 200.0;
		actual = account.getBalance();
		
		if(actual != expected) {
			System.out.println("FAIL: Deposit Test(negative) - Expected " + expected + " but got " + actual);
		}
		else {
			System.out.println("PASS: Deposit Test(negative)");
		}
	}
	
	//Testing BankAccount Withdrawal Method.
	public static void testWithdrawal() {
		BankAccount account = new BankAccount("Benjamin", "Dixon", 234);
		//Normal withdrawal with sufficient funds
		account.deposit(200.0);
		account.withdrawal(50.0);
		
		double expected = 150.0;
		double actual = account.getBalance();
		
		if(actual != expected) {
			System.out.println("FAIL: Withdrawal test - Expected " + expected + " but got " + actual);
		}
		else {
			System.out.println("PASS: Withdrawal test");
		}
		//Withdrawal that brings balance to 0.
		account.withdrawal(150.0);
		expected = 0.0;
		actual = account.getBalance();
		
		if(actual != expected) {
			System.out.println("FAIL: Withdrawal - Edge Case test - Expected " + expected + " but got " + actual);
		}
		else {
			System.out.println("PASS: Withdrawal - Edge Case test");
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
			System.out.println("Fail: Withdrawal test - Insufficient Funds - Expected " + expected + " but got " + actual);
		}
		else {
			System.out.println("PASS: Withdrawal test - Insufficient Funds.");
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
	//Test processWithdrawal() Method for general function, 0 edge case, and overdraft function.
	public static void testProcessWithdrawal() {
		CheckingAccount checking = new CheckingAccount("Benjamin", "Platt", 567);
		//Normal process withdrawal.
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
		//checking process withdrawing to 0.00 in balance.
		checking.processWithdrawal(150.00);
		expected = 0.00;
		actual = checking.getBalance();
		
		if(actual != expected) {
			System.out.println("Fail: Process Withdrawal - Edge Case test - Expected " + expected + " but got " + actual);
			System.out.println();
		}
		else {
			System.out.println("PASS: Process Withdrawal - Edge Case test");
			System.out.println();
		}
		
		//checking process withdrawal that overdrafts and applies an overdraft fee.
		checking.processWithdrawal(250.0);
		
		expected = -280.0;
		actual = checking.getBalance();
		
		if(actual != expected) {
			System.out.println("Fail: Process Withdrawal Overdraft test - Expected " + expected + " but got " + actual);
			System.out.println();
		}
		else {
			System.out.println("PASS: Process withdrawal Overdraft test");
			System.out.println();
		}
		
	}
	public static void testDefaulConstructor() {
		BankAccount account = new BankAccount();
		boolean passed = true;
		
		if(!account.getFirstName().equals("NO FIRST NAME")){
			passed = false;
		}
		if(!account.getLastName().equals("NO LAST NAME")) {
			passed = false;
		}
		if(account.getAccountID() != -1) {
			passed = false;
		}
		if(account.getBalance() != 0.0) {
			passed = false;
		}
		
		if (passed == false) {
			System.out.println("FAIL: Default Constructor Test");
			
		}
		else {
			System.out.println("PASS: Default Constructor Test");
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
