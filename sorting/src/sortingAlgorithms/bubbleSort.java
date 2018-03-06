package sortingAlgorithms;

import java.util.Arrays;

public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public bubbleSort() {
		System.out.println("Constructing a bubbleSort");
	}
	
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
	
	public void optimizedSort(int[] arr) {
		System.out.println();
		System.out.println("BubbleSort (optimized): O(n) ");
		System.out.println(" -Original: " + Arrays.toString(arr));
		System.out.println();
		
		
	}

}