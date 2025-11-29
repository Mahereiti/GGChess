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
	
	public abstract ArrayList<Square> getValidMoves();
}
