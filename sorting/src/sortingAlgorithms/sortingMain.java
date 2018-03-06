package sortingAlgorithms;

import sortingAlgorithms.bubbleSort;
import sortingAlgorithms.quickSort;
import sortingAlgorithms.mergeSort;

public class sortingMain {

	public static void main(String[] args) {
		System.out.println("We are sorting!");
		
		int [] arr = new int [] {3, 1, 6, 7, 4, 8, 9, 20, 2, 10};
		
		//BubbleSort: 
//		bubbleSort bubbleSort = new bubbleSort();
//		bubbleSort.optimizedSort(arr);
//		bubbleSort.basicSort(arr);
		
		//QuickSort: 
//		quickSort quickSort = new quickSort(arr);
//		quickSort.sort(arr, 0, arr.length - 1, 0);
//		quickSort.print(arr);
		
		//MergeSort: 
		mergeSort mergeSort = new mergeSort(arr);
		mergeSort.sort(arr);
		mergeSort.print(arr);
		
	}


}
