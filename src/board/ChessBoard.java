package board;

import pieces.*;

public class ChessBoard {

    private Position[][] positions;

    public ChessBoard(){
        this.positions = new Position[8][8];
        initializeBoard();
    }
    private void initializeBoard(){
        for (int i=0; i<8; i++)
            for (int j=0; j<8; j++)
                this.positions[i][j] = new Position(i,j);

        this.positions[0][0].setPiece(new Rook(true));
        this.positions[0][1].setPiece(new Knight(true));
        this.positions[0][2].setPiece(new Bishop(true));
        this.positions[0][3].setPiece(new Queen(true));
        this.positions[0][4].setPiece(new King(true));
        this.positions[0][5].setPiece(new Bishop(true));
        this.positions[0][6].setPiece(new Knight(true));
        this.positions[0][7].setPiece(new Rook(true));

        this.positions[7][0].setPiece(new Rook(false));
        this.positions[7][1].setPiece(new Knight(false));
        this.positions[7][2].setPiece(new Bishop(false));
        this.positions[7][3].setPiece(new Queen(false));
        this.positions[7][4].setPiece(new King(false));
        this.positions[7][5].setPiece(new Bishop(false));
        this.positions[7][6].setPiece(new Knight(false));
        this.positions[7][7].setPiece(new Rook(false));

        for (int i=0; i<8; i++){
            this.positions[1][i].setPiece(new Pawn(true));
            this.positions[6][i].setPiece(new Pawn(false));
        }
    }
    public void printBoard() {
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < 8; j++) {
                if(j == 0)
                    System.out.print(i + "  ");
                if(this.positions[i-1][j].getPiece() != null)
                    System.out.print(this.positions[i-1][j].getPiece().getIcon() + " | ");
                else
                    System.out.print("- | ");
            }
            System.out.println();
        }
        System.out.println("   a   b   c   d   e   f   g   h");
    }
    public Position[][] getBoard(){
        return this.positions;
    }
//    public Piece piece(Integer row, Integer column){
//        if(!positionExists(row, column)){
//            throw new RuntimeException("This position does not exist");
//        }
//        return pieces[row][column];
//    }
//    public Piece piece(Position position){
//        if (!positionExists(position)){
//            throw new RuntimeException("This position does not exist");
//        }
//        return pieces[position.getRow()][position.getColumn()];
//    }
//    public  void placePiece(Piece piece, Position position){
//        if(thereIsAPiece(position)){
//            throw new RuntimeException(position + " - already has a piece" );
//        }
//        pieces[position.getRow()][position.getColumn()] = piece;
//        piece.position = position;
//    }
//
//    public Piece removePiece (Position position){
//        if(!positionExists(position)){
//            throw new RuntimeException("This position does not exist");
//        }
//        if (piece(position) == null) {
//            return null;
//        }
//        Piece aux = piece(position);
//        aux.position = null;
//        pieces[position.getRow()][position.getColumn()] = null;
//        return aux;
//    }
//
//    private boolean positionExists(int row, int column) {
//        return row >= 0 && row < rows && column >= 0 && column < columns;
//    }
//    public boolean positionExists(Position position) {
//        return positionExists(position.getRow(), position.getColumn());
//    }
//    public boolean thereIsAPiece(Position position) {
//        if (!positionExists(position)) {
//            throw new RuntimeException("This position does not exist");
//        }
//        return piece(position) != null;
//    }
}
