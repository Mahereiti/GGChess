import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

// represents an image rescaled, extends JLabel
public class ImageLabel extends JLabel {
	ImageLabel(String path, int w, int h) {
		ImageIcon icon = new ImageIcon(getClass().getResource(path));
		Image img = icon.getImage().getScaledInstance(w, h, ABORT);
		icon = new ImageIcon(img);
		this.setIcon(icon);
	}
}
