package board;
import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(String color, int targetH) {
		super(color, "/"+color+"_pieces/bishop.png", targetH);
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int row = square.getRow()/100;
		int col = square.getCol()/100;
		//top right
		int i;
		i=1;
		while((col+i)<8 && (row+i)<8) {
			if(!board[row+i][col+i].isOccupied()) {
				ValidMoves.add(board[row+i][col+i]);
			} else {
		        if (!board[row+i][col+i].getPiece().getColor().equals(this.color)) { //if we meet an enemy piece 
		            ValidMoves.add(board[row+i][col+i]);
		        }
		        break;
			}
			i++;
		}
		//top left
		i=1;
		while((col-i)>=0 && (row+i)<8) {
			if(!board[row+i][col-i].isOccupied()) {
				ValidMoves.add(board[row+i][col-i]);
			} else {
		        if (!board[row+i][col-i].getPiece().getColor().equals(this.color)) { //if we meet an enemy piece 
		            ValidMoves.add(board[row+i][col-i]);
		        }
		        break;
			}
			i++;
		}
		//down left
		i=1;
		while((col-i)>=0 && (row-i)>=0) {
			if(!board[row-i][col-i].isOccupied()) {
				ValidMoves.add(board[row-i][col-i]);
			} else {
		        if (!board[row-i][col-i].getPiece().getColor().equals(this.color)) { //if we meet an enemy piece 
		            ValidMoves.add(board[row-i][col-i]);
		        }
		        break;
			}
			i++;
		}
		//down right
		i=1;
		while((col+i)<8 && (row-i)>=0) {
			if(!board[row-i][col+i].isOccupied()) {
				ValidMoves.add(board[row-i][col+i]);
			} else {
		        if (!board[row-i][col+i].getPiece().getColor().equals(this.color)) { //if we meet an enemy piece 
		            ValidMoves.add(board[row-i][col+i]);
		        }
		        break;
			}
			i++;
		}
		
		return ValidMoves;}
}
