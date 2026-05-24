package studentDataManagement;

import java.util.Comparator;
//Developed comparator for the sort by the rollno variable.

public class SortByRollno implements Comparator<Student>{
	
	//The output will provide a positive number, a negative number, or zero (If there are duplicate roll numbers)
	//This will indicate how the sort select method will order the objects.
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getRollNo() - s2.getRollNo();
	}
	
}
