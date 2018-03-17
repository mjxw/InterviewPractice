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
		
		// If there's bad input return 0
		if (arr.length == 0 || arr == null) {
			return 0;
		}
		
		int ans = 0;
		
		// The advantage to using Map<String, Object> is that you can change the underlying object to be a different kind of map without breaking your contract
		// with any code that's using it. If you declare it as HashMap<String, Object>, you have to change your contract if you want to change the
		// underlying implementation.
		
		// We will use a HashMap because of it's key-value pairing property. We need to keep track of a few things: 
		// the number, its degrees, and it's first and last index occurrence.
		// We can use the number as the key, and have the value be an integer array of containing the degrees and first and last occurrences
		Map<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			
			// If the map doesn't contain a mapping for this key, then we put it in the map
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], new int[] {1, i, i}); //[0] is the degree of the key, [1] is the first index of the key, [2] is the last index of the key
			} else {
				
				// Else, we have seen this key before and need to update 2 things: 
				// the degrees and the last index occurrence of the key 
				int []temp = map.get(arr[i]);
				temp[0]++; //update the degrees +1
				temp[2] = i; // latest index occurrence = index 
			}
		}
		
		// Seed degree with arbitrary value, in this case we do MIN_VALUE because we will need to make comparisons to find the max degree
		// Seed ans with arbitrary value, in this case we do MAX_VALUE because we will need to make comparisons to find the min length
		int degree = Integer.MIN_VALUE;
		ans = Integer.MAX_VALUE;
		
		// For each through the values in the map, i.e we can access the degree, the first index occurrence, and last index occurrence for each key
		// Objective: update both degree and ans to their respective maximum and minimums by going through all values stored in the map
		for (int []value : map.values()) {
			
			//Compare degrees - if degree at specific key is greater than min then...
			if (value[0] > degree) {
				degree = value[0]; //update degree to that key's degree
				ans = value[2] - value[1] + 1; //compute the min length
			
			// Else, we reach a point where the degree of this key is equal to the current max degree. 
			// In that case, we need to compare our previous ans by doing Math.min with the old ans and the new min length for this specific key where 
			// value[0] == degree
			} else if (value[0] == degree) {
				ans = Math.min(value[2] - value[1] + 1, ans); //This will update ans to the latest min length
			}
		}
		// Once we are done iterating through the map, we are done updating degrees to its max and ans to its minimum length
		return ans;
	}
	
}
