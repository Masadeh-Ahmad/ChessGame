package pieces;

import board.ChessBoard;

public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite, 'N');
    }

    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        int x = this.piecePosition()[0];
        int y = this.piecePosition()[1];

        return mat;
    }
}