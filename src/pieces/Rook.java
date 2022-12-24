package pieces;
import board.ChessBoard;
import board.Position;
public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite,'R');
    }
    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];

        int x = this.piecePosition()[0];
        int y =this.piecePosition()[1];

        for(int i=y+1;i<8;i++){
            Piece piece = chessBoard.getBoard()[x][i].getPiece();
            if(piece != null) {
                if (piece.getColor()!= this.getColor())
                    mat[x][i] = true;
                break;
            }
            mat[x][i] = true;
        }
        for(int i=y-1;i>=0;i--){
            Piece piece = chessBoard.getBoard()[x][i].getPiece();
            if(piece != null) {
                if (piece.getColor()!= this.getColor())
                    mat[x][i] = true;
                break;
            }
            mat[x][i] = true;
        }
        for(int i=x-1;i>=0;i--){
            Piece piece = chessBoard.getBoard()[i][y].getPiece();
            if(piece != null) {
                if (piece.getColor()!= this.getColor())
                    mat[x][i] = true;
                break;
            }
            mat[x][i] = true;
        }
        for(int i=x+1;i<8;i++){
            Piece piece = chessBoard.getBoard()[i][y].getPiece();
            if(piece != null) {
                if (piece.getColor()!= this.getColor())
                    mat[x][i] = true;
                break;
            }
            mat[x][i] = true;
        }
        return mat;
    }
}


