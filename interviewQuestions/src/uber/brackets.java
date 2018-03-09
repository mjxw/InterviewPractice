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
	
	public static void bracket(String[] arr) {
		String [] ans = new String [Integer.parseInt(arr[0])];
		for (int i = 1; i < arr.length; i++) {
			Stack <String> stack = new Stack <String>();
			for (int j = 0; j < arr[i].length(); j++) {
				Character c = arr[i].charAt(j);
				if (Character.toString(c).contains("{")) {
					stack.push("}");
				} else if (Character.toString(c).contains("(")) {
					stack.push(")");
				} else if (Character.toString(c).contains("[")) {
					stack.push("]");
				} else {			
					if (stack.isEmpty() || !stack.peek().contains(Character.toString(c))) {
						ans[i - 1] = "NO";
						stack.pop();
						break;
					}
				}
				ans[i -1 ] = "YES";
			}
		}
		System.out.println(Arrays.toString(ans));
	}
}
