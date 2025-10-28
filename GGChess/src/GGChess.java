import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GGChess extends JFrame {
	
	GGChess() {
		this.setTitle("GGChess");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		Game game = new Game();                 
        Chessboard chessboard = new Chessboard(game);
        
		JPanel activePlayers = new JPanel();
		
		this.add(activePlayers, BorderLayout.WEST);
		this.add(chessboard, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		GGChess ggc = new GGChess();
		

	}

}
