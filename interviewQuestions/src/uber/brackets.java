package uber;

import java.util.Arrays;
import java.util.Stack;

public class brackets {

	public static void main (String[] args) {
		String[] input1 = new String[] { "2", "()[]{}", "[}()"};
		String[] input2 = new String[] { "3", "()[]{}", "[({})]()", "({[)]})"};
		bracket(input1);
		bracket(input2);
	}
	
	// Solution is O(n * m). n is the size of the string array, m is the number of characters inside each string from the input array. 
	public static void bracket(String[] arr) {
		// Create a string array of size of the first index of input (denotes how many strings there are)
		String [] ans = new String [Integer.parseInt(arr[0])]; 
		
		// Starting at index 1 (first input string), loop through the rest of the input
		for (int i = 1; i < arr.length; i++) {
			
			// Create a stack to store charAt index[j], chose stack because of LIFO property. 
			// We want to compare whether or not the braces close, so by storing the starting brace in a LIFO data structure
			// we can easily take a look at the last-in element to see if the braces are closed. 
			Stack <String> stack = new Stack <String>(); // O(n) access/search || O(1) insertion 
			
			// Iterate through each string, character by character. 
			// We are primarily only interested in the starting braces and will store their respective closing brace. 
			for (int j = 0; j < arr[i].length(); j++) {
				
				Character c = arr[i].charAt(j);
				
				// For each character, if it is a starting brace, push the closing one to the stack. 
				if (Character.toString(c).contains("{")) {
					stack.push("}");
				} else if (Character.toString(c).contains("(")) {
					stack.push(")");
				} else if (Character.toString(c).contains("[")) {
					stack.push("]"); 
					
				// Else, when we see a closing brace, we will check the stack to see if the closing brace exists in there. 
				// If it does, then that means we've seen the corresponding starting brace, and it happens to be the most recent 
				// element i.e LIFO property 
				} else {			
					if (stack.isEmpty() || !stack.peek().contains(Character.toString(c))) {
						ans[i - 1] = "NO";
						stack.pop(); // Need to pop if there isn't a match so we can move on to the previous last-in element
						break;
					}
				}
				
				// We target the index i-1 because i starts at 1 to skip over the 0th index of input. 
				ans[i -1 ] = "YES";
			}
		}
		System.out.println(Arrays.toString(ans));
	}
}
