package app;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Player;

// Player panels
public class PlayersPanel extends JPanel {
	private ImageIcon activePlayer, inactivePlayer;
	private Clickable imgPlayerB, imgPlayerW;
	public Player whitePlayer, blackPlayer, currentPlayer;
    public Dimension d;
    
    private Color blackPlayerColorPanel, whitePlayerColorPanel;
    public JPanel blackPlayerPanel, whitePlayerPanel;
    
    private JLabel blackPlayerLabel;
    private JLabel whitePlayerLabel;
	
	public PlayersPanel(Game g) {
		this.d = g.d;
		
		// init players
		this.initPlayers();
        
		// init players panels
        this.createPlayersPanel();
		this.configurePlayerPanel(blackPlayerPanel, blackPlayer.getName(), imgPlayerB, true);
		this.configurePlayerPanel(whitePlayerPanel, whitePlayer.getName(), imgPlayerW, false);
		
		// Layout vertical
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createGlue());			// create flexible space to center align panels
		this.add(blackPlayerPanel);
		this.add(whitePlayerPanel);
		
		this.setPreferredSize(new Dimension((d.width-(d.height-200))/2, d.height-200));
		this.setOpaque(false); 	// Transparent
	}
	
	public void initPlayers() {
		// load icons active/inactive status
        activePlayer = new ImageIcon(getClass().getResource("/galaxy/player_active.png"));
        inactivePlayer = new ImageIcon(getClass().getResource("/galaxy/player_inactive.png"));
        
        // clickable img for players
		imgPlayerB = new Clickable("/galaxy/player_inactive.png", 0, 0);
		imgPlayerW = new Clickable("/galaxy/player_active.png", 0, 0);

        // init players
        blackPlayer = new Player("black", "Joueur 1");
        whitePlayer = new Player("white", "Joueur 2");
        currentPlayer = whitePlayer; 		// white first
	}
	
	public void createPlayersPanel() {
		whitePlayerColorPanel = new Color(3, 1, 24);	// active color
        blackPlayerColorPanel = new Color(59, 41, 153);	// inactive color
        
		// Panel for black player
		blackPlayerPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(blackPlayerColorPanel);
                g.fillRoundRect(this.getWidth()/2-100, 0, 200, d.height/4, 30, 30);
			}
		};
		
		// Panel for white player
		whitePlayerPanel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(whitePlayerColorPanel);
                g.fillRoundRect(this.getWidth()/2-100, 0, 200, d.height/4, 30, 30);
			}
		};
	}
	
	public void configurePlayerPanel(JPanel panel, String name, Clickable imgPlayer, boolean isBlack) {
		panel.setPreferredSize(new Dimension(200, d.height/4));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		
		// label for name
		JLabel namePlayer = new JLabel(name);
		namePlayer.setForeground(Color.white);
		namePlayer.setFont(new Font("Sans-serif", Font.BOLD , 14));
		
		if (isBlack) blackPlayerLabel = namePlayer;
	    else whitePlayerLabel = namePlayer;
		
		// center align
		panel.setAlignmentX(CENTER_ALIGNMENT);
		imgPlayer.setAlignmentX(CENTER_ALIGNMENT);
		namePlayer.setAlignmentX(CENTER_ALIGNMENT);
		
		panel.add(imgPlayer);
		panel.add(namePlayer);
		panel.add(Box.createGlue()); //space
	}
	
	public void updatePlayerName(boolean isBlack, String newName) {
        if (isBlack) {
            blackPlayerLabel.setText(newName);
            blackPlayerPanel.revalidate();
            blackPlayerPanel.repaint();
        } else {
            whitePlayerLabel.setText(newName);
            whitePlayerPanel.revalidate();
            whitePlayerPanel.repaint();
        }
    }
	
	public void switchPlayer() {
		// switch active/inactive player and their icons
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
		
		// change color panels
		Color tempC = blackPlayerColorPanel;
		blackPlayerColorPanel = whitePlayerColorPanel;
		whitePlayerColorPanel = tempC;
		blackPlayerPanel.repaint();
		whitePlayerPanel.repaint();
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public String getCurrentPlayerName() {
		return currentPlayer.getName();
	}
	
	public String getNonCurrentPlayerName() {
		if(currentPlayer == whitePlayer) {
			return blackPlayer.getName();
		} else return whitePlayer.getName();
	}
	
	public String getCurrentPlayerColor() {
		if(currentPlayer == whitePlayer) {
			return whitePlayer.getColor();
		}
		else {return blackPlayer.getColor();}
	}

	public JPanel getBlackPlayerPanel() {
		return blackPlayerPanel;
	}
	
	public JPanel getWhitePlayerPanel() {
		return whitePlayerPanel;
	}
	
	public void reset() {
		if (currentPlayer == blackPlayer) switchPlayer();	// white starts
	}
}
