import java.awt.Image;
import javax.swing.*;

public class Clickable extends JButton { 
	int x, y, w, h;
	
	// Constructor with position only
	public Clickable(int x, int y) {
		setContentAreaFilled(false); 	// Remove default bg
		setBorderPainted(false); 		// Remove border
		setFocusPainted(false); 		// Disable focus when click
		setOpaque(false); 				// Make it transparent
		this.x = x;
		this.y = y;
	}
	
	// Constructor with position and size
	public Clickable(int x, int y, int w, int h) {		
		this(x, y);
		this.w = w;
		this.h = h;
		setBounds(x, y, w, h);
	}
	
	// Constructor with image path and position
	public Clickable(String path, int x, int y) {
		this(x, y);
	 	ImageIcon icone = new ImageIcon(getClass().getResource(path)); 		// Récupère l’icône actuelle du bouton
	 	this.w = icone.getIconWidth();		// store width
	 	this.h = icone.getIconHeight();		// store height
	 	this.setIcon(icone);
	}
	
	// scale btn proportionally based on new height
	public void scaleH(int newH) {
	 	int newW = w*newH/h; 	// calculate new width to keep ratio image
	 	
	 	// Resize image
	 	Image image = ((ImageIcon) this.getIcon()).getImage().getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	 	((ImageIcon) this.getIcon()).setImage(image); 	// update icon
	 	this.w = newW;		// update new width
	 	this.h = newH;		// update new height
	}
	
	// scale btn proportionally based on new Width
	public void scaleW(int newW) {
	 	int newH = h*newW/w;	// calculate new height to keep ratio image
	 	
	 	// Resize image
	 	Image image = ((ImageIcon) this.getIcon()).getImage().getScaledInstance(newW, newH, Image.SCALE_SMOOTH); // Redimensionne l’image
	 	((ImageIcon) this.getIcon()).setImage(image);	// update icon
	 	this.w = newW;		// update new width
	 	this.h = newH;		// update new height
	}
}
