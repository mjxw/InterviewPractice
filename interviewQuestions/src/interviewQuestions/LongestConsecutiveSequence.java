package interviewQuestions;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] arr = new int[] {100, 4, 200, 1, 3, 2};
		System.out.println("longest: " + longestConsecutive(arr));
	}
	
	public static int longestConsecutive(int [] arr) {
		int max = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int number : arr) {
			set.add(number);
		}
		
		for (int number : set) {
			if (!set.contains(number - 1)) {
				int current = number;
				int currentMax = 1;
				while (set.contains(current+1)) { // dont change current!!! current++ vs current+1
					current += 1;
					currentMax+= 1;
				}
				max = Math.max(max, currentMax);
			}

		}
		return max;
	}
}
