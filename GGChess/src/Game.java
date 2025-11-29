import java.util.ArrayList;
import javax.swing.JPanel;

// Class which represents the chess game, extends JPanel
public class Game extends JPanel {
    public String whitePlayer;
    public String blackPlayer;
    public String currentPlayer;
    protected ArrayList<Piece> whiteKilled;
	protected ArrayList<Piece> blackKilled;

    public Game(GGChess window) {
        this.whiteKilled = new ArrayList<Piece>();
		this.blackKilled = new ArrayList<Piece>();
		
        Cliquable menuBtn  = new Cliquable("/galaxy/menu_b.png", 100, 100, 100, 100);
        menuBtn.addActionListener(e -> window.showMenu());

        Chessboard chessboard = new Chessboard(this);
        JPanel activePlayers = new JPanel();
        
        blackPlayer = "black";
        whitePlayer = "white";
        currentPlayer = blackPlayer;
        
        this.add(menuBtn);
        this.add(activePlayers);
        this.add(chessboard);

        this.setOpaque(false);
    }
    
    // Move the piece from the initial to the final square
 	public void move(Square initSquare, Square finalSquare) {
 		// We "kill" the piece in the final Square if there is one
 		if (finalSquare.isOccupied()) {
 			if(finalSquare.getPiece().getColor().equals("white")) {
 	 			whiteKilled.add(finalSquare.getPiece());
 	 		} else blackKilled.add(finalSquare.getPiece());
 		}
 		
 		finalSquare.setPiece(initSquare.getPiece()); 	// Put the piece in the final Square
 		initSquare.setPiece(null); 		// Remove the piece from the init Square
 	}

	public void switchPlayer() {
		if (currentPlayer == whitePlayer) currentPlayer = blackPlayer;
        else currentPlayer = whitePlayer;
    }
}

