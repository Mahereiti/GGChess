import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Chessboard extends JPanel {

    Square[][] chessboard = new Square[8][8];
    JButton[][] btns = new JButton[8][8];
    Game game;
    
    Chessboard(Game game) {
    	this.game = game;
        this.setSize(800, 800);
        this.setBackground(Color.GRAY);
        this.setLayout(new GridLayout(8, 8)); 
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                btns[i][j] = new JButton();
               	if ((i + j) % 2 == 0)
                    btns[i][j].setBackground(Color.WHITE);
                else
                    btns[i][j].setBackground(Color.DARK_GRAY);
               	final int x = i;
                final int y = j;
                btns[i][j].addActionListener(e -> {      //We add a listener for each button
                    game.caseClicked(x, y);
                });

                this.add(btns[i][j]);
            }
        }
    }
}