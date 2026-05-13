package recursive;

import java.util.Scanner;
import java.util.InputMismatchException;

public class RecursiveCalculation {
	
	public static int productNumbers(int count, Scanner scanner) {
		int number;
		
		if (count <=0) {
			return 1;
		}
		
		number = getValidInt(scanner);
		return number * productNumbers(count - 1, scanner);
		}
		
	
	public static int getValidInt(Scanner scanner) {
		while (true) {
			try {
				System.out.println("Please enter a number you would like to multiply.");
				return scanner.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("That is not a valid input. Please enter a whole number!");
				scanner.nextLine();
			}
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int value = 5;
		int result = productNumbers(value, scanner);
		
		System.out.println("The product calculated with the " + value + " numbers selected is " + result +".");
	}

}
