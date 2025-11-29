import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(String color) {
		super(color, "/"+color+"_pieces/bishop.png");
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int x = square.getX();
		int y = square.getY();
		//top right
		int i;
		i=1;
		while((y+i)<8 && (x+i)<8) {
			if(!board[x+i][y+i].isOccupied()) {
				ValidMoves.add(board[x+i][y+i]);
			} else {
		        if (!board[x+i][y+i].getPiece().getColor().equals(this.color)) { //if we meet an enemy piece 
		            ValidMoves.add(board[x+i][y+i]);
		        }
		        break;
			}
			i++;
		}
		//top left
		i=1;
		while((y-i)>=0 && (x+i)<8) {
			if(!board[x+i][y-i].isOccupied()) {
				ValidMoves.add(board[x+i][y-i]);
			} else {
		        if (!board[x+i][y-i].getPiece().getColor().equals(this.color)) { //if we meet an enemy piece 
		            ValidMoves.add(board[x+i][y-i]);
		        }
		        break;
			}
			i++;
		}
		//down left
		i=1;
		while((y-i)>=0 && (x-i)>=0) {
			if(!board[x-i][y-i].isOccupied()) {
				ValidMoves.add(board[x-i][y-i]);
			} else {
		        if (!board[x-i][y-i].getPiece().getColor().equals(this.color)) { //if we meet an enemy piece 
		            ValidMoves.add(board[x-i][y-i]);
		        }
		        break;
			}
			i++;
		}
		//down right
		i=1;
		while((y+i)>=0 && (x-i)>=0) {
			if(!board[x-i][y+i].isOccupied()) {
				ValidMoves.add(board[x-i][y+i]);
			} else {
		        if (!board[x-i][y+i].getPiece().getColor().equals(this.color)) { //if we meet an enemy piece 
		            ValidMoves.add(board[x-i][y+i]);
		        }
		        break;
			}
			i++;
		}

		return ValidMoves;}
}


