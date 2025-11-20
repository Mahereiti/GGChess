import java.awt.Image;
import javax.swing.*;

public abstract class Piece {
	protected String color;
	protected ImageIcon icon;
	
	public Piece(String color, String path){
		this.color = color;
		this.icon = new ImageIcon(getClass().getResource(path));
	}
	
	// getters
	public String getColor() {return this.color;}
	
	public ImageIcon getIcon() {return this.icon;}
	
	// Move the piece from the initial to the final square
	public void move(Square initSquare, Square finalSquare) {
        finalSquare.setPiece(initSquare.getPiece()); 	//Put the piece in the final Square
        initSquare.setPiece(null); 		//Remove the piece from the init Square
	}

	public void kill() {
		
	}
	
	// ----MODIF
	public abstract Square[] getValidMoves();
}
