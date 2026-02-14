package windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.*;

import app.Clickable;
import app.GGChess;

public class AskNames extends BaseFrame {

    private JTextField nameField;
    private JLabel textLabel;
    private JButton validateBtn;

    private String player1Name;
    private int step = 1; // 1 for Player 1 and 2 for Player 2
    private GGChess ggchess;
    
    public AskNames(GGChess ggchess) {
        super("Players Names", 600, 350);
        closeBtn.setVisible(false);
        this.ggchess = ggchess;
        setContent();
    }

    @Override
    public void setContent() {

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        textLabel = new JLabel("Veuillez entrer le nom du joueur 1");
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        textLabel.setAlignmentX(CENTER_ALIGNMENT);

        nameField = new JTextField(15);
        nameField.setMaximumSize(nameField.getPreferredSize());
        nameField.setFont(new Font("SansSerif", Font.BOLD, 24));
        nameField.setAlignmentX(CENTER_ALIGNMENT);
        
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

    private void onValidate() {
        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Please, enter a name","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (step == 1) {
            //for the player 1
            player1Name = name;
            //for the player 2
            step = 2;
            textLabel.setText("Veuillez entrer le nom du joueur 2");
            nameField.setText("");
            ggchess.getGamePanel().playersPanel.getCurrentPlayer().setName(name);
            ggchess.getGamePanel().playersPanel.updatePlayerName(true, name);

        } else {
            String player2Name = name;
            ggchess.getGamePanel().playersPanel.getCurrentPlayer().setName(name);
            ggchess.getGamePanel().playersPanel.updatePlayerName(false, name);
            //We close the window
            dispose();
            new TurnOrderWindow(ggchess.getGamePanel().playersPanel.getCurrentPlayerName());
        }
        
    }
}
