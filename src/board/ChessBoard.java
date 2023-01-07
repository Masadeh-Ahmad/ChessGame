package board;
import game.Color;
import pieces.*;

import java.util.ArrayList;
public class ChessBoard {
    private final Position[][] positions;
    private final ArrayList<Piece> pieces;
    private Color turn;
    private int numOfMoves;
    public ChessBoard(int numOfMoves) {
        this.positions = new Position[8][8];
        this.numOfMoves = numOfMoves;
        pieces = new ArrayList<>();
        this.turn = Color.WHITE;
        initializeBoard();
    }
    private void initializeBoard() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                this.positions[i][j] = new Position(i, j);

        this.positions[0][0].setPiece(new Rook(Color.WHITE));
        this.positions[0][1].setPiece(new Knight(Color.WHITE));
        this.positions[0][2].setPiece(new Bishop(Color.WHITE));
        this.positions[0][3].setPiece(new Queen(Color.WHITE));
        this.positions[0][4].setPiece(new King(Color.WHITE));
        this.positions[0][5].setPiece(new Bishop(Color.WHITE));
        this.positions[0][6].setPiece(new Knight(Color.WHITE));
        this.positions[0][7].setPiece(new Rook(Color.WHITE));

        this.positions[7][0].setPiece(new Rook(Color.BLACK));
        this.positions[7][1].setPiece(new Knight(Color.BLACK));
        this.positions[7][2].setPiece(new Bishop(Color.BLACK));
        this.positions[7][3].setPiece(new Queen(Color.BLACK));
        this.positions[7][4].setPiece(new King(Color.BLACK));
        this.positions[7][5].setPiece(new Bishop(Color.BLACK));
        this.positions[7][6].setPiece(new Knight(Color.BLACK));
        this.positions[7][7].setPiece(new Rook(Color.BLACK));

        for (int i = 0; i < 8; i++) {
            this.positions[1][i].setPiece(new Pawn(Color.WHITE));
            this.positions[6][i].setPiece(new Pawn(Color.BLACK));
            pieces.add(positions[0][i].getPiece());
            pieces.add(positions[1][i].getPiece());
            pieces.add(positions[6][i].getPiece());
            pieces.add(positions[7][i].getPiece());
        }
    }
    public Position[][] getBoard() {
        return this.positions;
    }
    public Color getTurn() {
        return turn;
    }
    public int getNumOfMoves() {
        return numOfMoves;
    }
    public Color switchTurn(){
        if(this.turn == Color.WHITE)
            this.turn = Color.BLACK;
        else
            this.turn = Color.WHITE;
        return this.turn;
    }
    public Color opponent(){
        if(this.turn == Color.WHITE)
            return Color.BLACK;
        else
            return Color.WHITE;
    }

    public boolean testCheck(Color color) {
        Position kingPosition = null;
        for(Piece piece: pieces){
            if(piece instanceof King && piece.getColor() == color)
                kingPosition = piece.getPosition();
        }
        for(Piece piece : pieces.stream().filter(p -> p.isPlaced() && p.getColor() != color).toArray(Piece[]::new)){
            boolean[][] mat = piece.possibleMoves(this);
            if (kingPosition!=null && mat[kingPosition.getRow()][kingPosition.getColumn()]) {
                return true;
            }
        }
        return false;
    }
    public boolean testCheckMate(Color color) {
        if(!testCheck(color))
            return false;
        for(Piece piece : pieces.stream().filter(p -> p.isPlaced() && p.getColor() == color).toArray(Piece[]::new)){
            boolean [][] mat = piece.possibleMoves(this);
            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++){
                    if(mat[i][j] && tryMove(piece.getPosition(),positions[i][j],color))
                        return false;
                }
        }
        return true;
    }
    public boolean canMove(Position source,Position destination,Color color){
        Piece destinationPiece = destination.getPiece();
        return source.pieceExist() && (!destination.pieceExist() || destinationPiece.getColor() != color);
    }
    public boolean isBlocked(Piece piece){
        boolean[][] mat = piece.possibleMoves(this);
        for (boolean[] row : mat)
            for (boolean p : row)
                if(p)
                    return false;
        return true;
    }
    private void undoMove(Position source,Position destination,Piece piece){
        source.setPiece(destination.removePiece());
        if(piece != null)
            destination.setPiece(piece);
    }
    private boolean tryMove(Position source,Position destination,Color color) {
        Piece sourcePiece = source.getPiece();
        Piece destinationPiece = destination.getPiece();
        if(!source.pieceExist() || sourcePiece.getColor() != color)
            return false;
        boolean [][] mat = sourcePiece.possibleMoves(this);
        if(mat[destination.getRow()][destination.getColumn()]) {
            destination.setPiece(source.removePiece());
            if(testCheck(color)) {
                undoMove(source, destination, destinationPiece);
                return false;
            }
        }
        else
            return false;
        undoMove(source, destination, destinationPiece);
        return true;
    }
    public boolean move(Position source,Position destination,Color color){

        if(tryMove(source,destination,color)){
            destination.setPiece(source.removePiece());
            this.numOfMoves--;
            return true;
        }
        return false;
    }
}
