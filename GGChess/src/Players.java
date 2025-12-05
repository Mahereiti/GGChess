import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Player panels
public class Players extends JPanel {
	ImageIcon activePlayer;
	ImageIcon inactivePlayer;

    public Player whitePlayer;
    public Player blackPlayer;
    public Player currentPlayer;
    
    public Clickable imgPlayerB, imgPlayerW;
    
    public Dimension d;
	
	public Players(Game g) {
		this.d = g.d;
		
		// load icons active/inactive status
        this.activePlayer = new ImageIcon(getClass().getResource("/galaxy/player_active.png"));
        this.inactivePlayer = new ImageIcon(getClass().getResource("/galaxy/player_inactive.png"));
        
        // clickable img for players
		imgPlayerB = new Clickable("/galaxy/player_active.png", 0, 0);
		imgPlayerW = new Clickable("/galaxy/player_inactive.png", 0, 0);

        // init players
        blackPlayer = new Player("black");
        whitePlayer = new Player("white");
        currentPlayer = whitePlayer; 		// white first
        
        // Panel for white killed pieces
		JPanel blackKillsPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(59, 41, 153));
                g.fillRoundRect(this.getWidth()/2-100, 0, 200, d.height/4, 30, 30);
			}
		};
		
		// Panel for black killed pieces
		JPanel whiteKillsPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(new Color(3, 1, 24));
                g.fillRoundRect(this.getWidth()/2-100, 0, 200, d.height/4, 30, 30);
			}
		};
		
		// init players panels with name and icons
		this.initPlayerPanel(blackKillsPanel, "Joueur 1", imgPlayerB);
		this.initPlayerPanel(whiteKillsPanel, "Joueur 2", imgPlayerW);
		
		// Layout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(blackKillsPanel);
		this.add(whiteKillsPanel);
		
		this.setPreferredSize(new Dimension((d.width-(d.height-200))/2, d.height-200));
		this.setOpaque(false); 	// Transparent
	}
	
	public void initPlayerPanel(JPanel panel, String name, Clickable imgPlayer) {
		panel.setPreferredSize(new Dimension(200, d.height/4));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		
		// scale player img to fit panel
		imgPlayer.scaleH(d.height/6);
		
		// label for name
		JLabel namePlayer = new JLabel(name);
		namePlayer.setForeground(Color.white);
		namePlayer.setFont(new Font("Sans-serif", Font.BOLD , 14));
		
		// center align
		panel.setAlignmentX(CENTER_ALIGNMENT);
		imgPlayer.setAlignmentX(CENTER_ALIGNMENT);
		namePlayer.setAlignmentX(CENTER_ALIGNMENT);
		
		panel.add(imgPlayer);
		panel.add(namePlayer);
		panel.add(Box.createGlue()); //space
	}
	
	public void switchPlayer() {
		// switch active/inactive player and image
		if (currentPlayer == whitePlayer) {
			currentPlayer = blackPlayer;
			imgPlayerB.setIcon(activePlayer);
			imgPlayerW.setIcon(inactivePlayer);
		}
        else {
        	currentPlayer = whitePlayer;
			imgPlayerB.setIcon(inactivePlayer);
			imgPlayerW.setIcon(activePlayer);
        }
	}
}
