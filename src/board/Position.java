package board;

import pieces.Piece;

public class Position {
    private final int row;
    private final int column;
    private Piece piece;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    public Piece getPiece(){
        return this.piece;
    }
    public void setPiece(Piece piece){
        if( this.piece != null)
            removePiece();
        this.piece = piece;
        this.piece.placePiece(this.row,this.column);
    }
    public Piece removePiece(){
        Piece piece = this.piece;
        piece.unPlacePiece();
        this.piece = null;
        return piece;
    }
}
