
public class Rook extends Piece{
	public Rook(int x,int y,String color, Square[][] board) {
		super(x,y,color, board);
	}
	
	public abstract Square[] getValidMoves() {}
}
