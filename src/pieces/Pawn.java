package pieces;
import board.ChessBoard;
public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite, 'P');
    }
    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        int x = this.piecePosition()[0];
        int y = this.piecePosition()[1];

        if (getColor()) {
            Piece piece;
            if (x + 1 < 8 && y + 1 < 8) {
                piece = chessBoard.getBoard()[x + 1][y + 1].getPiece();
                if (piece != null && !piece.getColor())
                    mat[x + 1][y + 1] = true;
            }
            if (x - 1 < 8 && y + 1 < 8) {
                piece = chessBoard.getBoard()[x - 1][y + 1].getPiece();
                if (piece != null && !piece.getColor())
                    mat[x - 1][y + 1] = true;
            }
            if (y + 1 < 8) {
                piece = chessBoard.getBoard()[x][y + 1].getPiece();
                if (piece == null) {
                    mat[x][y + 1] = true;
                    if (y == 1) {
                        piece = chessBoard.getBoard()[x][y + 2].getPiece();
                        if (piece == null)
                            mat[x][y + 2] = true;
                    }
                }
            }
        }
        return mat;
    }
}