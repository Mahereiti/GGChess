import javax.swing.*;

public abstract class Piece {
	protected int x, y;
	protected String color;
	
	public Piece(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	// getters
	public String getColor() {return this.color;}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void kill() {
		
	}
	
	// ----MODIF
	public abstract Square[] getValidMoves();
}
