package board;
import java.awt.*;
import javax.swing.JPanel;

import app.Game;

// Represents the entire chessboard, which extends JPanel
public class Chessboard extends JPanel {
    private Square[][] board;
    Game game;
    
    public Chessboard(Game game) {
    	this.game = game;
    	board = new Square[8][8];
    	initBoard(); 		// Fill board with squares and initialize board
    	printBoard();		// Print board
    }
    
    public void initBoard() {
    	// Create squares line by line
    	// Go through rows then lines because of add() which add rows by rows
    	for (int row=0; row<8; row++) {
    		for (int col=0; col<8; col++) {
    			// create white or black square
    			if ((row+col)%2 == 0) board[row][col] = new Square(row*100, col*100, 'w', this.board, this.game);
    			else board[row][col] = new Square(row*100, col*100, 'b', this.board, this.game);
    			this.add(board[row][col]); 		// add square on the panel Chessboard
    		}
    	}
    	
    	this.initPieces();
    }
    
    public void initPieces() {
    	// To scale board
    	int targetH = (game.d.height-200)/8;
    	
    	// Create and set board on board
    	board[0][0].setPiece(new Rook("black", targetH));
    	board[0][1].setPiece(new Knight("black", targetH));
    	board[0][2].setPiece(new Bishop("black", targetH));
    	board[0][3].setPiece(new Queen("black", targetH));
    	board[0][4].setPiece(new King("black", targetH));
    	board[0][5].setPiece(new Bishop("black", targetH));
    	board[0][6].setPiece(new Knight("black", targetH));
    	board[0][7].setPiece(new Rook("black", targetH));
    	board[7][0].setPiece(new Rook("white", targetH));
    	board[7][1].setPiece(new Knight("white", targetH));
    	board[7][2].setPiece(new Bishop("white", targetH));
    	board[7][3].setPiece(new Queen("white", targetH));
    	board[7][4].setPiece(new King("white", targetH));
    	board[7][5].setPiece(new Bishop("white", targetH));
    	board[7][6].setPiece(new Knight("white", targetH));
    	board[7][7].setPiece(new Rook("white", targetH));
    	
    	for (int i=0; i<8; i++) {
        	board[6][i].setPiece(new Pawn("white", targetH));
        	board[1][i].setPiece(new Pawn("black", targetH));
    	}
    }
    
    public void printBoard() {
    	this.setPreferredSize(new Dimension(game.d.height-200, game.d.height-200)); // Size of panel
        this.setLayout(new GridLayout(8, 8)); 	// To organize squares in a grid
    	this.setOpaque(false); 			// Make the panel transparent
    	
    	// Print squares (black or transparent for white square)
    	for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
               	board[row][col].print();
            }
        }
    }

	public void resetBoard() {
		this.removeAllPieces();
		this.initPieces();
    	
	}

	private void removeAllPieces() {
		for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
               	if (board[row][col].isOccupied()) board[row][col].setPiece(null);
            }
        }
	}
}