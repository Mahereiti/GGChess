import javax.swing.*;

public abstract class Cliquable extends JButton { 
	
	public Cliquable(String path, int x, int y, int w, int h) {
		setIcon(new ImageIcon(getClass().getResource(path)));
		setBounds(x, y, w, h);
		
		setContentAreaFilled(false); 	// Delete bg
		setBorderPainted(false); 		// Delete border
		setFocusPainted(false); 		// Delete focus when clic
		addMouseListener(new Souris(this));
	}
	
	public abstract void clic();
}
