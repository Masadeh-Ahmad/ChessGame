package pieces;

import Game.Color;
import board.ChessBoard;
public abstract class Piece {
    private final Color color;
    protected final char icon;
    private Integer row;
    private  Integer column;
    public Piece(Color color,char icon) {
       this.color = color;
       this.icon = icon;
    }
    public void placePiece(int x, int y){
        this.row = x;
        this.column = y;
    }
    public void unPlacePiece(){
        this.row = null;
        this.column = null;
    }
    public int[] piecePosition(){
        if(!isPlaced())
            return null;
        return new int[] {this.row,this.column};
    }
    public boolean isPlaced(){
        return (row != null && column != null);
    }
    public Color getColor(){
        return color;
    }
    public char getIcon(){
        return this.icon;
    }
    public abstract boolean[][] possibleMoves(ChessBoard chessBoard);
}