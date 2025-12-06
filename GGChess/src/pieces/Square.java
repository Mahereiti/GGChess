package pieces;
import java.awt.Color;

import app.Clickable;
import app.Mouse;
import app.Game;

// class representing a square on the Chessboard, which extends Clickable which extends JButton
public class Square extends Clickable {
    private int row, col;			// Position on panel Chessboard (0->800)
    private char color; 		// b (black) or w (white)
    private Piece piece;		// Piece on square
    private Square[][] board;
    
    public Square(int row, int col, char color, Square[][] board, Game game) {
    	super(row, col, (game.d.height-100)/8, (game.d.height-100)/8);
        this.row = row;
        this.col = col;
        this.color = color;
        this.board = board;
        this.piece = null;	// Square contains nothing
        
        Mouse m = new Mouse(game);
        // Add ActionListener to handle click
        this.addActionListener(e -> m.clickOnSquare(this));
    }
    
    // getters
    public int getRow() {return row;}
    
    public int getCol() {return col;}
    
    public char getColor() {return color;}
    
    public Piece getPiece() {return piece;}
    
    public Square[][] getBoard() {return board;}
    
    // setter (others attributs don't change)
    public void setPiece(Piece piece) {
		this.piece = piece;
		// update image of piece
    	if (piece == null) setIcon(null);
    	else {
    		setIcon(piece.getIcon());
    		piece.setSquare(this);   //link between the square and the piece
    	}
    }
    
    // Contains piece or not
    public boolean isOccupied() {
    	if (piece != null) return true;
    	else return false;
    }
    
	// Print square
	public void print() {
		// If black square
		if ((getCol()/100+getRow()/100)%2 != 0) {
			this.setBackground(Color.BLACK);
			this.setOpaque(true);
		// If white square, just make it transparent
		} else this.setOpaque(false);
	}
	
	public void setInRed() {
		this.setBackground(Color.RED);
		this.setOpaque(true); 	// make it visible
	}
	
	public void resetColor() {
	    if (color == 'b') {
	        this.setBackground(Color.BLACK);
	    } else {
	        this.setOpaque(false);
	    }
	    repaint();		// refresh
	}
}
    
