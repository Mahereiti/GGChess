package app;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import board.Piece;

// killed Pieces
public class KillPiecesPanel extends JPanel {

    protected ArrayList<Piece> whiteKilled;
	protected ArrayList<Piece> blackKilled;
	
	public JPanel whiteKillPanel, blackKillPanel;
	
	public KillPiecesPanel(Game g) {
		// store killed board
        this.whiteKilled = new ArrayList<Piece>();
		this.blackKilled = new ArrayList<Piece>();
		
		// panels of killed board without layout
		whiteKillPanel = new JPanel(null);
		blackKillPanel = new JPanel(null);
		
		whiteKillPanel.setOpaque(false);
		blackKillPanel.setOpaque(false);
		
		whiteKillPanel.setPreferredSize(new Dimension(this.getWidth(), 200));
		blackKillPanel.setPreferredSize(new Dimension(this.getWidth(), 200));
		
		// Layout vertical with flexible spaces
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createGlue());
		this.add(whiteKillPanel);
		this.add(blackKillPanel);
		this.add(Box.createGlue());
		
		this.setPreferredSize(new Dimension((g.d.width-(g.d.height-200))/2, g.d.height-200));
		this.setOpaque(false);
	}
	
	public void killPiece(Piece p) {
		if(p.getColor().equals("white")) {
			whiteKilled.add(p);
			printWhiteKill(p);
		} else {
			blackKilled.add(p);
			printBlackKill(p);
		}
	}
	
	public void printWhiteKill(Piece p) {
		// new clickable image for the newly white killed piece
		Clickable kill = new Clickable();
		kill.setIcon(p.getIcon());
		
		int xStart = (this.getWidth()-310)/2;			// start x : (width - (7pieces*30+100))/2
		int xPiece = ((whiteKilled.size()-1)*30)%240;	// each piece +30px, reset every 8 board
		int yPiece = ((whiteKilled.size()-1)/8)*80;	// new row every 8 board
		
		kill.setBounds(xStart+xPiece, yPiece, 100, 100);
		whiteKillPanel.add(kill);
		repaint();		// force panel to redraw
	}
	
	public void printBlackKill(Piece p) {
		// new clickable image for the newly black killed piece
		Clickable kill = new Clickable();
		kill.setIcon(p.getIcon());
		int xStart = (this.getWidth()-310)/2;			// start x : (width - (7pieces*30+100))/2
		int xPiece = ((blackKilled.size()-1)*30)%240;	// each piece +30px, reset every 8 board
		
		int yStart = blackKillPanel.getHeight()-100;	// start y
		int yPiece = ((blackKilled.size()-1)/8)*80;	// new row every 8 board
		
		kill.setBounds(xStart+xPiece, yStart-yPiece, 100, 100);
		blackKillPanel.add(kill);
		repaint();		// force panel to redraw
	}

	public void reset() {
		whiteKillPanel.removeAll();
		blackKillPanel.removeAll();
		whiteKilled.clear();
		blackKilled.clear();
		this.repaint();
	}
}
