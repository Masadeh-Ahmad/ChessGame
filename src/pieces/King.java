package pieces;

import game.Color;
import board.ChessBoard;
import board.Position;

public class King extends Piece {

    public King(Color color) {
        super(color, 'K');
    }

    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        int x = this.getPosition().getRow();
        int y = this.getPosition().getColumn();
        Position[][] board = chessBoard.getBoard();
        if(x-1 >= 0){
            if(chessBoard.canMove(board[x][y],board[x-1][y],this.getColor()))
                mat[x - 1][y]=true;
            if(y+1 < 8){
                if(chessBoard.canMove(board[x][y],board[x-1][y+1],this.getColor()))
                    mat[x - 1][y + 1]=true;
                if(chessBoard.canMove(board[x][y],board[x][y+1],this.getColor()))
                    mat[x][y + 1]=true;
            }
            if(y-1 >= 0){
                if(chessBoard.canMove(board[x][y],board[x-1][y-1],this.getColor()))
                    mat[x - 1][y - 1]=true;
                if(chessBoard.canMove(board[x][y],board[x][y-1],this.getColor()))
                    mat[x][y - 1]=true;
            }
        }
        if(x+1 < 8){
            if(chessBoard.canMove(board[x][y],board[x+1][y],this.getColor()))
                mat[x + 1][y]=true;
            if(y+1 < 8 && chessBoard.canMove(board[x][y],board[x+1][y+1],this.getColor())){
                mat[x + 1][y + 1]=true;
            }
            if(y-1 >= 0 && chessBoard.canMove(board[x][y],board[x+1][y-1],this.getColor())){
                mat[x + 1][y - 1]=true;
            }
        }
        return mat;
    }
}