import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

// Class which represents the chess game, extends JPanel
public class Game extends JPanel {
	Game(GGChess window) {
		Cliquable menuBtn  = new Cliquable("/galaxy/menu_b.png", 100, 100, 100, 100);

		menuBtn.addActionListener(e-> window.showMenu());
		this.add(menuBtn);
		
		menuBtn.setBounds(100, 100, 100, 100);
		Chessboard chessboard = new Chessboard(this);
		JPanel activePlayers = new JPanel();
		this.add(activePlayers);
		this.add(chessboard);
		
		this.setOpaque(false);
		
	}
	
	public void Game() {
		Player player1 = new Player("white");
		Player player2 = new Player("black");
		Square initSquare;
		Square finalSquare;
		Player CurrentPlayer = player1; 
		if(initSquare.getPiece()!=null) {
			if(initSquare.getPiece().getColor().equals(CurrentPlayer.getColor())){
				initSquare.getPiece().move(initSquare, finalSquare);
			}
			
		}
	}
}
