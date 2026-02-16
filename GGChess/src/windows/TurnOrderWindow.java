package windows;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import data.Player;
import app.Game;

public class TurnOrderWindow extends BaseFrame {
	private String firstPlayer;

	public TurnOrderWindow(String firstPlayer) {
		super("Tour", 600, 200);
		this.firstPlayer = firstPlayer;
		
		this.setContent();
	}

	@Override
	public void setContent() {
		JLabel text = new JLabel("A "+firstPlayer +" de jouer !");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Sans-serif", Font.BOLD, 40));
		text.setAlignmentX(CENTER_ALIGNMENT);
		
		contentPanel.add(text);
		
		this.revalidate();
	    this.repaint();
	}
}
