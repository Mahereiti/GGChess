package board;
import java.util.ArrayList;

public class Knight extends Piece {
	public Knight(String color, int targetH) {
		super(color, "/"+color+"_pieces/knight.png", targetH);
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int row = square.getRow()/100;
		int col = square.getCol()/100;
		
	    if ((row+2)<8 && (col+1)<8) {
	        if (!board[row+2][col+1].isOccupied() || !board[row+2][col+1].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[row+2][col+1]);
	        }
	    }
	    if ((row+2)<8 && (col-1)>=0) {
	        if (!board[row+2][col-1].isOccupied() || !board[row+2][col-1].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[row+2][col-1]);
	        }
	    }
	    if ((row-2)>=0 && (col+1)<8) {
	        if (!board[row-2][col+1].isOccupied() || !board[row-2][col+1].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[row-2][col+1]);
	        }
	    }
	    if ((row-2)>=0 && (col-1)>= 0) {
	        if (!board[row-2][col-1].isOccupied() || !board[row-2][col-1].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[row-2][col-1]);
	        }
	    }
	    if ((row+1)<8 && (col+2)< 8) {
	        if (!board[row+1][col+2].isOccupied() || !board[row+1][col+2].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[row+1][col+2]);
	        }
	    }
	    if ((row+1)<8 && (col-2)>=0) {
	        if (!board[row+1][col-2].isOccupied() || !board[row+1][col-2].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[row+1][col-2]);
	        }
	    }
	    if ((row-1)>=0 && (col+2)<8) {
	        if (!board[row-1][col+2].isOccupied() || !board[row-1][col+2].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[row-1][col+2]);
	        }
	    }
	    if ((row-1)>=0 && (col-2)>=0) {
	        if (!board[row-1][col-2].isOccupied() || !board[row-1][col-2].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[row-1][col-2]);
	        }
	    }

	    return ValidMoves;
	}
}