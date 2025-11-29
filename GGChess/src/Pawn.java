import java.util.ArrayList;

public class Pawn extends Piece {
	public Pawn(String color, int targetH) {
		super(color, "/"+color+"_pieces/pawn.png", targetH);
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> validMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int row = square.getRow()/100;
		int col = square.getCol()/100;

	    if (this.getColor().equals("black")) {
	        //for the case when we can move for 1 or 2 squares
	    	if (row == 1) {
	            if (!board[row+1][col].isOccupied()) {
	                validMoves.add(board[row+1][col]);
	                //we can go to x+2 only if X+1 is not occupied
	                if (!board[row+2][col].isOccupied()) { 
	                    validMoves.add(board[row+2][col]);
	                }
	            }
	        } 
	        else if (row < 7) { //if the pawn can move juste from one square
	            if (!board[row+1][col].isOccupied()) {
	                validMoves.add(board[row+1][col]);
	            }

	            //case of kills
	            if (col<7 && board[row+1][col+1].isOccupied() && !board[row+1][col+1].getPiece().getColor().equals(this.getColor())) {
	                validMoves.add(board[row+1][col+1]);
	            }
	            if (col>0 && board[row+1][col-1].isOccupied() && !board[row+1][col-1].getPiece().getColor().equals(this.getColor())) {
	                validMoves.add(board[row+1][col-1]);
	            }
	        }
	    }

	    //for black pawns
	    else {
	        if (row == 6) {
	            if (!board[row-1][col].isOccupied()) {
	                validMoves.add(board[row-1][col]);

	                if (!board[row-2][col].isOccupied()) {
	                    validMoves.add(board[row-2][col]);
	                }
	            }
	        } 
	        else if (row>0) {
	            if (!board[row-1][col].isOccupied()) {
	                validMoves.add(board[row-1][col]);
	            }

	            if (col<7 && board[row-1][col+1].isOccupied() && !board[row-1][col+1].getPiece().getColor().equals(this.color)) {
	                validMoves.add(board[row-1][col+1]);
	            }
	            if (col>0 && board[row-1][col-1].isOccupied() && !board[row-1][col-1].getPiece().getColor().equals(this.color)) {
	                validMoves.add(board[row-1][col-1]);
	            }
	        }
	    }

	    return validMoves;
	}
}