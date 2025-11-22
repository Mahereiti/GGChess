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
		if(x<5 && y>0) {
			ValidMoves.add(board[x+3][y-1]);
		}
		if(x<5 && y>7) {
			ValidMoves.add(board[x+3][y+1]);
		}
		if(x>2 && y>0) {
			ValidMoves.add(board[x-3][y-1]);
		}
		if(x>2 && y>7) {
			ValidMoves.add(board[x-3][y+1]);
		}
		if(x>0 && y<5) {
			ValidMoves.add(board[x-1][y+3]);
		}
		if(x>7 && y<5) {
			ValidMoves.add(board[x+1][y+3]);
		}
		if(x>0 && y>2) {
			ValidMoves.add(board[x-1][y-3]);
		}
		if(x>7 && y>2) {
			ValidMoves.add(board[x+1][y-3]);
		}
		
		return ValidMoves;}
}
