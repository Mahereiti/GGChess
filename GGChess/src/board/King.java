package board;
import java.util.ArrayList;

public class King extends Piece {
	
	public King(String color, int targetH) {
		super(color, "/"+color+"_pieces/king.png", targetH);
	}
	
	@Override
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> validMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int row = square.getRow()/100;
		int col = square.getCol()/100;
		
		if(row>0) {
			if(!board[row-1][col].isOccupied() || !board[row-1][col].getPiece().getColor().equals(this.getColor())) {
				validMoves.add(board[row-1][col]);
			}
		}
		if(col>0) {
			if(!board[row][col-1].isOccupied() || !board[row][col-1].getPiece().getColor().equals(this.getColor())) {
				validMoves.add(board[row][col-1]);
			}
		}
		if(row<7) {
			if(!board[row+1][col].isOccupied() || !board[row+1][col].getPiece().getColor().equals(this.getColor())) {
				validMoves.add(board[row+1][col]);
			}
		}
		if(col<7) {
			if(!board[row][col+1].isOccupied() || !board[row][col+1].getPiece().getColor().equals(this.getColor())) {
				validMoves.add(board[row][col+1]);
			}
		}
		if(row>0 && col>0) {
			if(!board[row-1][col-1].isOccupied() || !board[row-1][col-1].getPiece().getColor().equals(this.getColor())) {
				validMoves.add(board[row-1][col-1]);
			}
		}
		if(row>0 && col<7) {
			if(!board[row-1][col+1].isOccupied() || !board[row-1][col+1].getPiece().getColor().equals(this.getColor())) {
				validMoves.add(board[row-1][col+1]);
			}
		}
		if(row<7 && col>0) {
			if(!board[row+1][col-1].isOccupied() || !board[row+1][col-1].getPiece().getColor().equals(this.getColor())) {
				validMoves.add(board[row+1][col-1]);
			}	
		}
		if(row<7 && col<7) {
			if(!board[row+1][col+1].isOccupied() || !board[row+1][col+1].getPiece().getColor().equals(this.getColor())) {
				validMoves.add(board[row+1][col+1]);
			}
		}
		
		// Special cases
		
		// Castling
		// Big castling
		if (!hasMoved && !board[row][1].isOccupied() && !board[row][2].isOccupied() && !board[row][3].isOccupied()
				&& (board[0][0].getPiece() instanceof Rook) && !board[0][0].getPiece().hasMoved()) {
			validMoves.add(board[row][2]);
		}
		
		// Little castling
		if (!hasMoved && !board[row][5].isOccupied() && !board[row][6].isOccupied()
				&& (board[row][0].getPiece() instanceof Rook) && !board[row][0].getPiece().hasMoved()) {
			validMoves.add(board[row][6]);
		}
		
		return validMoves;}
}