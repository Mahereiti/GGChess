import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.sql.SQLException;

// Class which represents the chess game, extends JPanel
public class Game extends JPanel {
	Dimension d;
	private boolean isPlaying;
	Players playersPanel;
	KillPiecesPanel killPiecesPanel;
	Database db = Database.getInstance();

    public Game(GGChess window) {
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
        
        // panels
        Chessboard chessboard = new Chessboard(this);
        playersPanel = new Players(this);
        killPiecesPanel = new KillPiecesPanel(this);
        JPanel btnsPanel = new JPanel();
        
        // wrapper to have a fixed chessboard
        JPanel chessboardWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        chessboardWrapper.add(chessboard);
        chessboardWrapper.setOpaque(false);
        
        // Layout of btnsPanel with spaces
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.add(menuBtn);
        btnsPanel.add(playPauseBtn);
        btnsPanel.add(replayBtn);
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.setOpaque(false);		// Transparent
        
        // Layout of game (add all panels)
        this.setLayout(new BorderLayout());
        this.add(chessboardWrapper, BorderLayout.CENTER);
        this.add(playersPanel, BorderLayout.WEST);
        this.add(killPiecesPanel, BorderLayout.EAST);
        this.add(btnsPanel, BorderLayout.SOUTH);

        this.setPreferredSize(d);
        this.setOpaque(false);	// Transparent
    }
    
    // Move the piece from the initial to the final square
 	public void move(Square initSquare, Square finalSquare) {
 		// We "kill" the piece in the final Square if there is one
 		if (finalSquare.isOccupied()) {
 			killPiecesPanel.killPiece(finalSquare.getPiece());
 			//if(finalSquare.getPiece() instanceof King) {
 				//try {
 					//db.updateWins(playersPanel.getCurrentPlayer());
 				//} catch (SQLException e) {
 					//e.printStackTrace();
 				//}
 				//try {
 					//db.updateLosses(playersPanel.getNonCurrentPlayer());
 				//} catch (SQLException e) {
 					//e.printStackTrace();
 				//}
 			//}
 		}
 		
 		finalSquare.setPiece(initSquare.getPiece()); 	// Put the piece in the final Square
 		initSquare.setPiece(null); 		// Remove the piece from the init Square
 	}

	public void switchPlayer() {
		playersPanel.switchPlayer();
    }
}

