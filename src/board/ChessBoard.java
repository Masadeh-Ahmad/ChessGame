package board;

import Game.Color;
import Game.Player;
import pieces.*;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

    private Position[][] positions;
    private Position WhiteKingPosition;
    private Position BlackKingPosition;
    private ArrayList<Piece> whitePieces;
    private ArrayList<Piece> blackPieces;
    private Player player1;
    private Player player2;
    private Color turn;

    public ChessBoard(String username1,String username2) {
        this.positions = new Position[8][8];

        this.player1 = new Player(username1);
        this.player2 = new Player(username2);
        player1.setColor(Color.WHITE);
        player2.setColor(Color.BLACK);

        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();

        this.turn = Color.WHITE;

        initializeBoard();

        this.WhiteKingPosition = positions[0][4];
        this.BlackKingPosition = positions[7][4];
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
    public Position getBlackKingPosition() {
        return BlackKingPosition;
    }

    public Position getWhiteKingPosition() {
        return WhiteKingPosition;
    }

    public void setWhiteKingPosition(Position whiteKingPosition) {
        WhiteKingPosition = whiteKingPosition;
    }

    public void setBlackKingPosition(Position blackKingPosition) {
        BlackKingPosition = blackKingPosition;
    }
    public boolean canMove(Position source,Position destination,Color color){
        Piece sourcePiece = source.getPiece();
        Piece destinationPiece = destination.getPiece();
        if(sourcePiece == null || (destinationPiece!=null && destinationPiece.getColor() == color))
            return false;
        return true;
    }
    private boolean testCheck(Color color) {
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
                        if(mat[i][j])
                            if(tryMove(piece.getPosition(this),positions[i][j],color))
                                return false;
                    }
            }
        }
        return true;
    }
    public boolean tryMove(Position source,Position destination,Color color){
        boolean canMove = true;
        Piece sourcePiece = source.getPiece();
        Piece destinationPiece = destination.getPiece();
        if(sourcePiece == null || sourcePiece.getColor() != color)
            throw new RuntimeException();
        boolean [][] mat ;
        mat = sourcePiece.possibleMoves(this);
        if(mat[destination.getRow()][destination.getColumn()]) {
            destination.setPiece(source.removePiece());
        }
        if(testCheck(color))
            canMove = false;
        source.setPiece(destination.removePiece());
        if(destinationPiece != null)
            destination.setPiece(destinationPiece);
        return canMove;
    }
    public boolean move(Position source,Position destination,Color color){

        if(tryMove(source,destination,color)){
            destination.setPiece(source.removePiece());
            return true;
        }
        return false;

    }
    public void printBoard() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_Yellow ="\u001B[33m";
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (j == 0)
                    System.out.print(i + "  ");
                if (this.positions[i - 1][j].getPiece() != null) {
                    if (this.positions[i - 1][j].getPiece().getColor() == Color.WHITE)
                        System.out.print(this.positions[i - 1][j].getPiece().getIcon() + " | ");
                    else
                        System.out.print(ANSI_Yellow+this.positions[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
                }
                else
                    System.out.print("- | ");
            }
            System.out.println();
        }
        System.out.println("   a   b   c   d   e   f   g   h");
    }
    public void printBoard(boolean [][] mat,int r,int c){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[46m";
        final String ANSI_Yellow ="\u001B[33m";
        final String ANSI_RED = "\u001B[31m";
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (j == 0)
                    System.out.print(i + "  ");
                if (this.positions[i - 1][j].getPiece() != null) {
                    if (this.positions[i - 1][j].getPiece().getColor() == Color.WHITE){
                        if(i-1 == r && j == c)
                            System.out.print(ANSI_RED+this.positions[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
                        else {
                            if(mat[i-1][j])
                                System.out.print(ANSI_BLUE+this.positions[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
                            else
                                System.out.print(this.positions[i - 1][j].getPiece().getIcon() + " | ");
                        }
                    }
                    else{
                        if(mat[i-1][j])
                            System.out.print(ANSI_Yellow+ANSI_BLUE+this.positions[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
                        else
                            System.out.print(ANSI_Yellow+this.positions[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
                    }

                }
                else{
                    if(mat[i-1][j])
                        System.out.print(ANSI_BLUE+"-"+ANSI_RESET+" | ");
                    else
                        System.out.print("- | ");
                }

            }
            System.out.println();
        }
        System.out.println("   a   b   c   d   e   f   g   h");
    }


}
