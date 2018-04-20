package interviewQuestions;

public class RotateMatrix {
	public static void main(String[] args) {
		String[][] m = new String[][] {
			{ "x", "x", "x", "x" },
			{ "x", "-", "-", "-" },
			{ "x", "x", "x", "-" },
			{ "x", "-", "-", "-" }
		};
		
		String[][] rotated = new String[m.length][m[0].length];
		
		for (int i = 0 ; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
                rotated[i][j] = m[j][m[0].length - i - 1];
                System.out.println("(" + j + "), (" + (m[0].length - i - 1)  +") => " + i + " " + j);

			}
		}
		
		for (int i = 0 ; i < rotated.length; i++) {
			for (int j = 0; j < rotated[0].length; j++) {
				System.out.print(rotated[i][j]);
			}
			System.out.println();
		}	
	}
}
