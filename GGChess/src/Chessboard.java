import java.awt.*;
import javax.swing.JPanel;

// Represents the entire chessboard, which extends JPanel
public class Chessboard extends JPanel {
    private Square[][] board;
    Game game;
    
    Chessboard(Game game) {
    	this.game = game;
    	board = new Square[8][8];
    	initBoard(); 		// Fill board with squares and initialize pieces
    	printBoard();		// Print board
    }
    
    public void initBoard() {
    	// Create squares line by line
    	// Go through rows then lines because of add() which add rows by rows
    	for (int row=0; row<8; row++) {
    		for (int col=0; col<8; col++) {
    			// create white or black square
    			if ((row+col)%2 == 0) board[row][col] = new Square(row*100, col*100, 'w', this.board,this.game);
    			else board[row][col] = new Square(row*100, col*100, 'b', this.board, this.game);
    			this.add(board[row][col]); 		// add square on the panel Chessboard
    		}
    	}
    	
    	// Create and set pieces on board
    	board[0][0].setPiece(new Rook("black"));
    	board[0][1].setPiece(new Knight("black"));
    	board[0][2].setPiece(new Bishop("black"));
    	board[0][3].setPiece(new Queen("black"));
    	board[0][4].setPiece(new King("black"));
    	board[0][5].setPiece(new Bishop("black"));
    	board[0][6].setPiece(new Knight("black"));
    	board[0][7].setPiece(new Rook("black"));
    	board[1][0].setPiece(new Pawn("black"));
    	board[1][1].setPiece(new Pawn("black"));
    	board[1][2].setPiece(new Pawn("black"));
    	board[1][3].setPiece(new Pawn("black"));
    	board[1][4].setPiece(new Pawn("black"));
    	board[1][5].setPiece(new Pawn("black"));
    	board[1][6].setPiece(new Pawn("black"));
    	board[1][7].setPiece(new Pawn("black"));
    	board[7][0].setPiece(new Rook("white"));
    	board[7][1].setPiece(new Knight("white"));
    	board[7][2].setPiece(new Bishop("white"));
    	board[7][3].setPiece(new Queen("white"));
    	board[7][4].setPiece(new King("white"));
    	board[7][5].setPiece(new Bishop("white"));
    	board[7][6].setPiece(new Knight("white"));
    	board[7][7].setPiece(new Rook("white"));
    	board[6][0].setPiece(new Pawn("white"));
    	board[6][1].setPiece(new Pawn("white"));
    	board[6][2].setPiece(new Pawn("white"));
    	board[6][3].setPiece(new Pawn("white"));
    	board[6][4].setPiece(new Pawn("white"));
    	board[6][5].setPiece(new Pawn("white"));
    	board[6][6].setPiece(new Pawn("white"));
    	board[6][7].setPiece(new Pawn("white"));
    }
    
    public void printBoard() {
    	this.setPreferredSize(new Dimension(800, 800)); // Size of panel 800*800
        this.setLayout(new GridLayout(8, 8)); 	// To organize squares in a grid
    	this.setOpaque(false); 			// Make the panel transparent
    	
    	// Print squares (black or transparent for white square)
    	for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
               	board[row][col].print();
            }
        }
    }
}