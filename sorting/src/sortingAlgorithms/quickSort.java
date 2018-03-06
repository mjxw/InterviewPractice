package sortingAlgorithms;

import java.util.Arrays;

public class quickSort {

	public quickSort(int[] arr) {
		System.out.println("*Initiated QuickSort*");
		System.out.println("QuickSort can sort inline an existing collection");
		System.out.println();
		System.out.println("QuickSort: O(n log(n)) ");
		System.out.println(" -Original: " + Arrays.toString(arr));
		System.out.println();
	}
	
	public void sort(int[] arr, int low, int high, int iter) {
		int i = low; 
		int j = high;
		// Set pivot element from the middle of the array
		int pivot = arr[low + (high - low) / 2];
		
		System.out.println("Pivot: " + pivot);
		System.out.println("    -Iteration " + (iter + 1) + ": " + Arrays.toString(arr));
		
		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller than the pivot
			// element, then get the next element from the left list
			while (arr[i] < pivot) {
				i++;
			}
			// If the current value from the right list is larger than the pivot
			// element, then get the next element from the right list
			while(arr[j] > pivot) {
				j--;
			}
			
			/*
			 * If we have found a value in the left list which is larger than 
			 * the pivot element and if we have found a value in the right list 
			 * which is smaller than the pivot element, then we exchange the 
			 * values. 
			 * As we are done, we can increase i and j
			 */
			
			if (i <= j) {
				exchange(arr, i, j);
				i++;
				j--;
			}
		}
		
		//Recursion
		if (low < j ) {
			sort(arr, low, j, iter++);
		}
		if (i < high) {
			sort(arr, i, high, iter++);
		}
	}
	
	private void exchange (int[] arr, int i, int j ) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void print(int[] arr) {
		System.out.println();
		System.out.println(" -After: " + Arrays.toString(arr));
	}
	
}
