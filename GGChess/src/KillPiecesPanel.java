import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

// killed Pieces
public class KillPiecesPanel extends JPanel {

    protected ArrayList<Piece> whiteKilled;
	protected ArrayList<Piece> blackKilled;
	
	public JPanel whiteKillPanel, blackKillPanel;
	
	public KillPiecesPanel(Game g) {
		// store killed pieces
        this.whiteKilled = new ArrayList<Piece>();
		this.blackKilled = new ArrayList<Piece>();
		
		// panels of killed pieces without layout
		whiteKillPanel = new JPanel(null);
		blackKillPanel = new JPanel(null);
		
		whiteKillPanel.setBackground(Color.gray);
		blackKillPanel.setBackground(Color.black);		
		
		// Layout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(whiteKillPanel);
		this.add(blackKillPanel);
		
		
		this.setPreferredSize(new Dimension((g.d.width-(g.d.height-200))/2, g.d.height-200));
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
		
		int xStart = (this.getWidth()-310)/2;			// start point : (width - (7pieces*30+100))/2
		int xPiece = ((whiteKilled.size()-1)*30)%240;	// each piece +30px, reset every 8 pieces
		int yPiece = ((whiteKilled.size()-1)/8)*100;	// new row every 8 pieces
		
		kill.setBounds(xStart+xPiece, yPiece, 100, 100);
		whiteKillPanel.add(kill);
		repaint();		// force panel to redraw
	}
	
	public void printBlackKill(Piece p) {
		// new clickable image for the newly black killed piece
		Clickable kill = new Clickable();
		kill.setIcon(p.getIcon());
		int xStart = (this.getWidth()-310)/2;			// start point : (width - (7pieces*30+100))/2
		int xPiece = ((whiteKilled.size()-1)*30)%240;	// each piece +30px, reset every 8 pieces
		int yPiece = ((whiteKilled.size()-1)/8)*100;	// new row every 8 pieces
		
		kill.setBounds(xStart+xPiece, yPiece, 100, 100);
		blackKillPanel.add(kill);
		repaint();		// force panel to redraw
	}
}
