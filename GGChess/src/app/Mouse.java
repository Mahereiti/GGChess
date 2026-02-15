// Class to handle clicks
package app;

import java.awt.Color;
import java.util.ArrayList;

import board.Square;

public class Mouse {
	
	// Store the first square selected containing a piece
	static Square selectedSquare1 = null; // To check 1st click before moving a piece
	static Square redSquare = null;		// To show if the move is invalid (square becomes red)
	static ArrayList<Square> validMoves = null;
	private Game game;
	
	public Mouse(Game game) {
        this.game = game;
    }

	// When click on square
	public void clickOnSquare(Square s) {
		// Reset color of all squares in validMoves
		if (validMoves != null) {
			for (Square sValid : validMoves) {
				sValid.resetColor();
			}
		}
		
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
			
			// put valid moves in green
			validMoves = selectedSquare1.getPiece().getValidMoves();
			for (Square sValid : validMoves) {
				sValid.setOpaque(true);
			    sValid.setBackground(Color.green);
			}
			return ;
		}
		// if a piece is already selected and it's not the same initial selected square/piece
		else if (selectedSquare1 != null && selectedSquare1 != s) {
			//if the move is valid
        	if (selectedSquare1.getPiece().getValidMoves().contains(s)) {
        		if (!selectedSquare1.getPiece().hasMoved()) {
        			selectedSquare1.getPiece().setHasMoved(true);
        		}

        		game.move(selectedSquare1, s); 	// Move piece
        		game.switchPlayer();       //the player is switched
            }
        	else {
        		s.setInRed();	// invalid move in red
        		redSquare = s;
        	}
			
		}
		selectedSquare1 = null; 		// Reset initial selected square
		validMoves = null;
	}
}

