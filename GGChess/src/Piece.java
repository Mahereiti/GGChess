import javax.swing.*;

public abstract class Piece {
	protected int x, y;
	protected String color;
	private Square[][] board;
	
	public Piece(int x, int y, String color, Square[][] board){
		this.x = x;
		this.y = y;
		this.color = color;
		this.board = board;
	}
	
	// getters
	public String getColor() {return this.color;}
	
	//setters
	public void setPiecePosition(int x,int y) {
		this.x= x;
		this.y= y;
		
	}
	
	public void move(Square initSquare,Square finalSquare) {

        //collect the piece from initSquare
        Piece p = initSquare.getPion();

        if (p == null) {return;} //Verify is the square contains the piece

        //update of the position of the piece
        else {p.setPiecePosition(finalSquare.getX(), finalSquare.getY());}

        //Put the piece in the final Square
        finalSquare.setPiece(p);

        //Remove the piece from the init Square
        //initSquare.setPiece(null);
		
	}

	public void kill() {
		
	}
	
	// ----MODIF
	public abstract Square[] getValidMoves();
}
