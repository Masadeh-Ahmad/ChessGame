package pieces;

import game.Color;
import board.ChessBoard;
import board.Position;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color, 'N');
    }

    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        int x = this.getPosition().getRow();
        int y = this.getPosition().getColumn();
        Position[][] board = chessBoard.getBoard();
        if(y+2 < 8){
            if(x+1 < 8 && chessBoard.canMove(board[x][y],board[x+1][y+2],this.getColor()))
                mat[x + 1][y + 2]=true;
            if(x-1 >= 0 && chessBoard.canMove(board[x][y],board[x-1][y+2],this.getColor())){
                mat[x - 1][y + 2]=true;
            }
        }
        if(y-2 >= 0){
            if(x+1 < 8 && chessBoard.canMove(board[x][y],board[x+1][y-2],this.getColor()))
                mat[x + 1][y - 2]=true;
            if(x-1 >= 0 && chessBoard.canMove(board[x][y],board[x-1][y-2],this.getColor()))
                mat[x - 1][y - 2]=true;
        }
        if(x+2 < 8){
            if(y+1 < 8 && chessBoard.canMove(board[x][y],board[x+2][y+1],this.getColor()))
                mat[x + 2][y + 1]=true;
            if(y-1 >= 0 && chessBoard.canMove(board[x][y],board[x+2][y-1],this.getColor()))
                mat[x + 2][y - 1]=true;
        }
        if(x-2 >= 0){
            if(y+1 < 8 && chessBoard.canMove(board[x][y],board[x-2][y+1],this.getColor()))
                mat[x - 2][y + 1]=true;
            if(y-1 >= 0 && chessBoard.canMove(board[x][y],board[x-2][y-1],this.getColor()))
                mat[x - 2][y - 1]=true;
        }
        return mat;
    }
}