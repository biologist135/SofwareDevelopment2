package studentDataManagement;
import java.util.ArrayList;

public class StudentTest {
	//Main Class
	public static void main(String[] args) {
		//Implements an ArrayList titled students.
		ArrayList<Student> students = new ArrayList<Student>();
		
		//Adds 10 students into the students ArrayList with no specified order
		students.add(new Student(5, "Benjamin", "Phoenix"));
		students.add(new Student(2, "Joe", "Tempe"));
		students.add(new Student(8, "Marianne","Roseville"));
		students.add(new Student(1, "Christopher", "Witmann"));
		students.add(new Student(10, "Matthew", "Scottsdale"));
		students.add(new Student(4, "Tina", "Litchfield Park"));
		students.add(new Student(7, "Rowena", "Hogwarts"));
		students.add(new Student(3, "Morgan", "Buckeye"));
		students.add(new Student(9, "Britney", "Surprise"));
		students.add(new Student(6, "James", "White Chapel"));
		
		//Prints the unordered list
		System.out.println("Unordered List: ");
		printStudents(students);
		
		//runs MergeSort on the students ArrayList using the sortByRollno() comparator.
		students = MergeSort.mergeSort(students, new SortByRollno());
		//Prints out the sorted ArrayList by roll number.
		System.out.println("\nSorted by Roll Number:");
		printStudents(students);
		
		//runs MergeSort on the students ArrayList using the sortByName() comparator.
		students = MergeSort.mergeSort(students,new SortByName());
		//Prints out the sorted ArrayList by name.
		System.out.println("\nSorted by Name:");
		printStudents(students);
	}
	
	//Created a method to print out the ArrayList. iterates through the students ArrayList and prints out each student.
	public static void printStudents(ArrayList<Student> students) {
		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i));
		}
	}

}
