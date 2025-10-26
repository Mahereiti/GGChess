import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Chessboard extends JPanel {
	Chessboard() {
		this.setSize(800, 800);
		
		this.setBackground(Color.GRAY);
		JButton b = new JButton("clic");
		this.add(b);
	}
}
