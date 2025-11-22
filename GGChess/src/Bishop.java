import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(String color) {
		super(color, "/"+color+"_pieces/bishop.png");
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int x = square.getX();
		int y = square.getY();
		for(int i=1; (x+i)<7; i++) {
			for(int j=1; (y+j)<7; i++) {
				ValidMoves.add(board[x+i][y+j]);
			}
		}
		for(int i=1; (x-i)>=0; i++) {
			for(int j=1; (y-i)>=0; i++) {
				ValidMoves.add(board[x-i][y-j]);
			}
		}
		return ValidMoves;}
}
