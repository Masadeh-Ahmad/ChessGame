package pieces;

import Game.Color;
import board.ChessBoard;
import static pieces.Rook.rookMoves;
import static pieces.Bishop.bishopMoves;
public class Queen extends Piece {
    public Queen(Color color) {
        super(color, 'Q');
    }
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        rookMoves(mat,this,chessBoard);
        bishopMoves(mat,this,chessBoard);
        return mat;
    }
}

