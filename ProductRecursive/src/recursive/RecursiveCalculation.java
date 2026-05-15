package recursive;

import java.util.Scanner;
import java.util.InputMismatchException;

public class RecursiveCalculation {
	/*My recursive function that takes a single number 5 times from the user. Evaluates that it is valid and then 
	 * returns that number times the recursive function with a reduced count. Once the base case is reached 
	 * it returns a 1 resulting in the final product being 1 times the the returned values from the recursive case.
	 */
	public static int productNumbers(int count, Scanner scanner) {
		int number;
		
		if (count <=0) {
			return 1;
		}
		
		number = getValidInt(scanner);
		return number * productNumbers(count - 1, scanner);
		}
		
	/*I kept running into issues with breaking the program so i decided to create a method to run a while loop with 
	 * try catch to as a way to control the input of the user.
	 * During development I was also running into errors with clearing the scanner. scanner.nextLine() supported with this.
	 */
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
	//main to run the method productNumbers. I passed value which correlates with the 5 numbers and also passed a scanner parameter.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int value = 5;
		int result = productNumbers(value, scanner);
		
		System.out.println("The product calculated with the " + value + " numbers selected is " + result +".");
	}

}
