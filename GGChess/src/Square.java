import javax.swing.JButton;

public class Square {
    public int x, y;
    public JButton button;
    public String containedPiece;
    
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setButton(JButton b) {
        this.button = b;
    }

    public JButton getButton() {
        return button;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
    
