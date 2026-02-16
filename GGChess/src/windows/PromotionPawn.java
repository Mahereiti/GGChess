package windows;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

import app.Clickable;
import app.Game;
import board.Queen;
import board.Rook;
import board.Square;
import board.Bishop;
import board.Knight;

public class PromotionPawn extends BaseFrame {
    private Game gamePanel;
    private Square pawnSquare;
    String color;
    
    public PromotionPawn(Game gamePanel, Square pawnSquare, String color) {
        super("Promotion", 800, 620);
        // replace closeBtn by emptyIcon (title still centered)
        Icon original = closeBtn.getIcon();
        if (original != null) {
            Icon emptyIcon = new Icon() {
                @Override
                public int getIconWidth() {
                    return original.getIconWidth();
                }

                @Override
                public int getIconHeight() {
                    return original.getIconHeight();
                }

                @Override
                public void paintIcon(java.awt.Component c, java.awt.Graphics g, int x, int y) {
                }
            };
            closeBtn.setIcon(emptyIcon); // même taille, mais invisible
            closeBtn.setEnabled(false);
        }
        this.gamePanel = gamePanel;
        this.pawnSquare = pawnSquare;
        this.color = color;
        this.setContent();
    }

    @Override
    public void setContent() {

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JLabel textLabel = new JLabel("Remplacer le pion par :");
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("SansSerif", Font.BOLD, 36));
        textLabel.setAlignmentX(CENTER_ALIGNMENT);
        
        Clickable queenBtn = new Clickable("/promotion_string/stringQueen.png", 0, 0);
        Clickable knightBtn = new Clickable("/promotion_string/stringKnight.png", 0, 0);
        Clickable rookBtn = new Clickable("/promotion_string/stringRook.png", 0, 0);
        Clickable bishopBtn = new Clickable("/promotion_string/stringBishop.png", 0, 0);
        
        // Select piece
        queenBtn.addActionListener(e->{
        	pawnSquare.setPiece(new Queen(color, (gamePanel.d.height-200)/8));
        	dispose();
        });
        bishopBtn.addActionListener(e->{
        	pawnSquare.setPiece(new Bishop(color, (gamePanel.d.height-200)/8));
        	dispose();
        });
        rookBtn.addActionListener(e->{
        	pawnSquare.setPiece(new Rook(color, (gamePanel.d.height-200)/8));
        	dispose();
        });
        knightBtn.addActionListener(e->{
        	pawnSquare.setPiece(new Knight(color, (gamePanel.d.height-200)/8));
        	dispose();
        });

        queenBtn.setAlignmentX(CENTER_ALIGNMENT);
        bishopBtn.setAlignmentX(CENTER_ALIGNMENT);
        rookBtn.setAlignmentX(CENTER_ALIGNMENT);
        knightBtn.setAlignmentX(CENTER_ALIGNMENT);

        contentPanel.add(textLabel);
        contentPanel.add(queenBtn);
        contentPanel.add(bishopBtn);
        contentPanel.add(rookBtn);
        contentPanel.add(knightBtn);
        
        this.revalidate();
	    this.repaint();
    }
}
