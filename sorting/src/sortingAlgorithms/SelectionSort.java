package sortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {
		
	public SelectionSort(int[] arr) {
		System.out.println("*Initiated SelectionSort*");
		System.out.println();
		System.out.println("SelectionSort: O(n^2) ");
		System.out.println(" -Original: " + Arrays.toString(arr));
		System.out.println();
	}
	
	public int[] sort(int[] arr) {
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i ++) {
			int min_index = i;
			
			for (int j = i+1; j < n; j++) {
				if (arr[j] < arr[min_index]) {
					min_index = j;
				}
			}
			
			//swap 
			int temp = arr[min_index];
			arr[min_index] = arr[i]; 
			arr[i] = temp;
			
		}
		print(arr);
		return arr;
	}
	
	public void print(int[] arr) {
		System.out.println();
		System.out.println(" -After: " + Arrays.toString(arr));
	}
}
