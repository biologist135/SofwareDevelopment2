package recursive;

import java.util.Scanner;
import java.util.InputMismatchException;

public class RecursiveCalculation {
	
	public static int sumNumbers(int count, Scanner scanner) {
		int number;
		
		if (count <=0) {
			return 0;
		}
		
		number = getValidInt(scanner);
		return number + sumNumbers(count - 1, scanner);
		}
		
	
	public static int getValidInt(Scanner scanner) {
		while (true) {
			try {
				System.out.println("Please enter a number you would like to add.");
				return scanner.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("That is not a valid input. Please enter a whole number!");
				scanner.nextLine();
			}
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int value = 7;
		int result = sumNumbers(value, scanner);
		
		System.out.println("The sum of numbers from the " + value + " numbers selected is " + result);
	}

}
