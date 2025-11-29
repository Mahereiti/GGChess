import java.awt.Color;

// class representing a square on the Chessboard, which extends Cliquable which extends JButton
public class Square extends Cliquable {
    private int x, y;			// Position on panel Chessboard (0->800)
    private char color; 		// b (black) or w (white)
    private Piece piece;		// Piece on square
    private Square[][] board;
    
    public Square(int x, int y, char color, Square[][] board,Game game) {
    	super(x, y, 100, 100);
        this.x = x;
        this.y = y;
        this.color = color;
        this.board = board;
        this.piece = null;	// Square contains nothing
        
        Mouse m = new Mouse(game);
        // Add ActionListener to handle click
        this.addActionListener(e -> m.clickOnSquare(this));
    }
    
    // getters
    public int getX() {return x;}

    public int getY() {return y;}
    
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
		if ((getX()/100+getY()/100)%2 != 0) {
			this.setBackground(Color.BLACK);
			this.setOpaque(true);
		// If white square, just make it transparent
		} else this.setOpaque(false);
	}
}
    
