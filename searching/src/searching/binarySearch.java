package searching;

public class binarySearch {
	public static void main(String[] args) {
		int [] arr = new int[] {10, 12, 13, 15, 17, 20, 25, 37, 60};
		System.out.println(search(arr, 0, arr.length - 1, 20));
		System.out.println(search(arr, 0, arr.length - 1, 100));

	}
	
	public static int search (int[] arr, int l, int r, int x) {
		if (r >= 1) {
			int mid = 1 + (r-l) / 2;
			
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] > x) {
				return search(arr, mid+1, r, x);
			} else if (arr[mid] < x) {
				return search(arr, l, mid-1, x);
			} 
		}
		return -1;
	}
	
}
