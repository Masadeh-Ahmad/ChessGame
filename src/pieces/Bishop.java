package pieces;

import board.ChessBoard;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite, 'B');
    }

    @Override
    public boolean[][] possibleMoves(ChessBoard chessBoard) {
        boolean[][] mat = new boolean[8][8];
        int x = this.piecePosition()[0];
        int y = this.piecePosition()[1];
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

