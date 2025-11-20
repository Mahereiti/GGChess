import java.awt.Dimension;

import javax.swing.*;

public abstract class Cliquable extends JButton { 
	public Cliquable(int x, int y, int w, int h) {		
		setContentAreaFilled(false); 	// Delete bg
		setBorderPainted(false); 		// Delete border
		setFocusPainted(false); 		// Delete focus when clic
		setOpaque(false); 				// Make it transparent
	}
	
	public Cliquable(String path, int x, int y, int w, int h) {
		setIcon(new ImageIcon(getClass().getResource(path)));
		setContentAreaFilled(false); 	// Delete bg
		setBorderPainted(false); 		// Delete border
		setFocusPainted(false); 		// Delete focus when clic
	}
}
