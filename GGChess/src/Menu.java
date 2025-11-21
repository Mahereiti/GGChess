import java.awt.Dimension;
import javax.swing.JPanel;

public class Menu extends JPanel {
	Menu(GGChess window) {
		this.setPreferredSize(new Dimension(1000, 900));
		
		ImageLabel logo = new ImageLabel("/menu/logo.png", 700, 300);
		
		// New buttons		
		Cliquable playBtn  = new Cliquable("/menu/play_w.png", 100, 100, 900, 150);
		Cliquable rulesBtn = new Cliquable("/menu/rules.png", 100, 300, 900, 150);
		Cliquable scoresBtn = new Cliquable("/menu/scores.png", 100, 500, 900, 150);
		
		playBtn.addActionListener(e-> window.showGame());
		
		this.setOpaque(false);
		
		this.add(logo);
		this.add(playBtn);
		this.add(rulesBtn);
		this.add(scoresBtn);
	}
}
