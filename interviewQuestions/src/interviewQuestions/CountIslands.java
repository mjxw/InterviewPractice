package interviewQuestions;

public class CountIslands {
	static final int ROW = 5, COL = 5; 
	
	static boolean isSafe(int M[][], int row, int col, boolean visited[][]) {
		
		/*
		 * A function to check if a given cell (row, col) can be included in DFS
		 */
		return (row >= 0) && (row < ROW) && 
				(col >= 0) && (col < COL) && 
				(M[row][col] == 1 && !visited[row][col]);
	}
	
	/*
	 * A utility function to do DFS for a 2D boolean matrix. 
	 * It only considers the 8 neighbors as adjacent vertices
	 */
	static void DFS(int M[][], int row, int col, boolean visited[][]) {
		
		// Checking Scheme: 
		//original: (1,1)
		//check : (0, 0), (0, 1,), (0, 2)
		//check : (1, 0), (1, 2) 
		//check : (2, 0), (2, 1), (2, 2)
		int rowNbr[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
		int colNbr[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
		
        // Mark this cell as visited
        visited[row][col] = true;
 
        // Recur for all connected neighbors
        for (int k = 0; k < 8; ++k) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) ) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            	
            }
        }
	}
	
    // The main function that returns count of islands in a given
    //  boolean 2D matrix
    static int countIslands(int M[][]) {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];
 

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (M[i][j]==1 && !visited[i][j]) { // If a cell with
                                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }
            }
        }
        return count;
    }
    
    
    public static void main (String[] args) throws java.lang.Exception {
        int M[][]=  new int[][] {{1, 1, 1, 1, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
                                };
        System.out.println("Number of islands is: "+ countIslands(M));
    }
}

