package studentDataManagement;

import java.util.ArrayList;
import java.util.Comparator;

//created a selection sort class which has a method selectionSort().
public class SelectionSort {
	
	//selectionSort() takes in an ArrayList and a Comparator to determine how to order the objects.
	public static void selectionSort(ArrayList<Student> students, Comparator<Student> comparator) {
		//the outside loop controls the working index.
		for (int i = 0; i < students.size() - 1; i++) {
			//establish the minIndex as equal to the current working index
			int minIndex = i;
			//The inner for loop iterates through the index beyond where the working index is to compare the values based on the comparator.
			//it looks at the current minIndex, and the index j and sees if the comparator returns a value less than 0 indicating that the current
			//j index is less than what is set as minIndex.
			for(int j = i + 1; j < students.size(); j++) {
				if (comparator.compare(students.get(j), students.get(minIndex)) < 0) {
					//If a negative value is identified, it take the current j index and makes it minIndex.
					minIndex = j;
				}
			}
			//After iterating through the ArrayList with the inner loop, it will set index i as temp index, set i as the minIndex and then set minIndex as temp
			//This results in no values being lost, and re orders the values based on the comparator selected.
			Student temp = students.get(i);
			students.set(i, students.get(minIndex));
			students.set(minIndex, temp);
			
		}
	}

}
