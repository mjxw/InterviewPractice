package uber;


import java.util.HashMap;
import java.util.Map;

public class arrayDegrees {
	public static void main(String[]args) {
		int[] input1 = new int[] {1, 2, 2, 3, 1};
		int[] input2 = new int[] {1, 1, 2, 1, 2, 2};
		
		System.out.println(minimum(input1));
		System.out.println(minimum(input2));
	}
	
	public static int minimum(int[] arr) {
		if (arr.length == 0 || arr == null) {
			return 0;
		}
		
		int ans = 0;
		Map<Integer, int[]> map = new HashMap<>();
		for (int i  =0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new int[] {1, i, i});
			} else {
				int []temp = map.get(arr[i]);
				temp[0]++;
				temp[2] = i;
			}
		}
		
		int degree = Integer.MIN_VALUE;
		ans = Integer.MAX_VALUE;
		
		for (int []value : map.values()) {
			if (value[0] > degree) {
				degree = value[0];
				ans = value[2] - value[1] + 1;
				
			} else if (value[0] == degree) {
				ans = Math.min(value[2] - value[1] + 1, ans);
			}
		}
		return ans;
	}
	
}
