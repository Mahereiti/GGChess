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
		int x = square.getX();
		int y = square.getY();
		if(x>0) {
			if(!board[x-1][y].isOccupied() || !board[x-1][y].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[x-1][y]);
			}
		}
		if(y>0) {
			if(!board[x][y-1].isOccupied() || !board[x][y-1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[x][y-1]);
			}
		}
		if(x<7) {
			if(!board[x+1][y].isOccupied() || !board[x+1][y].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[x+1][y]);
			}
		}
		if(y<7) {
			if(!board[x][y+1].isOccupied() || !board[x][y+1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[x][y+1]);
			}
		}
		if(x>0 && y>0) {
			if(!board[x-1][y-1].isOccupied() || !board[x-1][y-1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[x-1][y-1]);
			}
		}
		if(x>0 && y<7) {
			if(!board[x-1][y+1].isOccupied() || !board[x-1][y+1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[x-1][y+1]);
			}
		}
		if(x<7 && y>0) {
			if(!board[x+1][y-1].isOccupied() || !board[x+1][y-1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[x+1][y-1]);
			}	
		}
		if(x<7 && y<7) {
			if(!board[x+1][y+1].isOccupied() || !board[x+1][y+1].getPiece().getColor().equals(this.color)) {
				ValidMoves.add(board[x+1][y+1]);
			}
		}
		return ValidMoves;}
}