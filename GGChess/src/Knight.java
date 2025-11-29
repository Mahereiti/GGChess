import java.util.ArrayList;

public class Knight extends Piece {
	public Knight(String color) {
		super(color, "/"+color+"_pieces/knight.png");
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int x = square.getX();
		int y = square.getY();
	    if ((x+2)<8 && (y+1)<8) {
	        if (!board[x+2][y+1].isOccupied() || !board[x+2][y+1].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[x+2][y+1]);
	        }
	    }
	    if ((x+2)<8 && (y-1)>=0) {
	        if (!board[x+2][y-1].isOccupied() || !board[x+2][y-1].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[x+2][y-1]);
	        }
	    }
	    if ((x-2)>=0 && (y+1)<8) {
	        if (!board[x-2][y+1].isOccupied() || !board[x-2][y+1].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[x-2][y+1]);
	        }
	    }
	    if ((x-2)>=0 && (y-1)>= 0) {
	        if (!board[x-2][y-1].isOccupied() || !board[x-2][y-1].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[x-2][y-1]);
	        }
	    }
	    if ((x+1)<8 && (y+2)< 8) {
	        if (!board[x+1][y+2].isOccupied() || !board[x+1][y+2].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[x+1][y+2]);
	        }
	    }
	    if ((x+1)<8 && (y-2)>=0) {
	        if (!board[x+1][y-2].isOccupied() || !board[x+1][y-2].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[x+1][y-2]);
	        }
	    }
	    if ((x-1)>=0 && (y+2)<8) {
	        if (!board[x-1][y+2].isOccupied() || !board[x-1][y+2].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[x-1][y+2]);
	        }
	    }
	    if ((x-1)>=0 && (y-2)>=0) {
	        if (!board[x-1][y-2].isOccupied() || !board[x-1][y-2].getPiece().getColor().equals(this.color)) {
	            ValidMoves.add(board[x-1][y-2]);
	        }
	    }

	    return ValidMoves;
	}
}