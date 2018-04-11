package PerfectPrice;

public class MaxSubSum {

	public static void main(String[] args) {
		int[] arr = new int [] {3, -4, 1, 7, -5, 10};
		System.out.println(max(arr));
	}
	
	public static int max (int[] arr ) {
		int length = arr.length;
		int subsum = 0;
		int current = 0;
		int max = 0;
		
		for (int i = 0; i < length; i ++) {
			current = arr[i] + subsum;
			
			if (current > arr[i]) {
				subsum += arr[i];
			} else {
				subsum = arr[i];
			}
			
			if (subsum > max) {
				max = subsum;
			}
		}
		
		return max;
	}
}
