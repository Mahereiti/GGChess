package board;
import java.util.ArrayList;

import app.Game;

public class Pawn extends Piece {
	Game g;
	
	public Pawn(String color, int targetH, Game g) {
		super(color, "/"+color+"_pieces/pawn.png", targetH);
		this.g = g;
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> validMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int row = square.getRow()/100;
		int col = square.getCol()/100;
		
		// for black pawns
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
	        } else if (row < 7) { //if the pawn can move just from one square
	            if (!board[row+1][col].isOccupied()) {
	                validMoves.add(board[row+1][col]);
	            }

	        }
	    	//case of kills
	    	if (row<7 && col<7 && board[row+1][col+1].isOccupied() && !board[row+1][col+1].getPiece().getColor().equals(this.getColor())) {
	    		validMoves.add(board[row+1][col+1]);
	    	}
	    	if (row<7 && col>0 && board[row+1][col-1].isOccupied() && !board[row+1][col-1].getPiece().getColor().equals(this.getColor())) {
	    		validMoves.add(board[row+1][col-1]);
	    	}
	    }

	    //for white pawns
	    else {
	        if (row == 6) {
		        //for the case when we can move for 1 or 2 squares
	            if (!board[row-1][col].isOccupied()) {
	                validMoves.add(board[row-1][col]);
	                //we can go to x+2 only if X+1 is not occupied
	                if (!board[row-2][col].isOccupied()) {
	                    validMoves.add(board[row-2][col]);
	                }
	            }
	        } 
	        else if (row>0) { //if the pawn can move just from one square
	            if (!board[row-1][col].isOccupied()) {
	                validMoves.add(board[row-1][col]);
	            }
	        }
	        // case of kills
	        if (row>0 && col<7 && board[row-1][col+1].isOccupied() && !board[row-1][col+1].getPiece().getColor().equals(this.getColor())) {
	        	validMoves.add(board[row-1][col+1]);
	        }
	        if (row>0 && col>0 && board[row-1][col-1].isOccupied() && !board[row-1][col-1].getPiece().getColor().equals(this.getColor())) {
	        	validMoves.add(board[row-1][col-1]);
	        }
	    }
	    
	    // Special case
	    // En passant
	    // en passant possible
	    if (g.getEnPassantTarget() != null) {
	    	Square target = g.getEnPassantTarget();
	    	if (target.getRow()/100==row && (target.getCol()/100==col-1 || target.getCol()/100==col+1)) {

	    		if (this.getColor().equals("white")) {
	    			validMoves.add(board[row-1][target.getCol()/100]);
	    		} else validMoves.add(board[row+1][target.getCol()/100]);
	    	}
	    }

	    return validMoves;
	}
}