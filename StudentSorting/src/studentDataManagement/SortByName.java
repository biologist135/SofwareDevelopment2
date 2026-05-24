package studentDataManagement;

import java.util.Comparator;
//Developed comparator for the sort by the student's name variable.

public class SortByName implements Comparator <Student>{
//overrode the compare method to compare strings using the compareTo method to compare names from student1 and student2.
	//This method will return an int that is positive or negative which will determine its order using selection sort.
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getName().compareTo(s2.getName());
	}
}
