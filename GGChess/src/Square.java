import java.awt.Color;
import java.awt.Dimension;


public class Square extends Cliquable {
    private int x, y;
    private char color; 		// b (black) or w (white)
    private Piece piece;
    
    public Square(int x, int y, char color) {
    	super("/galaxy/square_"+color+".png", x, y, 100, 100);
        this.x = x;
        this.y = y;
        this.color = color;
        this.piece = null;	// Case null
    }
    
    // getters and setter
    public int getX() {return x;}

    public int getY() {return y;}
    
    public char getColor() {return color;}
    
    public Piece getPiece() {return piece;}
    
    public void setPiece(Piece piece) {this.piece = piece;}
    
    public boolean isOccupied() {
    	if (piece != null) return true;
    	else return false;
    }

	public void print() {
		// Print square
		if ((getX()+getY())%2 == 0) {
			this.setBackground(Color.WHITE);
		}
		else this.setBackground(Color.DARK_GRAY);
		
		/*
                this.addActionListener(e -> {      //We add a listener for each button
                    game.caseClicked(x, y);
                });
            }
        }
        */
	}
	
	public void clic() {
		
	}
}
    
