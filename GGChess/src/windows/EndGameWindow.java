package windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Clickable;
import app.Game;
import data.Player;

public class EndGameWindow extends BaseFrame {
	private Game g;
	private Player actualPlayer, winner;

	public EndGameWindow(Game g, Player actualPlayer, Player winner) {
		super("Fin de partie", 670, 320);
		this.g = g;
		this.actualPlayer = actualPlayer;
		this.winner = winner;
		
		this.setContent();
	}

	@Override
	public void setContent() {
		JLabel text = new JLabel();
		if (winner==null) text.setText("Match null !");
		else if (actualPlayer==winner) {
			text.setText("Vous avez gagné !");
		} else text.setText("Vous avez perdu...");
		
		text.setForeground(Color.white);
		text.setFont(new Font("Sans-serif", Font.BOLD, 40));
		text.setAlignmentX(CENTER_ALIGNMENT);
		
		Clickable menuBtn = new Clickable("/galaxy/menu_b.png", 0, 0);
		Clickable replayBtn = new Clickable("/galaxy/replay_b.png", 0, 0);
		
		menuBtn.addActionListener(e-> {
			g.windowPrincipal.showMenu();
			this.dispose();		// close window
		});
		
		menuBtn.addActionListener(e-> {
			g.windowPrincipal.showMenu();
			this.dispose();		// close window
		});
		
		replayBtn.addActionListener(e-> {
			g.resetGame();
			g.playersPanel.gameTimer.restart();
			this.dispose();
		});
		
		JPanel btnsPanel = new JPanel();
        // Layout of btnsPanel with spaces
        btnsPanel.setLayout(new BoxLayout(btnsPanel, BoxLayout.X_AXIS));
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.add(menuBtn);
        btnsPanel.add(replayBtn);
        btnsPanel.add(Box.createHorizontalGlue());
        btnsPanel.setOpaque(false);		// Transparent
        
		contentPanel.add(text, BorderLayout.CENTER);
		contentPanel.add(btnsPanel, BorderLayout.SOUTH);
		
		this.revalidate();
	    this.repaint();
		
	}

}
