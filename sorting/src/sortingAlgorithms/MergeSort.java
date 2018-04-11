package sortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
	
	private int[] arr; 
	private int[] helper;
	private int length;
	
	public MergeSort(int[] arr) {
		System.out.println("*Initiated MergeSort*");
		System.out.println("MergeSort has to create a copy of the collection i.e. NOT inline");
		System.out.println();
		System.out.println("MergeSort: O(n log(n)) ");
		System.out.println(" -Original: " + Arrays.toString(arr));
		System.out.println();
	}
	
	public void sort(int[] arr) {
		this.arr = arr;
		length = arr.length;
		this.helper = new int [length];
		mergeSort(0, length - 1);
	}
	
	public void mergeSort(int low, int high) {
		// Check if low is smaller than high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergeSort (low, middle);
			// Sort the right side of the array 
			mergeSort (middle + 1, high);
			// Combine them both 
			merge(low, middle, high);
		}
	}
	
	private void merge(int low, int middle, int high) {
		// Copy both parts into the ans array
		for (int i = low; i <= high; i++) {
			helper[i] = arr[i];
		}
		
		int i = low;
		int j = middle + 1; 
		int k = low;
		
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				arr[k] = helper[i];
				i++;
			} else {
				arr[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle ) {
			arr[k] = helper[i];
			k++;
			i++;
		}
		// Since we are sorting in-place any left over elements from the right side
		// are already at the right position
	}
	
	public void print(int[] arr) {
		System.out.println();
		System.out.println(" -After: " + Arrays.toString(arr));
	}
}
