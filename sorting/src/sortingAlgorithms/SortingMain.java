package sortingAlgorithms;

import sortingAlgorithms.BubbleSort;
import sortingAlgorithms.QuickSort;
import sortingAlgorithms.MergeSort;
import sortingAlgorithms.SelectionSort;

public class SortingMain {

	public static void main(String[] args) {
		System.out.println("We are sorting!");
		
		int [] arr = new int [] {3, 1, 6, 7, 4, 8, 9, 20, 2, 10};
		
		//BubbleSort: 
//		BubbleSort bubbleSort = new BubbleSort();
//		bubbleSort.optimizedSort(arr);
//		bubbleSort.basicSort(arr);
		
		//QuickSort: 
//		QuickSort quickSort = new QuickSort(arr);
//		quickSort.sort(arr, 0, arr.length - 1);
//		quickSort.print(arr);
		
		//MergeSort: 
		MergeSort mergeSort = new MergeSort(arr);
		mergeSort.sort(arr);
		mergeSort.print(arr);
		
		//SelectionSort: 
//		SelectionSort selectionSort = new SelectionSort(arr);
//		selectionSort.sort(arr);
	}
	
	


}
