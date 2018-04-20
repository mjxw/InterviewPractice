package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * n = 3 
 * 
 * 
 * [
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParenthesis {
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		
	}

	private static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<String>();
		generate(n, ans, "", 0, 0);
		return ans;
	}

	private static void generate(int n, List<String> ans, String curr, int open, int close) {
		if (curr.length() == n * 2) {
			ans.add(curr);
			return;
		}
		
		if (open < n) {
			generate(n, ans, curr+"(", open+1, close);
		}
		
		if(open > close) {
			generate(n, ans, curr+")", open, close+1);
		}
	}
}
