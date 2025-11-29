import java.util.ArrayList;

public class Queen extends Piece {
	public Queen (String color) {
		super(color, "/"+color+"_pieces/queen.png");
	}
	
	public ArrayList<Square> getValidMoves() {
		ArrayList<Square> ValidMoves = new ArrayList<>();
		Square square = this.getSquare();
		Square[][] board = square.getBoard();
		int x = square.getX();
		int y = square.getY();

	    int i;

	    //up
	    i=1;
	    while ((y+i)<8) {
	        if (!board[x][y+i].isOccupied()) {
	            ValidMoves.add(board[x][y+i]);
	        } else {
	            if (!board[x][y+i].getPiece().getColor().equals(this.color)) { //if we meet an enemy piece 
	                ValidMoves.add(board[x][y+i]);
	            }
	            break;
	        }
	        i++;
	    }
	    
	    //down
	    i=1;
	    while ((y-i)>=0) {
	        if (!board[x][y-i].isOccupied()) {
	            ValidMoves.add(board[x][y-i]);
	        } else {
	            if (!board[x][y-i].getPiece().getColor().equals(this.color)) {
	                ValidMoves.add(board[x][y-i]);
	            }
	            break;
	        }
	        i++;
	    }

	    //right
	    i=1;
	    while ((x+i)<8) {
	        if (!board[x+i][y].isOccupied()) {
	            ValidMoves.add(board[x+i][y]);
	        } else {
	            if (!board[x+i][y].getPiece().getColor().equals(this.color)) {
	                ValidMoves.add(board[x+i][y]);
	            }
	            break;
	        }
	        i++;
	    }

	    //left
	    i=1;
	    while ((x-i)>=0) {
	        if (!board[x-i][y].isOccupied()) {
	            ValidMoves.add(board[x-i][y]);
	        } else {
	            if (!board[x-i][y].getPiece().getColor().equals(this.color)) {
	                ValidMoves.add(board[x-i][y]);
	            }
	            break; //The code stops after meeting a piece
	        }
	        i++;
	    }
	    
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
