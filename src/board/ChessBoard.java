package board;

import game.Color;
import game.Player;
import pieces.*;

import java.util.ArrayList;

public class ChessBoard {

    private final Position[][] positions;
    private Position whiteKingPosition;
    private Position blackKingPosition;
    private final ArrayList<Piece> whitePieces;
    private final ArrayList<Piece> blackPieces;
    private final Player player1;
    private final Player player2;
    private Color turn;
    private int numOfMoves;

    public ChessBoard(String username1,String username2,int numOfMoves) {
        this.positions = new Position[8][8];
        this.numOfMoves = numOfMoves;
        this.player1 = new Player(username1);
        this.player2 = new Player(username2);
        player1.setColor(Color.WHITE);
        player2.setColor(Color.BLACK);

        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();

        this.turn = Color.WHITE;

        initializeBoard();

        this.whiteKingPosition = positions[0][4];
        this.blackKingPosition = positions[7][4];
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
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Color getTurn() {
        return turn;
    }

    public int getNumOfMoves() {
        return numOfMoves;
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
            whitePieces.add(positions[0][i].getPiece());
            whitePieces.add(positions[1][i].getPiece());
            blackPieces.add(positions[6][i].getPiece());
            blackPieces.add(positions[7][i].getPiece());
        }
    }
    public Position[][] getBoard() {
        return this.positions;
    }
    private Position getBlackKingPosition() {
        return blackKingPosition;
    }

    private Position getWhiteKingPosition() {
        return whiteKingPosition;
    }

    private void setWhiteKingPosition(Position whiteKingPosition) {
        this.whiteKingPosition = whiteKingPosition;
    }

    private void setBlackKingPosition(Position blackKingPosition) {
        this.blackKingPosition = blackKingPosition;
    }
    public boolean canMove(Position source,Position destination,Color color){
        Piece sourcePiece = source.getPiece();
        Piece destinationPiece = destination.getPiece();
        return sourcePiece != null && (destinationPiece == null || destinationPiece.getColor() != color);
    }
    public boolean canMove(Piece piece){
        boolean[][] mat = piece.possibleMoves(this);
        for (boolean[] row : mat)
            for (boolean p : row)
                if(p)
                    return true;
        return false;
    }
    public boolean testCheck(Color color) {
        Position kingPosition;
        if(color == Color.WHITE)
            kingPosition = getWhiteKingPosition();
        else
            kingPosition = getBlackKingPosition();
        for (Position[] row : positions) {
            for(Position p : row){
                Piece piece = p.getPiece();
                if (piece != null && piece.getColor() != color) {
                    boolean[][] mat = piece.possibleMoves(this);
                    if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean testCheckMate(Color color) {
        if(!testCheck(color))
            return false;
        ArrayList<Piece> pieces;
        if(color == Color.WHITE)
            pieces = whitePieces;
        else
            pieces = blackPieces;
        for(Piece piece : pieces){
            if(piece.isPlaced()){
                boolean [][] mat = piece.possibleMoves(this);
                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 8; j++){
                        if(mat[i][j] && tryMove(piece.getPosition(),positions[i][j],color))
                            return false;
                    }
            }
        }
        return true;
    }
    private boolean tryMove(Position source,Position destination,Color color) {
        boolean canMove = true;
        Piece sourcePiece = source.getPiece();
        Piece destinationPiece = destination.getPiece();
        if(sourcePiece == null || sourcePiece.getColor() != color)
            return false;
        boolean [][] mat ;
        mat = sourcePiece.possibleMoves(this);
        if(mat[destination.getRow()][destination.getColumn()]) {
            destination.setPiece(source.removePiece());
        }
        if(destination.getPiece() instanceof King){
            if(color == Color.WHITE)
                setWhiteKingPosition(destination.getPiece().getPosition());
            else
                setBlackKingPosition(destination.getPiece().getPosition());
        }
        if(testCheck(color))
            canMove = false;
        source.setPiece(destination.removePiece());
        if(source.getPiece() instanceof King){
            if(color == Color.WHITE)
                setWhiteKingPosition(source.getPiece().getPosition());
            else
                setBlackKingPosition(source.getPiece().getPosition());
        }
        if(destinationPiece != null)
            destination.setPiece(destinationPiece);
        return canMove;
    }
    public boolean move(Position source,Position destination,Color color){

        if(tryMove(source,destination,color)){
            destination.setPiece(source.removePiece());
            this.numOfMoves--;
            if(destination.getPiece() instanceof King){
                if(color == Color.WHITE)
                    setWhiteKingPosition(destination.getPiece().getPosition());
                else
                    setBlackKingPosition(destination.getPiece().getPosition());
            }
            return true;
        }
        return false;

    }
}
