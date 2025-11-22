import java.util.ArrayList;

public class Pawn extends Piece {
	public Pawn(String color) {
		super(color, "/"+color+"_pieces/pawn.png");
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int x = square.getX();
		int y = square.getY();
		if(x==2) {
			ValidMoves.add(board[x][y+1]);
			ValidMoves.add(board[x][y+2]);
		}
		else if(x<7) {
			ValidMoves.add(board[x][y+1]);
		}
		return ValidMoves;}

}
