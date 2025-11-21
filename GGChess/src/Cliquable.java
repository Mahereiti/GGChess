import javax.swing.*;

public class Cliquable extends JButton { 
	int x, y, w, h;
	
	public Cliquable(int x, int y, int w, int h) {		
		setContentAreaFilled(false); 	// Delete bg
		setBorderPainted(false); 		// Delete border
		setFocusPainted(false); 		// Delete focus when clic
		setOpaque(false); 				// Make it transparent
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public Cliquable(String path, int x, int y, int w, int h) {
		this(x, y, w, h);
		setIcon(new ImageIcon(getClass().getResource(path)));
	}
}
