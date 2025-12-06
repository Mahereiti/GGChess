package board;
import javax.swing.*;

import app.Game;

import java.awt.Image;
import java.util.ArrayList;

public abstract class Piece {
	protected String color;
	protected ImageIcon icon;
	protected Square square;
	
	protected boolean hasMoved;
	
	public Piece(String color, String path, int targetH){
		this.color = color;
		this.icon = new ImageIcon(getClass().getResource(path));
		this.icon.setImage(this.icon.getImage().getScaledInstance(targetH, targetH, Image.SCALE_SMOOTH));
		this.hasMoved = false;
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

	public boolean hasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean b) {
		hasMoved = b;
	}
}
