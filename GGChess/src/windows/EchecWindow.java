package windows;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class EchecWindow extends BaseFrame {

	public EchecWindow() {
		super("Tour", 600, 200);
		this.setContent();
	}

	@Override
	public void setContent() {
		JLabel text = new JLabel("Echec");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Sans-serif", Font.BOLD, 40));
		text.setAlignmentX(CENTER_ALIGNMENT);
		
		contentPanel.add(text);
		
		this.revalidate();
	    this.repaint();
	}

}
