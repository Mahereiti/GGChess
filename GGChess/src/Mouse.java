
// Class to handle clicks
public class Mouse {
	private Game game;
	
	public Mouse(Game game) {
        this.game = game;
    }
	
	public void clickOnSquare(Square s) {
        game.handleSquareClicked(s);
    }
}

