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
    	King bKing = new King(0,4,"black");
    	King wKing = new King(7,3,"white");
    	Queen bQueen = new Queen(0,3,"black");
    	Queen wQueen = new Queen(7,4,"white");
    	Rook bRook1 = new Rook(0,0,"black");
    	Rook wRook1 = new Rook(7,3,"white");
    	Rook bRook2 = new Rook(0,7,"black");
    	Rook wRook2 = new Rook(7,7,"white");
    	Bishop bBishop1 = new Bishop(0,2,"black");
    	Bishop wBishop1 = new Bishop(7,2,"white");
    	Bishop bBishop2 = new Bishop(0,5,"black");
    	Bishop wBishop2 = new Bishop(7,5,"white");
    	Knight bKnight1 = new Knight(0,1,"black");
    	Knight wKnight1 = new Knight(7,1,"white");
    	Knight bKnight2 = new Knight(0,6,"black");
    	Knight wKnight2 = new Knight(7,6,"white");
    	Pawn bPawn1 = new Pawn(1,0,"black");
    	Pawn bPawn2 = new Pawn(1,1,"black");
    	Pawn bPawn3 = new Pawn(1,2,"black");
    	Pawn bPawn4 = new Pawn(1,3,"black");
    	Pawn bPawn5 = new Pawn(1,4,"black");
    	Pawn bPawn6 = new Pawn(1,5,"black");
    	Pawn bPawn7 = new Pawn(1,6,"black");
    	Pawn bPawn8 = new Pawn(1,7,"black");
    	Pawn wPawn1 = new Pawn(6,0,"white");
    	Pawn wPawn2 = new Pawn(6,1,"white");
    	Pawn wPawn3 = new Pawn(6,2,"white");
    	Pawn wPawn4 = new Pawn(6,3,"white");
    	Pawn wPawn5 = new Pawn(6,4,"white");
    	Pawn wPawn6 = new Pawn(6,5,"white");
    	Pawn wPawn7 = new Pawn(6,6,"white");
    	Pawn wPawn8 = new Pawn(6,7,"white");
    	//board[0][0].setPiece(new Rook(0,0,"black"));
    	board[0][0].setPiece(bRook1);
    	board[0][1].setPiece(bKnight1);
    	board[0][2].setPiece(bBishop1);
    	board[0][3].setPiece(bQueen);
    	board[0][4].setPiece(bKing);
    	board[0][5].setPiece(bBishop2);
    	board[0][6].setPiece(bKnight2);
    	board[0][7].setPiece(bRook2);
    	board[1][0].setPiece(bPawn1);
    	board[1][1].setPiece(bPawn2);
    	board[1][2].setPiece(bPawn3);
    	board[1][3].setPiece(bPawn4);
    	board[1][4].setPiece(bPawn5);
    	board[1][5].setPiece(bPawn6);
    	board[1][6].setPiece(bPawn7);
    	board[1][7].setPiece(bPawn8);
    	board[7][0].setPiece(wRook1);
    	board[7][1].setPiece(wKnight1);
    	board[7][2].setPiece(wBishop1);
    	board[7][3].setPiece(wQueen);
    	board[7][4].setPiece(wKing);
    	board[7][5].setPiece(wBishop2);
    	board[7][6].setPiece(wKnight2);
    	board[7][7].setPiece(wRook2);
    	board[6][0].setPiece(wPawn1);
    	board[6][1].setPiece(wPawn2);
    	board[6][2].setPiece(wPawn3);
    	board[6][3].setPiece(wPawn4);
    	board[6][4].setPiece(wPawn5);
    	board[6][5].setPiece(wPawn6);
    	board[6][6].setPiece(wPawn7);
    	board[6][7].setPiece(wPawn8);
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