package connectFour;

public enum playerColor {
	// Red piece denoted with "X"
	RED("X"),
	
	// Blue piece denoted with "O"
	BLUE("O");
	
	private final String piece;

	playerColor(String piece) {
		this.piece = piece;
	}
	
	public playerColor switchPlayers() {
       switch (this) {
       case RED:
           return playerColor.BLUE;

       case BLUE:
           return playerColor.RED;

       default:
           throw new IllegalStateException();
       }
	}

	
    @Override
    public String toString() {
        return piece;
    }
}
