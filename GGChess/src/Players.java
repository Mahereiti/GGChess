import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Players extends JPanel {
	ImageIcon activePlayer;
	ImageIcon inactivePlayer;

    public Player whitePlayer;
    public Player blackPlayer;
    public Player currentPlayer;
    
    public Dimension d;
	
	public Players(Game g) {
		this.d = g.d;
        this.activePlayer = new ImageIcon(getClass().getResource("/galaxy/player_active.png"));
        this.inactivePlayer = new ImageIcon(getClass().getResource("/galaxy/player_active.png"));
        
		this.setPreferredSize(new Dimension(200, 3*d.height/4));

        blackPlayer = new Player("black");
        whitePlayer = new Player("white");
        currentPlayer = whitePlayer;
        
		JPanel player1Panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(59, 41, 153));
                g.fillRoundRect(0, 0, 200, d.height/4, 30, 30);
			}
		};
		player1Panel.setPreferredSize(new Dimension(200, d.height/4));
		

		Clickable player1 = new Clickable("/galaxy/player_inactive.png", 0, 0);
		player1.scaleH(d.height/6);

		JLabel label1 = new JLabel("Joueur 1");
		label1.setBorder(new EmptyBorder(30, 30, 30, 30));
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Sans-serif", Font.BOLD , 14));
		
		player1Panel.setLayout(new BorderLayout());
		player1Panel.add(player1, BorderLayout.NORTH);
		player1Panel.add(label1, BorderLayout.SOUTH);
		player1Panel.setOpaque(false);

		
		
		
		
		
		
		
		
		
		JPanel player2Panel = new JPanel(new BorderLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(3, 1, 24));
                g.fillRoundRect(0, 0, 200, d.height/4, 30, 30);
			}
		};
		
		player2Panel.setPreferredSize(new Dimension(200, d.height/4));
		player2Panel.setBackground(new Color(200, 0, 200));
		
		Clickable player2 = new Clickable("/galaxy/player_active.png", 0, 0);
		player2.scaleH(d.height/6);

		JLabel label2 = new JLabel("Joueur 2");
		label2.setBorder(new EmptyBorder(30, 30, 30, 30));
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Sans-serif", Font.BOLD , 14));
	
		player2Panel.setLayout(new BorderLayout());
		player2Panel.add(player2, BorderLayout.NORTH);
		player2Panel.add(label2, BorderLayout.SOUTH);
		player2Panel.setOpaque(false);

		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(player1Panel);
		this.add(Box.createVerticalStrut(d.height/4));
		this.add(player2Panel);
		
		this.setOpaque(false); 	// Transparent
	}
}
