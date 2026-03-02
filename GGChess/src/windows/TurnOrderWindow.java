package windows;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import data.Player;
import app.GGChess;
import app.Game;


public class TurnOrderWindow extends BaseFrame {
	private String firstPlayer;
	private GGChess ggchess;

	public TurnOrderWindow(GGChess ggchess) {
		super("Tour", 600, 200);
		this.ggchess = ggchess;
		this.firstPlayer = ggchess.getGamePanel().playersPanel.getCurrentPlayerName();
		
		this.setContent();
	}

	@Override
	public void setContent() {
		JLabel text = new JLabel("A "+firstPlayer +" de jouer !");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Sans-serif", Font.BOLD, 40));
		text.setAlignmentX(CENTER_ALIGNMENT);
		
		contentPanel.add(text);
		closeBtn.addActionListener(e -> {
		    ggchess.getGamePanel().playersPanel.startTimer();
		});
		this.revalidate();
	    this.repaint();
	}
}
