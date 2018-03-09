package connectFour;
import java.util.Scanner;


public class Main {

	private static final String NEW_GAME = "Play again? Type 'no' to exit, or any key to replay";
	
	private static final String RED_WINS = "Red wins!";
	
	private static final String BLUE_WINS = "Blue wins!";
	
	private static final String TIE = "Tie!";
	
	private static final String EXIT = "Good game(s)";
	
	private static final String RED_PROMPT = "RED's turn: ";
	
	private static final String BLUE_PROMPT = "BLUE's turn: ";
	
	private final Scanner s = new Scanner(System.in);
	private board board = new board();
	private playerColor currentPlayer;
	
	public static void main(String[] args) {
        final Main main = new Main();
		main.play();
	}
	
	public void play() {
		while (true) {
			playerColor winningColor = gameLoop();
			reportOutcome(winningColor);
			
			if (!newGameRequested()) {
				break;
			}
		}
		System.out.println(EXIT);
	}
	
    private playerColor gameLoop() {
        currentPlayer = playerColor.RED;
        board = new board();
        System.out.println();
        System.out.println(board);

        while (true) {
            playerColor winnerColor = board.returnWinner();

            if (winnerColor != null || board.checkBoardFull()) {
                return winnerColor;
            }

            final int column = readPly();
            board.dropPiece(column, currentPlayer);
            currentPlayer = currentPlayer.switchPlayers();
            System.out.println();
            System.out.println(board);
        }
    }
    
    private void reportOutcome(final playerColor winnerColor) {
        switch (winnerColor) {
            case RED:
                System.out.println(RED_WINS);
                break;

            case BLUE:
                System.out.println(BLUE_WINS);
                break;

            default:
                System.out.println(TIE);
                break;
        }
    }

    private boolean newGameRequested() {
        System.out.println(NEW_GAME);
        final String input = s.next().trim().toLowerCase();
        return !input.equals("no");
    }
    
    

    private int readPly() {
        while (true) {
            if (currentPlayer == playerColor.RED) {
                System.out.print(RED_PROMPT);
            } else if (currentPlayer == playerColor.BLUE) {
                System.out.print(BLUE_PROMPT);
            } else {
                throw new IllegalStateException();
            }

            final String command = s.next().trim();

            try {
                final int column = Integer.parseInt(command);

                if (column < 1) {
                    System.out.println("Column index must be at least 1.");
                    continue;
                } else if (column > board.getWidth()) {
                    System.out.println("Column index must be at most " +
                                       board.getWidth());
                    continue;
                }

                final int columnIndex = column - 1;

                if (board.getColumnHeight(columnIndex) == board.getHeight()) {
                    System.out.println("The " + nth(column) + " column is " +
                                       "full.");
                }

                return columnIndex;
            } catch (final NumberFormatException ex) {
                System.out.println("\"" + command + "\" is not an integer!");
            }
        }
    }
    
    private static String nth(final int i) {
        switch (i) {
            case 1:
                return "1st";

            case 2:
                return "2nd";

            case 3:
                return "3rd";

            default:
                return "" + i + "th";
        }
    }

}
