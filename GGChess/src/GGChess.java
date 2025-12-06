import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Main class which links every parts of the app
public class GGChess extends JFrame {
	Image bg; 		// background image
	CardLayout cardLayout;
	JPanel mainPanel;
	Game gamePanel;
	Dimension d;
	
	GGChess() {
		d = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("GGChess");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true); 	// No borders
		
		// Draw over a transparent JPanel
        this.setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image bg = new ImageIcon(getClass().getResource("/galaxy/bg.png")).getImage();
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        });
		
        // CardLayout and panels
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        Menu menuPanel = new Menu(this);
		gamePanel = new Game(this);
		
		// Add differents panels (windows) to the mainPanel
		mainPanel.add(gamePanel, "game");
		mainPanel.add(menuPanel, "menu");
		
		this.add(mainPanel);
		mainPanel.setOpaque(false);
        
		showMenu();		
	}
	
	public void showMenu() {
		cardLayout.show(this.mainPanel, "menu");
	}
	
	public void showGame() {
		cardLayout.show(this.mainPanel, "game");
		new TurnOrderWindow(gamePanel.playersPanel.getCurrentPlayerName());
	}
	
	public static void main(String[] args) {
		GGChess ggc = new GGChess();
		ggc.setVisible(true);
	}
}
