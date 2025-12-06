
// Class to handle clicks
public class Mouse {
	
	// Store the first square selected containing a piece
	static Square selectedSquare1 = null; // To check 1st click before moving a piece
	static Square redSquare = null;		// To show if the move is invalid (square becomes red)
	private Game game;
	
	public Mouse(Game game) {
        this.game = game;
    }

	// When click on square
	public void clickOnSquare(Square s) {
		// To reset color of red square
		if (redSquare != null) {
	        redSquare.resetColor();
	        redSquare = null;
	    }
		
		// if the selectionned piece belongs to the active player
		// if the square contains a piece and we didn't select a piece yet
		if (s.isOccupied() && s.getPiece().getColor().equals(game.playersPanel.currentPlayer.getColor()) 
				&& selectedSquare1 == null) {
			selectedSquare1 = s;
			return ;
		}
		// if a piece is already selected and it's not the same initial selected square/piece
		else if (selectedSquare1 != null && selectedSquare1 != s) {
			//if the move is valid
        	if (selectedSquare1.getPiece().getValidMoves().contains(s)) {
				game.move(selectedSquare1, s); 	// Move piece
        		game.switchPlayer();       //the player is switched
            }
        	else {
        		s.setInRed();	// invalid move in red
        		redSquare = s;
        	}
			
		}
		selectedSquare1 = null; 		// Reset initial selected square
	}
}

