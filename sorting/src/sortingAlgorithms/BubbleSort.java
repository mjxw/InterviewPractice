package sortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
	
	public BubbleSort() {
		System.out.println("*Initiated BubbleSort*");
	}
	
	// Not optimized because you iterate arr.length times, even if there is no more sorting
	public void basicSort(int[] arr) {
		System.out.println();
		System.out.println("BubbleSort (basic): O(n^2) ");
		System.out.println(" -Original: " + Arrays.toString(arr));
		System.out.println();
		
		for (int i = 0; i < arr.length; i ++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println("    -Iteration " + (i + 1) + ": " + Arrays.toString(arr));
		}
		System.out.println();
		System.out.println(" -After: " + Arrays.toString(arr));
	}
	
	// Optimized by breaking out of the loop if inner loop doesn't sort anything
	public void optimizedSort(int[] arr) {
		System.out.println();
		System.out.println("BubbleSort (optimized): O(n) ");
		System.out.println(" -Original: " + Arrays.toString(arr));
		System.out.println();
		
		boolean swapped;
		for (int i = 0; i < arr.length; i ++) {
			swapped = false;
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
			System.out.println("    -Iteration " + (i + 1) + ": " + Arrays.toString(arr));
		}
		System.out.println();
		System.out.println(" -After: " + Arrays.toString(arr));
	}

}
