package windows;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import app.Clickable;
import app.Game;
import data.Player;

public class EndGameWindow extends BaseFrame {
	private Game g;
	private Player actualPlayer, winner;

	public EndGameWindow(Game g, Player actualPlayer, Player winner) {
		super("Fin de partie", 600, 500);
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
		
		Clickable menuBtn = new Clickable("/galaxy/menu.png", 0, 0);
		Clickable restartBtn = new Clickable("/galaxy/menu.png", 0, 0);
		
		menuBtn.addActionListener(e-> {
			g.windowPrincipal.showMenu();
			this.dispose();		// close window
		});
		
		menuBtn.addActionListener(e-> {
			g.windowPrincipal.showMenu();
			this.dispose();		// close window
		});
		
		restartBtn.addActionListener(e-> {
			g.resetGame();
			this.dispose();
		});
		
	}

}
