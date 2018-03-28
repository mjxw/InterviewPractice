package interviewQuestions;

public class Merge {
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 4, 5};
		int[] arr2 = {2, 4, 6, 7};
				
		mergeArray(arr1, arr2);
	}

	private static void mergeArray(int[] arr1, int[] arr2) {
		int i = 0; // first array's pointer
		int j = 0; // second array's pointer  
		int k = 0; // resulting array's pointer 
				
		int n1 = arr1.length;
		int n2 = arr2.length;
		
		int[] arr3 = new int[n1 + n2];

		
		while (i < n1 && j < n2) {
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i]; 
				k++;
				i++;
			} else {
				arr3[k] = arr2[j];
				k++;
				j++;
			}
		}
		
		while (i < n1) {
			arr3[k] = arr1[i];
			k++;
			i++;
		}
		
		while (j < n2) {
			arr3[k] = arr2[j];
			k++;
			j++;
		}
		
		for (int index = 0; index < arr3.length; index++) {
			System.out.print(arr3[index] + ", ");
		}
	}
}
