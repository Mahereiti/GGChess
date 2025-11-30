import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Menu extends JPanel {
	Menu(GGChess window) {		
		Dimension d = window.d;
		
		// Create Clickable with images
		Clickable logo = new Clickable("/menu/logo.png", 0, 0);
		Clickable playBtn  = new Clickable("/menu/play_w.png", 100, 100);
		Clickable rulesBtn = new Clickable("/menu/rules.png", 100, 300);
		Clickable scoresBtn = new Clickable("/menu/scores.png", 100, 500);
		
		// Scale clickable to fit screen size
		playBtn.scaleH(d.height/7);
		rulesBtn.scaleH(d.height/7);
		scoresBtn.scaleH(d.height/7);
		logo.scaleW(playBtn.w);

		// Add actions to btn
		playBtn.addActionListener(e-> window.showGame());
		rulesBtn.addActionListener(e-> this.showRules());
		
		this.setOpaque(false); 	// Transparent background
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); 	// Vertical Layout
		
		// Center align all clickable
		logo.setAlignmentX(CENTER_ALIGNMENT);
		playBtn.setAlignmentX(CENTER_ALIGNMENT);
		rulesBtn.setAlignmentX(CENTER_ALIGNMENT);
		scoresBtn.setAlignmentX(CENTER_ALIGNMENT);
		
		// add components with flexible vertical space
		this.add(Box.createVerticalGlue());
		this.add(logo);
		this.add(playBtn);
		this.add(rulesBtn);
		this.add(scoresBtn);
		this.add(Box.createVerticalGlue());
	}

	public void showRules() {
		// create new window
		JFrame rulesFrame = new JFrame() ;
		rulesFrame.setSize(800, 600);
		rulesFrame.setLocationRelativeTo(null); 	// Center on screen
		rulesFrame.setUndecorated(true); 			// Remove borders
		rulesFrame.setAlwaysOnTop(true); 			// Force player to close window
		rulesFrame.setShape(new RoundRectangle2D.Double(0,0,800,600,30,30)); // round borders
		
		// Background panel (one color) with rounded borders
        rulesFrame.setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(28, 24, 134));
                g.fillRoundRect(0, 0, 800, 600, 30, 30);
            }
        });
        // Top Panel (close btn + title)
		JPanel topPanel = new JPanel();
		topPanel.setOpaque(false); 		// Transparent
		
        // Panel which will contains rules with rounded borders
		JPanel rulesPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(21, 18, 100));
                g.fillRoundRect(0, 0, 750, 475, 30, 30);
			}
		};
		rulesPanel.setOpaque(false); 	// Transparent
		
		JLabel titleLabel = new JLabel("<html><h1 style='color:white; text-align:center; font-size:30px;'>Règles du jeu</h1></html>");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// Load html rules from a file
		String rules="";
		try (BufferedReader reader = new BufferedReader(new FileReader("texts/rules_html"))) {
			rules = reader.lines().collect(Collectors.joining("\n"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TextPane which contains the rules (html)
		JTextPane rulesTextPane = new JTextPane();
		rulesTextPane.setContentType("text/html"); 	// to interpret content as html and not text
		rulesTextPane.setEditable(false);	// Not editable (read only)
		rulesTextPane.setText(rules);		// Load html String
		rulesTextPane.setOpaque(false);		// Transparent
		rulesTextPane.setCaretPosition(0);	// Force scroll to top
		
		// ScrollPane to be able to "scroll"
		JScrollPane scrollPane = new JScrollPane(rulesTextPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setOpaque(false); 		// Transparent
		scrollPane.getViewport().setOpaque(false); // Area that shows textPane transparent 
		scrollPane.setBorder(null);			// No borders
		scrollPane.getVerticalScrollBar().setUnitIncrement(5); // set scroll speed (unit increment)

		// Layout for rulesPanel
		rulesPanel.setLayout(new BorderLayout());
		rulesPanel.add(scrollPane);
		
		// add Bouton to close the window
		Clickable closeBtn = new Clickable("/galaxy/close.png", 0, 0);
		closeBtn.addActionListener(e->rulesFrame.dispose());
		
		// add to topPanel : close btn + title + fixed space
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS)); // Horizontal Layout
		topPanel.add(closeBtn);
		topPanel.add(titleLabel);
		topPanel.add(Box.createRigidArea(closeBtn.getPreferredSize()));

		// Layout for frame (with fixed spaces)
		rulesFrame.setLayout(new BorderLayout());
		rulesFrame.add(topPanel, BorderLayout.NORTH);
		rulesFrame.add(rulesPanel, BorderLayout.CENTER);
		rulesFrame.add(Box.createRigidArea(new Dimension(25, 0)), BorderLayout.EAST);
		rulesFrame.add(Box.createRigidArea(new Dimension(25, 0)), BorderLayout.WEST);
		rulesFrame.add(Box.createRigidArea(new Dimension(0, 15)), BorderLayout.SOUTH);
		
		rulesFrame.setVisible(true); 	// Show frame
	}
}
