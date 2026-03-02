package windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import app.Clickable;
import app.Game;
import data.Player;

public class GiveUp extends BaseFrame {
	private Game g;
	private Player actualPlayer, winner;

	public GiveUp(Game g, Player actualPlayer, Player winner) {
		super("Aller au menu ?", 700, 400);
		this.g = g;
		this.actualPlayer = actualPlayer;
		this.winner = winner;
		
		this.setContent();
	}

	@Override
	public void setContent() {
		JTextArea text = new JTextArea();
		text.setText("Si vous retournez au menu, cette partie sera considérée comme perdue...");
		text.setForeground(Color.white);
		text.setFont(new Font("Sans-serif", Font.BOLD, 30));
		text.setOpaque(false);
		text.setEditable(false);
		text.setLineWrap(true);
		
		Clickable yesBtn = new Clickable("/galaxy/validate.png", 0, 0);
		Clickable noBtn = new Clickable("/galaxy/refuse.png", 0, 0);
		
		yesBtn.addActionListener(e-> {
			g.isPlaying = false;
			g.windowPrincipal.showMenu();
			
			this.dispose();		// close window
		});
		
		noBtn.addActionListener(e-> {
			this.dispose();
		});
		
		JPanel btnsPanel = new JPanel();
        // Layout of btnsPanel with spaces
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.add(yesBtn);
        btnsPanel.add(noBtn);
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.setOpaque(false);		// Transparent
        
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(text, BorderLayout.CENTER);
		contentPanel.add(Box.createRigidArea(new Dimension(25, 0)), BorderLayout.EAST);
		contentPanel.add(Box.createRigidArea(new Dimension(25, 0)), BorderLayout.WEST);
		contentPanel.add(btnsPanel, BorderLayout.SOUTH);
		
		this.revalidate();
	    this.repaint();	
	}
}
