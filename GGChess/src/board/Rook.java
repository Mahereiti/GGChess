package board;
import java.util.ArrayList;

public class Rook extends Piece{
	
	public Rook(String color, int targetH) {
		super(color, "/"+color+"_pieces/rook.png", targetH);
	}
	
	public ArrayList<Square> getValidMoves() {
	    ArrayList<Square> validMoves = new ArrayList<Square>();
	    Square square = this.getSquare();
	    Square[][] board = square.getBoard();
	    int row = square.getRow()/100;
	    int col = square.getCol()/100;
	    int i;

	    //right
	    i=1;
	    while ((col+i)<8) {
	        if (!board[row][col+i].isOccupied()) {
	            validMoves.add(board[row][col+i]);
	        } else {
	            if (!board[row][col+i].getPiece().getColor().equals(this.getColor())) { //if we meet an enemcol piece 
	                validMoves.add(board[row][col+i]);
	            }
	            break;
	        }
	        i++;
	    }
	    
	    //left
	    i=1;
	    while ((col-i)>=0) {
	        if (!board[row][col-i].isOccupied()) {
	            validMoves.add(board[row][col-i]);
	        } else {
	            if (!board[row][col-i].getPiece().getColor().equals(this.getColor())) {
	                validMoves.add(board[row][col-i]);
	            }
	            break;
	        }
	        i++;
	    }

	    //up
	    i=1;
	    while ((row+i)<8) {
	        if (!board[row+i][col].isOccupied()) {
	            validMoves.add(board[row+i][col]);
	        } else {
	            if (!board[row+i][col].getPiece().getColor().equals(this.getColor())) {
	                validMoves.add(board[row+i][col]);
	            }
	            break;
	        }
	        i++;
	    }

	    //down
	    i=1;
	    while ((row-i)>=0) {
	        if (!board[row-i][col].isOccupied()) {
	            validMoves.add(board[row-i][col]);
	        } else {
	            if (!board[row-i][col].getPiece().getColor().equals(this.getColor())) {
	                validMoves.add(board[row-i][col]);
	            }
	            break; //The code stops after meeting a piece
	        }
	        i++;
	    }

	    return validMoves;
	}
}
