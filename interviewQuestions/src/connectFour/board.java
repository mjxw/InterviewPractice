package connectFour;
public class board {
	
	// The board's width
	private static final int WIDTH = 7;
	
	// The board's height
	private static final int HEIGHT = 6;
	
	// The amount of connected pieces to win
	private static final int WIN_LENGTH = 4;
	
	// Declare board
	private final playerColor[][] board = new playerColor[HEIGHT][WIDTH];
	
	public void dropPiece(int x, playerColor color) {
		checkColumnInput(x);
		checkColumnCapacity(x);
		
		int y = getHeight() - 1;
		
		while(board[y][x] != null) {
			y--; // drops the piece
		}
		
		board[y][x] = color; // set coordinate to piece
	}
	
	public playerColor returnWinner() {
		if (getWinner(playerColor.BLUE)) {
			return playerColor.BLUE;
		}
		
		if(getWinner(playerColor.RED)) {
			return playerColor.RED;
		}
		return null;
	}
	
	private boolean getWinner(playerColor color) {		
		
		for (int y = 0; y < getHeight(); y++) { // iterate rows, bottom to top
			for (int x = 0; x < getWidth(); x++) { //iterate columns, left to right
				playerColor player = board[y][x];
				if (player == null) {
					continue;
				}
				
				// Check going right
				if (x + 3 < getWidth() && player == board[y][x+1] && player == board[y][x+2] && player == board[y][x+3]) {
					return true;
				}
				
				if (y + 3 < getHeight()) {
					
					//Check going up
					if (player == board[y+1][x] && player == board[y+2][x] && player == board[y+3][x] ) {
						return true;
					}
					
					//Check going up/right
					if (x + 3 < getWidth() && player == board[y+1][x + 1] && player == board[y+2][x + 2] && player == board[y+3][x +3] ) {
						return true;
					}
					
					//Check going up/left
					if (x - 3 < getWidth() && player == board[y+1][x - 1] && player == board[y+2][x - 2] && player == board[y+3][x-3] ) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkBoardFull() {
        for (int y = 0; y < getWidth(); ++y) {
            for (int x = 0; x < getHeight(); ++x) {
                if (board[y][x] == null) {
                    return false;
                }
            }
        }
        return true;
	}

	public int getHeight() {
		return HEIGHT;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getColumnHeight(int x) {
		int height = 0;
		
		for (int y = getHeight() - 1; y >= 0; y--) {
			height++;
			if (board[y][x] == null) {
				return height;
			}
		}
		return height;
	}
	
	// Verifies selected column is within bounds of the board
	private void checkColumnInput(int x) {
		if (x < 0 || x >= getWidth() ) {
			throw new IndexOutOfBoundsException("The selected x coordinate is out of bounds");
		}
	}
	
	// Verifies if selected column is full
	private void checkColumnCapacity(int x) {
		if (getColumnHeight(x) == getHeight()) {
			throw new IllegalStateException("The selected x coordinate cannot be placed in a full column");
		}
	}
	
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        for (int y = 0; y < board.length; ++y) {
            sb.append("|");

            for (int x = 0; x < board[0].length; ++x) {
                final playerColor color = board[y][x];
                sb.append(color != null ? color.toString() : " ");
                sb.append("|");
            }

            sb.append("\n");
        }

        sb.append("---------------\n");
        sb.append(" 1 2 3 4 5 6 7");
        return sb.toString();
    }


	
	
}
