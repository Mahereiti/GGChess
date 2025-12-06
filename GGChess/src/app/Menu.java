package app;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import windows.RulesWindow;

public class Menu extends JPanel {
	Menu(GGChess window) {		
		Dimension d = window.d;
		
		// Create Clickable with images
		Clickable logo = new Clickable("/menu/logo.png", 0, 0);
		Clickable playBtn  = new Clickable("/menu/play_w.png", 100, 100);
		Clickable rulesBtn = new Clickable("/menu/rules.png", 100, 300);
		Clickable scoresBtn = new Clickable("/menu/scores.png", 100, 500);
		
		Clickable quitBtn = new Clickable("/menu/quit.png", 0, 0);
		Clickable themeBtn = new Clickable("/menu/theme_dark.png", 0, 0);
		
		// Scale clickable to fit screen size
		playBtn.scaleH(d.height/7);
		rulesBtn.scaleH(d.height/7);
		scoresBtn.scaleH(d.height/7);
		logo.scaleW(playBtn.w);
		quitBtn.scaleH(d.height/12);
		themeBtn.scaleH(d.height/12);
		
		// Add actions to btn
		playBtn.addActionListener(e-> window.showGame());
		rulesBtn.addActionListener(e-> new RulesWindow());
		quitBtn.addActionListener(e-> window.dispose());
		
		
		// SouthPanel to put quit/theme btn
		JPanel southPanel = new JPanel(new BorderLayout());
		southPanel.add(quitBtn, BorderLayout.LINE_START);
		southPanel.add(themeBtn, BorderLayout.LINE_END);
		southPanel.setOpaque(false);
		
		// Center align all clickable
		logo.setAlignmentX(CENTER_ALIGNMENT);
		playBtn.setAlignmentX(CENTER_ALIGNMENT);
		rulesBtn.setAlignmentX(CENTER_ALIGNMENT);
		scoresBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		this.setOpaque(false); 	// Transparent
		this.setPreferredSize(d);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 	// Vertical Layout
		
		// add components
		this.add(logo);
		this.add(playBtn);
		this.add(rulesBtn);
		this.add(scoresBtn);
		this.add(southPanel);
	}
}
