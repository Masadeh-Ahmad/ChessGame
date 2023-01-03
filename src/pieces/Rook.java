package pieces;
import Game.Color;
import board.ChessBoard;
import board.Position;
public class Rook extends Piece {
    public Rook(Color color) {
        super(color,'R');
    }
    public static void rookMoves(boolean[][] mat,Piece piece, ChessBoard chessBoard) {
        int x = piece.piecePosition()[0];
        int y =piece.piecePosition()[1];
        Position[][] board = chessBoard.getBoard();
        Piece pieceInPresent =null;

        for(int i = y+1;i<8 && pieceInPresent == null;i++){
            pieceInPresent = board[x][i].getPiece();
            if (chessBoard.canMove(board[x][y], board[x][i], piece.getColor()))
                mat[x][i] = true;
        }
        for(int i = y-1;i>=0 && pieceInPresent == null;i--){
            pieceInPresent = board[x][i].getPiece();
            if (chessBoard.canMove(board[x][y], board[x][i], piece.getColor()))
                mat[x][i] = true;
        }
        for(int i = x-1;i>=0 && pieceInPresent == null;i--){
            pieceInPresent = board[i][y].getPiece();
            if (chessBoard.canMove(board[x][y], board[i][y], piece.getColor()))
                mat[i][y] = true;
        }
        for(int i = x+1;i<8 && pieceInPresent == null;i++){
            pieceInPresent = board[i][y].getPiece();
            if (chessBoard.canMove(board[x][y], board[i][y], piece.getColor()))
                mat[i][y] = true;
        }
    }
    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        rookMoves(mat,this,chessBoard);
        return mat;
    }
}


