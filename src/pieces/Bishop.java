package pieces;

import game.Color;
import board.ChessBoard;
import board.Position;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color, 'B');
    }

    public static void bishopMoves(boolean[][] mat,Piece piece, ChessBoard chessBoard) {
        int x = piece.getPosition().getRow();
        int y = piece.getPosition().getColumn();
        Position[][] board = chessBoard.getBoard();
        int i = x + 1;
        int j = y + 1;
        Piece pieceInPresent =null;
        while (i < 8 && j < 8 && pieceInPresent == null) {
            pieceInPresent = board[i][j].getPiece();
            if (chessBoard.canMove(board[x][y], board[i][j], piece.getColor()))
                mat[i][j] = true;
            i++;
            j++;
        }
        i = x - 1;
        j = y + 1;
        pieceInPresent =null;
        while (i >= 0 && j < 8 && pieceInPresent == null) {
            pieceInPresent = board[i][j].getPiece();
            if (chessBoard.canMove(board[x][y], board[i][j], piece.getColor()))
                mat[i][j] = true;
            i--;
            j++;
        }
        i = x + 1;
        j = y - 1;
        pieceInPresent =null;
        while (i < 8 && j >= 0 && pieceInPresent == null) {
            pieceInPresent = board[i][j].getPiece();
            if (chessBoard.canMove(board[x][y], board[i][j], piece.getColor()))
                mat[i][j] = true;
            i++;
            j--;
        }
        i = x - 1;
        j = y - 1;
        pieceInPresent =null;
        while (i >= 0 && j >= 0 && pieceInPresent == null) {
            pieceInPresent = board[i][j].getPiece();
            if (chessBoard.canMove(board[x][y], board[i][j], piece.getColor()))
                mat[i][j] = true;
            i--;
            j--;
        }
    }

    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        bishopMoves(mat,this, chessBoard);
        return mat;
    }
}

