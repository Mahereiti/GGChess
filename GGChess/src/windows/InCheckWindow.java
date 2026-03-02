package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.Timer;

public class InCheckWindow extends BaseFrame {

	public InCheckWindow() {
		super("Echec", 600, 140);
		// replace closeBtn by emptyIcon (title still centered)
        Icon original = closeBtn.getIcon();
        if (original != null) {
            Icon emptyIcon = new Icon() {
                @Override
                public int getIconWidth() {
                    return original.getIconWidth();
                }

                @Override
                public int getIconHeight() {
                    return original.getIconHeight();
                }

                @Override
                public void paintIcon(java.awt.Component c, java.awt.Graphics g, int x, int y) {
                }
            };
            closeBtn.setIcon(emptyIcon); // même taille, mais invisible
            closeBtn.setEnabled(false);
        }
		this.setContent();
	}

	@Override
	public void setContent() {
		Timer timer = new Timer(1000, null);
		timer.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
		});
	    timer.start();
	    
		contentPanel.setVisible(false);
	}
}
