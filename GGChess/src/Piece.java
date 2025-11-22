import java.awt.Image;
import javax.swing.*;
import java.util.ArrayList;

public abstract class Piece {
	protected String color;
	protected ImageIcon icon;
	protected Square square;
	
	public Piece(String color, String path){
		this.color = color;
		this.icon = new ImageIcon(getClass().getResource(path));
	}
	
	// getters
	public String getColor() {return this.color;}
	
	public ImageIcon getIcon() {return this.icon;}
	
	public Square getSquare() {
	    return square;
	}
	
	//setters
	public void setSquare(Square square) {
	    this.square = square;
	}
	
	// Move the piece from the initial to the final square
	public void move(Square initSquare, Square finalSquare) {
		if(finalSquare.isOccupied()==false ||  finalSquare.getPiece().getColor()!=initSquare.getPiece().getColor()) {
			finalSquare.setPiece(initSquare.getPiece()); 	//Put the piece in the final Square
			initSquare.setPiece(null); 		//Remove the piece from the init Square
		}
		else {JOptionPane.showMessageDialog(null, "Erreur de saisie !", "Erreur", JOptionPane.ERROR_MESSAGE);}
	}

	public void kill() {
		
	}
	
	// ----MODIF
	public abstract ArrayList<Square> getValidMoves();
}
