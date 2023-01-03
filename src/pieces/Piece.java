package pieces;

import game.Color;
import board.ChessBoard;
import board.Position;

public abstract class Piece {
    private final Color color;
    private final char icon;

    private Position position;
    protected Piece(Color color,char icon) {
       this.color = color;
       this.icon = icon;
    }
    public void placePiece(Position position){
        this.position = position;
    }
    public void unPlacePiece(){
        this.position = null;
    }
    public Position getPosition(){
        if(this.isPlaced())
            return position;
        return null;
    }
    public boolean isPlaced(){
        return (position != null);
    }
    public Color getColor(){
        return color;
    }
    public char getIcon(){
        return this.icon;
    }
    public abstract boolean[][] possibleMoves(ChessBoard chessBoard);
}