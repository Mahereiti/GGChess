
// Class to handle clicks
public class Mouse {
	// Store the first square selected containing a piece
	static Square selectedSquare1 = null; // To check 1st click before moving a piece
	
	Mouse() {}
	
	// When click on square
	public void clickOnSquare(Square s) {
		// if the square contains a piece and we didn't select a piece yet
		if (s.isOccupied() && selectedSquare1 == null) {
			selectedSquare1 = s;
		}

		// if a piece is already selected and it's not the same initial selected square/piece
		else if (selectedSquare1 != null && selectedSquare1 != s) {
			
			/*
			 * MODIF VALID MOVES
			 */
			
			selectedSquare1.getPiece().move(selectedSquare1, s); 	// Move piece
			selectedSquare1 = null; 	// Reset initial selected square
		} else selectedSquare1 = null; 	// if same initial selected square/piece
	}
}
