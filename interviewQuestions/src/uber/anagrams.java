 package uber;

import java.util.Arrays;
import java.util.HashMap;

public class anagrams {
	public static void main (String[]args) {
		String[] a = new String[] {"a", "jk", "abb", "mn", "abc"};
		String[] b = new String[] {"bb", "kj", "bbc", "op", "def"};
		anagramDifference(a, b);
	}
	
	// Solution is O(n * m). n is the size of the string array, m is the number of characters inside each string from the input array. 
	public static void anagramDifference(String []a, String []b) {
		
		// Using a HashMap because we don't care about synchronization (concurrency i.e HashTable)
		// We will use the HashMap to keep track of occurrences of a character because we need to know
		// whether or not characters have been seen before to qualify for an "anagram"
		HashMap <Character, Integer> map = new HashMap<Character, Integer>();
		int[] ans = new int[a.length];
		int count  = 0;
		
		// Iterate through the input array of strings
		for (int i = 0; i < a.length; i++) {
			String stringA = a[i];
			String stringB = b[i];
			
			// Edge case: If the two strings in comparison are not equal in length, then there's
			// no way for it to be an anagram
			if (stringA.length() != stringB.length()) {
				ans[i] = -1;
				continue; //Breaks out of current iteration of for loop
			}
			
			// Iterate over each string. If haven't seen it, put it in the map. 
			// If we have seen it, update the value pair +1 to keep track of how many times we've seen it.
			// *put() good for updating duplicates*
			for (int j = 0; j < stringA.length(); j++) {
				if (!map.containsKey(stringA.charAt(j)))  {
					map.put(stringA.charAt(j), 1);
				} else {
					map.put(stringA.charAt(j), map.get(stringA.charAt(j)) + 1);
				}
			}
			
			// 1) Now that we have a map of all occurrences of characters for stringA, we can do comparisons 
			// to stringB. 
			// 2) We will check if we've seen a character in stringB by checking if there's a key-value pair for 
			// stringB's character key in the HashMap containing occurrences for stringA. 
			
			
			// 3) If there is a mapping for that key-value pair AND the value isn't 0, then that means that character
			// exists and can be used to potentially form an anagram. So we will consume that character and -1 the value 
			// from that character's key-value pairing
			
			
			// 4) ...Otherwise, either we  haven't seen that character or there isn't enough of that character
			// i.e, the value is 0 and availability of that character has been depleted. 
			// So we increment count to represent the difference in characters, which is the answer we need to 
			// keep track of
			
			
			for (int j = 0; j < stringB.length(); j++) {
				if (map.containsKey(stringB.charAt(j)) &&  map.get(stringB.charAt(j)) != 0) {
					map.put(stringB.charAt(j), map.get(stringB.charAt(j)) - 1);
				} else {
					count++;
				}
			}
			
			//Place count in the respective array index and reset the count for each iteration
			ans[i] = count;
			count = 0;
		}
		System.out.println(Arrays.toString(ans));
	}
	
}
