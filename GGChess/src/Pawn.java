import java.util.ArrayList;

public class Pawn extends Piece {
	public Pawn(String color) {
		super(color, "/"+color+"_pieces/pawn.png");
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int x = square.getX()/100;
		int y = square.getY()/100;
	    if (this.color.equals("white")) {

	        //for the case when we can move for 2 or 3 squares
	    	if (x == 1) {
	            if (!board[x+1][y].isOccupied()) {
	                ValidMoves.add(board[x+1][y]);
	                //we can go to x+2 only if X+1 is not occupied
	                if (!board[x+2][y].isOccupied()) { 
	                    ValidMoves.add(board[x+2][y]);
	                }
	            }
	        } 
	        else if (x < 7) { //if the pawn can move juste from one square
	            if (!board[x+1][y].isOccupied()) {
	                ValidMoves.add(board[x+1][y]);
	            }

	            //case of kills
	            if (y<7 && board[x+1][y+1].isOccupied() && !board[x+1][y+1].getPiece().getColor().equals(this.color)) {
	                ValidMoves.add(board[x+1][y+1]);
	            }
	            if (y>0 && board[x+1][y-1].isOccupied() && !board[x+1][y-1].getPiece().getColor().equals(this.color)) {
	                ValidMoves.add(board[x+1][y-1]);
	            }
	        }
	    }

	    //for black pawns
	    if (this.color.equals("black")) {
	        if (x == 6) {
	            if (!board[x-1][y].isOccupied()) {
	                ValidMoves.add(board[x-1][y]);

	                if (!board[x-2][y].isOccupied()) {
	                    ValidMoves.add(board[x-2][y]);
	                }
	            }
	        } 
	        else if (x>0) {
	            if (!board[x-1][y].isOccupied()) {
	                ValidMoves.add(board[x-1][y]);
	            }

	            if (y<7 && board[x-1][y+1].isOccupied() && !board[x-1][y+1].getPiece().getColor().equals(this.color)) {
	                ValidMoves.add(board[x-1][y+1]);
	            }
	            if (y>0 && board[x-1][y-1].isOccupied() && !board[x-1][y-1].getPiece().getColor().equals(this.color)) {
	                ValidMoves.add(board[x-1][y-1]);
	            }
	        }
	    }

	    return ValidMoves;
		}
}