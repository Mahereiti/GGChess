import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Main class which links every parts of the app
public class GGChess extends JFrame {
	Image bg; 		// background image
	
	GGChess() {
		this.setTitle("GGChess");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setUndecorated(true); 	// No borders
		
		// Draw over a transparent JPanel
        this.setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image bg = new ImageIcon(getClass().getResource("/galaxy/bg.png")).getImage();
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        });
		
		Game game = new Game();
        Chessboard chessboard = new Chessboard(game);
		JPanel activePlayers = new JPanel();
		
		// Add panels on frame
		this.add(activePlayers);
		this.add(chessboard);
	}

	
	public static void main(String[] args) {
		GGChess ggc = new GGChess();
		ggc.setVisible(true);
	}
}
