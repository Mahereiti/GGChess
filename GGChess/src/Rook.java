import java.util.ArrayList;

public class Rook extends Piece{
	public Rook(String color) {
		super(color, "/"+color+"_pieces/rook.png");
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int x = square.getX();
		int y = square.getY();
		for(int i=0; i<8; i++) {
			ValidMoves.add(board[x][i]);
		}
		for(int i=0; i<8; i++) {
			ValidMoves.add(board[i][y]);
		}
		return ValidMoves;}
}
