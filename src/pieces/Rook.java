package pieces;
import game.Color;
import board.ChessBoard;
import board.Position;
public class Rook extends Piece {
    public Rook(Color color) {
        super(color,'R');
    }
    public static void rookMoves(boolean[][] mat,Piece piece, ChessBoard chessBoard) {
        int x = piece.getPosition().getRow();
        int y = piece.getPosition().getColumn();
        Position[][] board = chessBoard.getBoard();
        // East
        for(int i = y+1;i<8;i++) {
            if (chessBoard.canMove(board[x][y], board[x][i], piece.getColor()))
                mat[x][i] = true;
            if(board[x][i].pieceExist())
                break;
        }
        // West
        for(int i = y-1;i>=0;i--) {
            if (chessBoard.canMove(board[x][y], board[x][i], piece.getColor()))
                mat[x][i] = true;
            if(board[x][i].pieceExist())
                break;
        }
        // South
        for(int i = x-1;i>=0;i--) {
            if (chessBoard.canMove(board[x][y], board[i][y], piece.getColor()))
                mat[i][y] = true;
            if(board[i][y].pieceExist())
                break;
        }
        // North
        for(int i = x+1;i<8;i++) {
            if (chessBoard.canMove(board[x][y], board[i][y], piece.getColor()))
                mat[i][y] = true;
            if(board[i][y].pieceExist())
                break;
        }

    }
    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        rookMoves(mat,this,chessBoard);
        return mat;
    }
}


