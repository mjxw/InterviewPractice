package bolt;

import java.util.Stack;

public class evaluateExpressionParenthesis {
	public static void main (String[] args) {
		String expression1 = "1-(2+3-(4+2))";
		String expression2 = "(3+2)-(4+1-(4+2))";
		System.out.println(evaluate(expression1));
		System.out.println(evaluate(expression2));

	}
	
	public static String evaluate(String expression) {
		StringBuilder str = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int offset = 0;

		for (int i = expression.length() - 1; i >= 0; i--) {
			offset = 0;
			if (expression.charAt(i) != '(') {
				stack.add(expression.charAt(i)); 
			} else if (expression.charAt(i) == '(') {
				while (stack.peek() != ')') {
					str.insert(offset ,stack.pop());
					offset++;
				}
			} else {
				
			}
			if(expression.charAt(i) == '-') {
				for (int j = 0; j < str.length(); j++) {
					if (str.charAt(j) == '+') {
						str.setCharAt(j, '-');
					} else if (str.charAt(j) == '-') {
						str.setCharAt(j, '+');
					}
				}
			}
		}
		
		for (int i = 0; i < stack.size(); i++) { // add the remaining parts of the expression
			if (stack.peek() != ')') {
				str.insert(offset ,stack.pop());
				offset++;
			} else {
				stack.pop();
			}
		}
		
		return str.toString();
	}
}
