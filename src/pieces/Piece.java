package pieces;


import board.ChessBoard;

public abstract class Piece {
    private final boolean isWhite;
    protected final char icon;
    private Integer row;
    private  Integer column;
    public Piece(boolean isWhite,char icon) {
       this.isWhite = isWhite;
       this.icon = icon;
    }
    public boolean isPlaced(){
        return (row != null && column != null);
    }
    public int[] piecePosition(){
        if(!isPlaced())
            return null;
        return new int[] {this.row,this.column};
    }
    public boolean getColor(){
        return isWhite;
    }
    public char getIcon(){
        return this.icon;
    }
    public void placePiece(int x, int y){
        this.row = x;
        this.column = y;
    }
    public abstract boolean[][] possibleMoves(ChessBoard chessBoard);

//    protected ChessBorad getBoard() {
//        return chessBoard;
//    }
//
//    public abstract boolean[][] possibleMoves();
//
//    public boolean possibleMove(Position position) {
//        return possibleMoves()[position.getRow()][position.getColumn()];
//    }
//
//    public boolean isThereAnyPossibleMove() {
//        boolean[][] mat = possibleMoves();
//        for (int i=0; i<mat.length; i++) {
//            for (int j=0; j<mat.length; j++) {
//                if (mat[i][j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}