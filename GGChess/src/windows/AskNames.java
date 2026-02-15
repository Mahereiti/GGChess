package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import javax.swing.*;

import app.Clickable;
import app.GGChess;

public class AskNames extends BaseFrame {

    private JTextField nameField;
    private JLabel textLabel;
    private JButton validateBtn;

    private int step = 1; // 1 for Player 1 and 2 for Player 2
    private GGChess ggchess;
    
    public AskNames(GGChess ggchess) {
        super("Players Names", 600, 350);
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
        this.ggchess = ggchess;
        this.setContent();
    }

    @Override
    public void setContent() {

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        textLabel = new JLabel("Joueur Noir");
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        textLabel.setAlignmentX(CENTER_ALIGNMENT);

        nameField = new JTextField(15);
        nameField.setMaximumSize(nameField.getPreferredSize());
        nameField.setFont(new Font("SansSerif", Font.BOLD, 24));
        nameField.setAlignmentX(CENTER_ALIGNMENT);
        nameField.setFocusable(true);
        nameField.requestFocusInWindow();	//autofocus
        nameField.addKeyListener(new KeyAdapter() {	// touch enter
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if (e.getKeyCode() == KeyEvent.VK_ENTER) onValidate();
        	}
        });
        
        Dimension fieldSize = new Dimension(400, 50); // largeur 400px, hauteur 50px
        nameField.setPreferredSize(fieldSize);
        nameField.setMaximumSize(fieldSize);

        validateBtn = new Clickable("/galaxy/validate.png", 0, 0);
        validateBtn.setAlignmentX(CENTER_ALIGNMENT);
        validateBtn.addActionListener(e -> onValidate());

        contentPanel.add(textLabel);
        contentPanel.add(nameField);
        contentPanel.add(validateBtn);
    }

    public void onValidate() {
        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Please, enter a name","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (step == 1) {
            //for the player 2
            step = 2;
            textLabel.setText("Joueur Blanc");
            nameField.setText("");
            ggchess.getGamePanel().playersPanel.getCurrentPlayer().setName(name);
            ggchess.getGamePanel().playersPanel.updatePlayerName(true, name);

        } else {
            ggchess.getGamePanel().playersPanel.getCurrentPlayer().setName(name);
            ggchess.getGamePanel().playersPanel.updatePlayerName(false, name);
            //We close the window
            dispose();
            new TurnOrderWindow(ggchess.getGamePanel().playersPanel.getCurrentPlayerName());
        }
    }
}
