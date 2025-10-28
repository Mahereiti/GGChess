import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Chessboard extends JPanel {
    private Square[][] board;
    Game game;
    
    Chessboard(Game game) {
    	this.game = game;
    	board = new Square[8][8];
    	initBoard();
    	printBoard();
    }
    
    public void initBoard() {
    	// Create squares
    	for (int x=0; x<8; x++) {
    		for (int y=0; y<8; y++) {
    			if ((x+y)%2 == 0) {
    				board[x][y] = new Square(x*100, y*100, 'w');
    			}
    			else board[x][y] = new Square(x*100, y*100, 'b');
    			this.add(board[x][y]);
    		}
    	}
    	
    	// Create and set pieces on board
    	King wKing = new King(
    	//board[0][0].setPiece(new Rook(0,0,"black"));
    	// ...
    	// Add squares to the panel
    	//this.add(board[]...
        
    }
    
    public void printBoard() {
    	this.setPreferredSize(new Dimension(800, 800));
        this.setLayout(new GridLayout(8, 8)); 
    	this.setOpaque(false); 			// Make the panel transparent
    	
    	// Print squares
    	for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
               	board[x][y].print();
            }
        }
    }
}