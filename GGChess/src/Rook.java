
public class Rook extends Piece{
	public Rook(int x,int y,String color) {
		super(x,y,color);
	}
	
	public abstract Square[] getValidMoves() {}
}
