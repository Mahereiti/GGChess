
public class King extends Piece {
	
	public King(String color) {
		super(color, "/"+color+"_pieces/king.png");
	}
	
	@Override
	public Square[] getValidMoves() {
		return null;
		
	}
}