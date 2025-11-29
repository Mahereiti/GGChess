import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

// Class which represents the chess game, extends JPanel
public class Game extends JPanel {
    public Player whitePlayer;
    public Player blackPlayer;
    public Player currentPlayer;
    protected ArrayList<Piece> whiteKilled;
	protected ArrayList<Piece> blackKilled;
	Dimension d;
	private boolean isPlaying;

    public Game(GGChess window) {
        this.whiteKilled = new ArrayList<Piece>();
		this.blackKilled = new ArrayList<Piece>();
		this.d = window.d;
		
		// Create btns
        Clickable menuBtn  = new Clickable("/galaxy/menu_b.png", 0, 0);
        Clickable playPauseBtn = new Clickable("/galaxy/pause.png", 0, 0);
        Clickable replayBtn = new Clickable("/galaxy/reset_b.png", 0, 0);
        
        // Create imageIcon to be able to change between play and pause btn
        ImageIcon play = new ImageIcon(getClass().getResource("/galaxy/play_b.png"));
        ImageIcon pause = new ImageIcon(getClass().getResource("/galaxy/pause.png"));
        isPlaying = true;
        
        // Scale btns to fit screen size
        menuBtn.scaleH(d.height/12);
        playPauseBtn.scaleH(d.height/12);
        replayBtn.scaleH(d.height/12);
        
        // add actions to btn
        menuBtn.addActionListener(e -> window.showMenu());
        playPauseBtn.addActionListener(e-> {
        	if (isPlaying) {
        		playPauseBtn.setIcon(play);
        	} else {
        		playPauseBtn.setIcon(pause);
        	}
            playPauseBtn.scaleH(d.height/12);
        	isPlaying = !isPlaying;
        });
        

        Chessboard chessboard = new Chessboard(this);
        JPanel activePlayers = new JPanel();
        JPanel btnsPanel = new JPanel();
        
        blackPlayer = new Player("black");
        whitePlayer = new Player("white");
        currentPlayer = whitePlayer;
        
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.add(menuBtn);
        btnsPanel.add(playPauseBtn);
        btnsPanel.add(replayBtn);
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.setOpaque(false);		// Transparent
        
        activePlayers.setOpaque(false);
        
        this.setLayout(new BorderLayout());
        this.add(activePlayers, BorderLayout.WEST);
        this.add(chessboard, BorderLayout.CENTER);
        this.add(btnsPanel, BorderLayout.SOUTH);


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

