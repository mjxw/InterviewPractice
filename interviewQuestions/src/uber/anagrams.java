 package uber;

import java.util.Arrays;
import java.util.HashMap;

public class anagrams {
	public static void main (String[]args) {
		String[] a = new String[] {"a", "jk", "abb", "mn", "abc"};
		String[] b = new String[] {"bb", "kj", "bbc", "op", "def"};
		anagramDifference(a, b);
	}
	
	public static void anagramDifference(String []a, String []b) {
		HashMap <Character, Integer> map = new HashMap<Character, Integer>();
		int[] ans = new int[a.length];
		int count  = 0;
		
		for (int i = 0; i < a.length; i++) {
			String stringA = a[i];
			String stringB = b[i];
			
			if (stringA.length() != stringB.length()) {
				ans[i] = -1;
				continue;
			}
			
			for (int j = 0; j < stringA.length(); j++) {
				if (!map.containsKey(stringA.charAt(j)))  {
					map.put(stringA.charAt(j), 1);
				} else {
					map.put(stringA.charAt(j), map.get(stringA.charAt(j)) + 1);
				}
			}
			for (int j = 0; j < stringB.length(); j++) {
				if (map.containsKey(stringB.charAt(j)) &&  map.get(stringB.charAt(j)) != 0) {
					map.put(stringB.charAt(j), map.get(stringB.charAt(j)) - 1);
				} else {
					count++;
				}
			}
			ans[i] = count;
			count = 0;
		}
		System.out.println(Arrays.toString(ans));
	}
	
}
