package studentDataManagement;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {
	public static ArrayList<Student> mergeSort(ArrayList<Student> list, Comparator<Student> comparator) {
		if (list.size()<= 1) {
			return list;
		}
		int middle = list.size()/2;
		ArrayList<Student> left = new ArrayList<Student>();
		ArrayList<Student> right = new ArrayList<Student>();
		
		for (int i = 0; i < middle; i++) {
			left.add(list.get(i));
		}
		for (int i = middle; i < list.size(); i++) {
			right.add(list.get(i));
		}
		left = mergeSort(left, comparator);
		right = mergeSort(right,comparator);
		
		return merge(left, right, comparator);
	}
	public static ArrayList<Student> merge(ArrayList<Student> left, ArrayList<Student> right, Comparator<Student> comparator){
		ArrayList <Student> merged = new ArrayList<Student>();
		
		int leftIndex = 0;
		int rightIndex = 0;
		
		while(leftIndex < left.size() && rightIndex < right.size()) {
			if(comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0) {
				merged.add(left.get(leftIndex));
				leftIndex++;
				
			}
			else {
				merged.add(right.get(rightIndex));
				rightIndex++;
			}
		}
		while(leftIndex < left.size()) {
			merged.add(left.get(leftIndex));
			leftIndex++;
		}
		while (rightIndex < right.size()) {
			merged.add(right.get(rightIndex));
			rightIndex++;
		}
		return merged;
	}

}
