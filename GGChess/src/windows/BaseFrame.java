package windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.Clickable;

public abstract class BaseFrame extends JFrame {
	protected JPanel contentPanel;
	protected Clickable closeBtn;
	public BaseFrame(String title, int w, int h) {
		//______________________ WINDOW _______________________________
		this.setSize(w, h);
		this.setLocationRelativeTo(null); 	// Center on screen
		this.setUndecorated(true); 			// Remove borders
		this.setAlwaysOnTop(true); 			// Force player to close window
		this.setShape(new RoundRectangle2D.Double(0,0,w,h,30,30)); // round borders
		
		// Background panel (one color) with rounded borders
        this.setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(28, 24, 134));
                g.fillRoundRect(0, 0, w, h, 30, 30);
            }
        });
        
        
		//_____________ TOP PANEL (close btn + title) __________________
		JPanel topPanel = new JPanel();
		topPanel.setOpaque(false); 		// Transparent
		
		JLabel titleLabel = new JLabel("<html><h1 style='color:white; text-align:center; font-size:50px;'>"+title+"</h1></html>");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// add Bouton to close the window
		closeBtn = new Clickable("/galaxy/close.png", 0, 0);
		closeBtn.addActionListener(e->this.dispose());
		
		// add to topPanel : close btn + title + fixed space
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS)); // Horizontal Layout
		topPanel.add(closeBtn);
		topPanel.add(titleLabel);
		topPanel.add(Box.createRigidArea(closeBtn.getPreferredSize()));

		
		//____________________ CONTENT PANEL ___________________________
		// contentPanel with rounded borders
		contentPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(21, 18, 100));
                g.fillRoundRect(0, 0, w-50, h-125, 30, 30);
			}
		};
		contentPanel.setOpaque(false); 	// Transparent
		
		
		//________________ LAYOUT (with fixed spaces) __________________
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(contentPanel, BorderLayout.CENTER);
		this.add(Box.createRigidArea(new Dimension(25, 0)), BorderLayout.EAST);
		this.add(Box.createRigidArea(new Dimension(25, 0)), BorderLayout.WEST);
		this.add(Box.createRigidArea(new Dimension(0, 15)), BorderLayout.SOUTH);
		
		this.setVisible(true); 	// Show frame
	}
	
	public abstract void setContent();
}
