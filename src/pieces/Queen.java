package pieces;


import board.ChessBoard;
import board.Position;


public class Queen extends Piece {

    public Queen(boolean isWhite) {
        super(isWhite, 'Q');
    }

    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        int x = this.piecePosition()[0];
        int y = this.piecePosition()[1];
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
        int i = x+1;
        int j = y+1;
        while (i<8 && j<8){
            Piece piece = chessBoard.getBoard()[i][j].getPiece();
            if(piece != null) {
                if (piece.getColor()!= this.getColor())
                    mat[i][j] = true;
                break;
            }
            mat[x][i] = true;
            i++;
            j++;
        }
        i = x-1;
        j = y+1;
        while (i>=0 && j<8){
            Piece piece = chessBoard.getBoard()[i][j].getPiece();
            if(piece != null) {
                if (piece.getColor()!= this.getColor())
                    mat[i][j] = true;
                break;
            }
            mat[x][i] = true;
            i--;
            j++;
        }
        i = x+1;
        j = y-1;
        while (i<8 && j>=0){
            Piece piece = chessBoard.getBoard()[i][j].getPiece();
            if(piece != null) {
                if (piece.getColor()!= this.getColor())
                    mat[i][j] = true;
                break;
            }
            mat[x][i] = true;
            i++;
            j--;
        }
        i = x-1;
        j = y-1;
        while (i>=0 && j>=0){
            Piece piece = chessBoard.getBoard()[i][j].getPiece();
            if(piece != null) {
                if (piece.getColor()!= this.getColor())
                    mat[i][j] = true;
                break;
            }
            mat[x][i] = true;
            i--;
            j--;
        }
        return mat;
    }
}

