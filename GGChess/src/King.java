import java.util.ArrayList;

public class King extends Piece {
	
	public King(String color) {
		super(color, "/"+color+"_pieces/king.png");
	}
	
	@Override
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int row = square.getRow()/100;
		int col = square.getCol()/100;
		
		if(row>0) {
			if(!board[row-1][col].isOccupied() || !board[row-1][col].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[row-1][col]);
			}
		}
		if(col>0) {
			if(!board[row][col-1].isOccupied() || !board[row][col-1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[row][col-1]);
			}
		}
		if(row<7) {
			if(!board[row+1][col].isOccupied() || !board[row+1][col].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[row+1][col]);
			}
		}
		if(col<7) {
			if(!board[row][col+1].isOccupied() || !board[row][col+1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[row][col+1]);
			}
		}
		if(row>0 && col>0) {
			if(!board[row-1][col-1].isOccupied() || !board[row-1][col-1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[row-1][col-1]);
			}
		}
		if(row>0 && col<7) {
			if(!board[row-1][col+1].isOccupied() || !board[row-1][col+1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[row-1][col+1]);
			}
		}
		if(row<7 && col>0) {
			if(!board[row+1][col-1].isOccupied() || !board[row+1][col-1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[row+1][col-1]);
			}	
		}
		if(row<7 && col<7) {
			if(!board[row+1][col+1].isOccupied() || !board[row+1][col+1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[row+1][col+1]);
			}
		}
		return ValidMoves;}
}