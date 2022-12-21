package pieces;



import board.Position;


public class Knight extends Piece {

    public Knight(boolean isWhite) {
        super(isWhite, 'N');
    }
}

//    public Knight(ChessBorad board, Color color) {
//        super(board, color);
//    }
//
//    public String toString(){
//        return "C";
//    }
//
//    private boolean canMove(Position position){
//        ChessPiece p = (ChessPiece)getBoard().piece(position);
//        return  p == null || p.getColor() != getColor();
//    }
//
//    @Override
//    public boolean[][] possibleMoves() {
//        boolean[][] mat= new boolean[8][8];
//        Position p = new Position(0,0);
//
//        p.setValues(position.getRow() - 1, position.getColumn() - 2);
//        if (getBoard().positionExists(p) && canMove(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        p.setValues(position.getRow() - 2, position.getColumn() - 1);
//        if (getBoard().positionExists(p) && canMove(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        p.setValues(position.getRow() - 2, position.getColumn() + 1);
//        if (getBoard().positionExists(p) && canMove(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        p.setValues(position.getRow() - 1, position.getColumn() + 2);
//        if (getBoard().positionExists(p) && canMove(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        p.setValues(position.getRow() + 1, position.getColumn() + 2);
//        if (getBoard().positionExists(p) && canMove(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        p.setValues(position.getRow() + 2, position.getColumn() + 1);
//        if (getBoard().positionExists(p) && canMove(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        p.setValues(position.getRow() + 2, position.getColumn() - 1);
//        if (getBoard().positionExists(p) && canMove(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        p.setValues(position.getRow() + 1, position.getColumn() - 2);
//        if (getBoard().positionExists(p) && canMove(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//
//        return mat;
//    }




