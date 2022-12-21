package pieces;



import Game.Color;

import board.Position;


public class Bishop extends Piece {

    public Bishop(boolean isWhite) {
        super(isWhite, 'B');
    }
//    public Bishop(ChessBorad board, Color color) {
//        super(board, color);
//    }
//
//    @Override
//    public boolean[][] possibleMoves() {
//
//        boolean[][] mat = new boolean[8][8];
//
//        Position p = new Position(0, 0);
//
//        // northwest
//        p.setValues(position.getRow() - 1, position.getColumn() - 1);
//        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//            p.setValues(p.getRow() - 1, p.getColumn() - 1);
//        }
//        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        // northeast
//        p.setValues(position.getRow() - 1, position.getColumn() + 1);
//        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//            p.setValues(p.getRow() - 1, p.getColumn() + 1);
//        }
//        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        // southeast
//        p.setValues(position.getRow() + 1 , position.getColumn() + 1);
//        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//            p.setValues(p.getRow() + 1, p.getColumn() + 1);
//        }
//        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        // below
//        p.setValues(position.getRow() + 1, position.getColumn() - 1 );
//        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//            p.setValues(p.getRow() + 1, p.getColumn() - 1);
//        }
//        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        return mat;
//    }
//
//    @Override
//    public String toString(){
//        return "B";
//    }
}

