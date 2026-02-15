package app;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import board.Chessboard;
import board.Pawn;
import board.King;
import board.Square;
import data.Database;

import java.sql.SQLException;

// Class which represents the chess game, extends JPanel
public class Game extends JPanel {
	public GGChess windowPrincipal;
	public Dimension d;
	private boolean isPlaying;
	public PlayersPanel playersPanel;
	KillPiecesPanel killPiecesPanel;
	Chessboard chessboard;
	Database db = Database.getInstance();
	
	public Square enPassantTarget;

    public Game(GGChess window) {
    	this.windowPrincipal = window;
		this.d = window.d;
        isPlaying = true;
        enPassantTarget = null;
        
        // Layout of game (add all panels)
        this.setLayout(new BorderLayout());
        this.initBtnsPanel();
        this.initChessboardPanel();
        this.initPlayersPanel();
        this.initKillPiecesPanel();

        this.setPreferredSize(d);
        this.setOpaque(false);	// Transparent
    }
    
    public void initBtnsPanel() {
    	// Create btns
        Clickable menuBtn  = new Clickable("/galaxy/menu_b.png", 0, 0);
        Clickable playPauseBtn = new Clickable("/galaxy/pause.png", 0, 0);
        Clickable replayBtn = new Clickable("/galaxy/reset_b.png", 0, 0);
        
        // Create imageIcon to be able to change between play and pause btn
        ImageIcon play = new ImageIcon(getClass().getResource("/galaxy/play_b.png"));
        ImageIcon pause = new ImageIcon(getClass().getResource("/galaxy/pause.png"));
        
        // Scale btns to fit screen size
        menuBtn.scaleH(d.height/12);
        playPauseBtn.scaleH(d.height/12);
        replayBtn.scaleH(d.height/12);
        
        // add actions to btn
        menuBtn.addActionListener(e -> windowPrincipal.showMenu());
        replayBtn.addActionListener(e-> this.resetGame());
        playPauseBtn.addActionListener(e-> {
        	if (isPlaying) {
        		playPauseBtn.setIcon(play);
        	} else {
        		playPauseBtn.setIcon(pause);
        	}
            playPauseBtn.scaleH(d.height/12);
        	isPlaying = !isPlaying;
        });
        
        JPanel btnsPanel = new JPanel();
        // Layout of btnsPanel with spaces
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.add(menuBtn);
        btnsPanel.add(playPauseBtn);
        btnsPanel.add(replayBtn);
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.setOpaque(false);		// Transparent
        
        this.add(btnsPanel, BorderLayout.SOUTH); 	// add BtnsPanel to game
    }
    
    public void initChessboardPanel() {
        chessboard = new Chessboard(this);
        
        // wrapper to have a fixed chessboard
        JPanel chessboardWrapper = new JPanel(new GridBagLayout());
        chessboardWrapper.setOpaque(false);
        
        chessboardWrapper.add(chessboard);
        this.add(chessboardWrapper, BorderLayout.CENTER);	// add chessboard
    }
    
    public void initPlayersPanel() {
        playersPanel = new PlayersPanel(this);
        this.add(playersPanel, BorderLayout.WEST);		// add playersPanel
    }
    
    public void initKillPiecesPanel() {
        killPiecesPanel = new KillPiecesPanel(this);
        this.add(killPiecesPanel, BorderLayout.EAST);	// add killPiecesPanel
    }
    
    // Move the piece from the initial to the final square
 	public void move(Square initSquare, Square finalSquare) {
 		this.killEnPassantTarget(initSquare, finalSquare);
 		this.updateEnPassantTarget(initSquare, finalSquare);
 		
 		if (initSquare.getPiece() instanceof King) this.castling(initSquare, finalSquare);

 		// We "kill" the piece in the final Square if there is one
 		if (finalSquare.isOccupied()) {
 			killPiecesPanel.killPiece(finalSquare.getPiece());
 			if(finalSquare.getPiece() instanceof King) {
 				try {
 					db.updateWins(playersPanel.getCurrentPlayerName());
 				} catch (SQLException e) {
 					e.printStackTrace();
 				}
 				try {
 					db.updateLosses(playersPanel.getNonCurrentPlayerName());
 				} catch (SQLException e) {
 					e.printStackTrace();
 				}
 			}
 		}
 		finalSquare.setPiece(initSquare.getPiece()); 	// Put the piece in the final Square
 		initSquare.setPiece(null); 		// Remove the piece from the init Square
 		if (isEchec(finalSquare)) {
 				
 			}
 	}
 
 	
 	public boolean isEchec(Square s) {
 		for(Square sq: s.getPiece().getValidMoves()) {
				if(sq.getPiece() instanceof King && !sq.getPiece().getColor().equals(playersPanel.getCurrentPlayerColor())) {
					return true;
				}
		}
		return false;
 	}

 	public void updateEnPassantTarget(Square initS, Square finalS) {
 		// if pawn moved 2 squares -> lock target
 		if (initS.getPiece() instanceof Pawn && 
 				Math.abs((initS.getRow()/100)-(finalS.getRow()/100))==2) {
 			enPassantTarget = finalS;
 		} else enPassantTarget = null;
 	}
 	
 	public void killEnPassantTarget(Square initS, Square finalS) {
 		if (enPassantTarget != null && initS.getPiece() instanceof Pawn) {
 			int initRow = initS.getRow()/100;
 			int initCol = initS.getCol()/100;
 			int finalRow = finalS.getRow()/100;
 			int finalCol = finalS.getCol()/100;
 			int targetRow = enPassantTarget.getRow()/100;
 			int targetCol = enPassantTarget.getCol()/100;
 			
 			if (Math.abs(finalCol-initCol)==1 && Math.abs(finalRow-initRow)==1
 		 		 && Math.abs(finalRow-targetRow)==1 && finalCol == targetCol) {
 				killPiecesPanel.killPiece(enPassantTarget.getPiece());
 				enPassantTarget.setPiece(null);
 			}
 		}
 	}
 	
 	public void castling(Square initS, Square finalS) {
 		int row = initS.getRow()/100;
 		// Little castling
		if (finalS.getCol()/100-initS.getCol()/100 == 2) {
			Square initSRook = chessboard.getBoard()[row][7];
			Square finalSRook = chessboard.getBoard()[row][5];
			
			finalSRook.setPiece(initSRook.getPiece());
			initSRook.setPiece(null);
		}
		// Big castling
		if (initS.getCol()/100-finalS.getCol()/100 == 2) {
			Square initSRook = chessboard.getBoard()[row][0];
			Square finalSRook = chessboard.getBoard()[row][3];
			
			finalSRook.setPiece(initSRook.getPiece());
			initSRook.setPiece(null);
		}
 	}
 	
 	public Square getEnPassantTarget() {
 		return enPassantTarget;
 	}

	public void switchPlayer() {
		playersPanel.switchPlayer();
    }
	
	public void resetGame() {
		chessboard.resetBoard();
		killPiecesPanel.reset();
		playersPanel.reset();
	}
}

