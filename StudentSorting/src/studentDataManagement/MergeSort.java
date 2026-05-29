package studentDataManagement;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * The goal of this was to refactor to incorporate a merge sort instead of selection sort to use recursion and also to play with
 * a more complex sorting process.
 * The merge sort is made up of two processes the merge sort which separates the list into its smaller parts, and the merge portion which 
 * puts the items back together in the correct order.
 */
public class MergeSort {
	//Method implemented to return an ArrayList taking an ArrayList and a Comparator
	public static ArrayList<Student> mergeSort(ArrayList<Student> list, Comparator<Student> comparator) {
		//Base case is returning a list when we hit size of 1 or less.
		if (list.size()<= 1) {
			return list;
		}
		//Identified the middle of the list and developed an ArrayList that represented the left and right side
		int middle = list.size()/2;
		ArrayList<Student> left = new ArrayList<Student>();
		ArrayList<Student> right = new ArrayList<Student>();
		
		//Allocated values from index 0 to the calculated middle of the ArrayList to the left ArrayList.
		for (int i = 0; i < middle; i++) {
			left.add(list.get(i));
		}
		//Allocated values from the middle of the ArrayList to list.size()-1 to the right ArrayList.
		for (int i = middle; i < list.size(); i++) {
			right.add(list.get(i));
		}
		//implemented recursion to call for the left and right list.
		left = mergeSort(left, comparator);
		right = mergeSort(right,comparator);
		//returned a method that merged the lists back together in the right order using the specified comparator.
		return merge(left, right, comparator);
	}
	//merge method which takes the right and left ArrayList and uses the comparator to compare each ArrayList item.
	public static ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right, Comparator<Student> comparator){
		//Establishes a new ArrayList called merged provides a data structure for the final order of the sorted Students.
		ArrayList <Student> merged = new ArrayList<Student>();
		
		//Variables to manage both the left ArrayList index and the right ArrayList index.
		int leftIndex = 0;
		int rightIndex = 0;
		
		//A while loop which runs until we reach the end of each of the ArrayLists.
		while(leftIndex < left.size() && rightIndex < right.size()) {
			//Implements the comparator comparing the left Student and right Student to evaluate for a negative return.
			//if the value is negative the student from the right ArrayList is added to merged List.
			if(comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0) {
				merged.add(left.get(leftIndex));
				leftIndex++;
				
			}
			//If the comparator returns a positive value, we would add the right index to merged.
			else {
				merged.add(right.get(rightIndex));
				rightIndex++;
			}
		}
		//This while loop kicks in if the right side runs out of values and continues to add in all additional Students from the left ArrayList
		while(leftIndex < left.size()) {
			merged.add(left.get(leftIndex));
			leftIndex++;
		}
		//This while loop kicks in if the left side runs out of values and continues to add in all additional students from the right ArrayList
		while (rightIndex < right.size()) {
			merged.add(right.get(rightIndex));
			rightIndex++;
		}
		//Returns the merged arraylist.
		return merged;
	}
	//At the collapse of the recursion within the mergeSort method, it will take and combine all of the objects in the order.

}
