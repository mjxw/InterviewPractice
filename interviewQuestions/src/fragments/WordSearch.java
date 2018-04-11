 package fragments;

import java.util.ArrayList;

public class WordSearch {
	
	public static void main (String[] args) {
		char [][] matrix = new char[][] {
			{'a', 'b', 'b', 'c', 'd'}, 
			{'w', 'o', 'r', 'd', 'x'}, 
			{'w', 'w', 't', 'a', 't'},
			{'o', 'r', 'o', 'p', 'p'},
			{'r', 'q', 'w', 'r', 'g'},
			{'d', 's', 'q', 'a', 'd'}, 
			{'d', 'r', 'o', 'w', 'a'}
		};
		String target = "word";
		print(matrix);
		System.out.println("'" + target + "' appeared: " + search(matrix, target) +  " times");
		
	}

	private static void print(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int search(char[][] matrix, String target) {
		ArrayList<String> arr = new ArrayList<String>(); // ArrayList to store visited coordinates  
		int count = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (arr.contains("" + i + ", " + j) && target.indexOf(matrix[i][j]) == -1) { // if we've already visited the coordinate, then move on 
					System.out.println("skip on: (" + i + ", " + j + ")");
					continue;
				}
				if (explore(matrix, i, j, target, arr, 0)) {
					System.out.println("hit on: (" + i + ", " + j + ")");
					count++;
				}
			}
		}
		return count;
	}

	private static boolean explore(char[][] matrix, int i, int j, String target, ArrayList<String> arr, int index) {
		int m = matrix.length; 
		int n = matrix[0].length;
		
		if (i< 0 || j < 0 || i >= m || j >= n) {
			return false;
		}
		
		if  (matrix[i][j] == target.charAt(index)) {
			if (index == target.length() - 1) {
				return true;
			} else if (explore(matrix, i, j + 1, target, arr, index + 1) ||
					explore(matrix, i, j - 1, target, arr, index + 1) ||
					explore(matrix, i + 1, j, target, arr, index + 1) ||
					explore(matrix, i - 1, j, target, arr, index + 1)) {
				return true;
			}
		}
		return false;
	}
}
