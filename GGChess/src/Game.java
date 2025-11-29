import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

// Class which represents the chess game, extends JPanel
public class Game extends JPanel {

    private Square selectedSquare1 = null;
    public Player whitePlayer;
    public Player blackPlayer;
    public Player currentPlayer;
    protected ArrayList<Piece> whiteKilled;
	protected ArrayList<Piece> blackKilled;

    public Game(GGChess window) {

        Cliquable menuBtn  = new Cliquable("/galaxy/menu_b.png", 100, 100, 100, 100);
        menuBtn.addActionListener(e -> window.showMenu());
        this.add(menuBtn);
        menuBtn.setBounds(100, 100, 100, 100);

        Chessboard chessboard = new Chessboard(this);
        JPanel activePlayers = new JPanel();

        this.add(activePlayers);
        this.add(chessboard);

        this.setOpaque(false);
        
        this.whiteKilled = new ArrayList<>();
		this.blackKilled = new ArrayList<>();
    }
    
	// Move the piece from the initial to the final square
	public void move(Square initSquare, Square finalSquare) {
		finalSquare.setPiece(initSquare.getPiece()); 	//Put the piece in the final Square
		initSquare.setPiece(null); 		//Remove the piece from the init Square
	}

	public void kill(Square initSquare, Square finalSquare) {
		if(finalSquare.getPiece().getColor().equals("white")) {
			whiteKilled.add(finalSquare.getPiece());
		}
		else {blackKilled.add(finalSquare.getPiece());}
		finalSquare.setPiece(initSquare.getPiece()); 	//Put the piece in the final Square
		initSquare.setPiece(null); 		//Remove the piece from the init Square
	}

    public void handleSquareClicked(Square s) {
    	//Handles the first click
    	if (selectedSquare1 == null) {  
    		//if the player has not selected a piece to move
        	if (!s.isOccupied()) {
                System.out.println("Error, this square does not contain a piece, please select a piece");
                return;
            }
        	//if the player selects a piece that not belongs him
        	if (!s.getPiece().getColor().equals(currentPlayer.getColor())) {
                System.out.println("Error, this is not your piece");
                return;
            }
        	//If everything is ok (the piece is selected)
        	selectedSquare1 = s;
            return;
        }
    	//handles the second click
        if (selectedSquare1 != null) {
        	//if the player selects two times the same square, it allows him to cancel the selection of the piece
        	if (s == selectedSquare1) {
                System.out.println("Selection canceled");
                selectedSquare1 = null;
                return;
            }
        	//if the move is not valid
        	if (!selectedSquare1.getPiece().getValidMoves().contains(s)) {
                System.out.println("Error, this move is not valid");
                selectedSquare1 = null;
                return;
            }
        	//If everything is ok
        	if(s.isOccupied()) {
        		kill(selectedSquare1,s); //the piece is killed
        		switchPlayer();       //the player is switched
                return;
        	}
        	else {
            move(selectedSquare1, s); //the move is done
            switchPlayer();       //the player is switched
            return;
        	}
        }
        //for unexpected problem
        selectedSquare1 = null;
        System.out.println("Unexpected Error");
    }

	public void switchPlayer() {
		if (currentPlayer == whitePlayer) {
            currentPlayer = blackPlayer;
        } else {
            currentPlayer = whitePlayer;
        }
        System.out.println("It's the turn of : " + currentPlayer.getName());
    }
}

