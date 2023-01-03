package pieces;
import Game.Color;
import board.ChessBoard;
import board.Position;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color, 'P');
    }
    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        int x = this.piecePosition()[0];
        int y = this.piecePosition()[1];
        Position[][] board = chessBoard.getBoard();
        if (this.getColor()==Color.WHITE) {
            if (x + 1 < 8 && y + 1 < 8) {
                if (board[x+1][y+1].getPiece() != null && chessBoard.canMove(board[x][y],board[x+1][y+1],this.getColor()))
                    mat[x + 1][y + 1] = true;
            }
            if (x + 1 < 8 && y - 1 > 0) {
                if (board[x+1][y-1].getPiece() != null && chessBoard.canMove(board[x][y],board[x+1][y-1],this.getColor()))
                    mat[x + 1][y - 1] = true;
            }
            if (x + 1 < 8) {
                if (board[x+1][y].getPiece() == null && chessBoard.canMove(board[x][y],board[x+1][y],this.getColor())) {
                    mat[x+1][y] = true;
                    if (x == 1) {
                        if (board[x+2][y].getPiece() == null && chessBoard.canMove(board[x][y],board[x+2][y],this.getColor()))
                            mat[x+2][y] = true;
                    }
                }
            }
        }
        else {
            if (x - 1 > 0 && y + 1 < 8) {
                if (board[x-1][y+1].getPiece() != null && chessBoard.canMove(board[x][y],board[x-1][y+1],this.getColor()))
                    mat[x - 1][y + 1] = true;
            }
            if (x - 1 > 0 && y - 1 > 0) {
                if (board[x-1][y-1].getPiece() != null && chessBoard.canMove(board[x][y],board[x-1][y-1],this.getColor()))
                    mat[x - 1][y - 1] = true;
            }
            if (x - 1 > 0) {
                if (board[x-1][y].getPiece() == null && chessBoard.canMove(board[x][y],board[x-1][y],this.getColor())) {
                    mat[x-1][y] = true;
                    if (x == 6) {
                        if (board[x-2][y].getPiece() == null && chessBoard.canMove(board[x][y],board[x-2][y],this.getColor()))
                            mat[x-2][y] = true;
                    }
                }
            }
        }
        return mat;
    }
}