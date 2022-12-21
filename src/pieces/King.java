package pieces;

import Game.ChessGame;

import board.Position;


public class King extends Piece {

    public King(boolean isWhite) {
        super(isWhite, 'K');
    }

//    private ChessGame chessGame;
//
//    public King(ChessBorad board, Color color, ChessGame chessGame) {
//        super(board, color);
//        this.chessGame = chessGame;
//    }
//    public ChessGame getChessMatch() {
//        return chessGame;
//    }
//    @Override
//    public String toString(){
//        return "R";
//    }
//
//    private boolean canMove(Position position){
//        ChessPiece p = (ChessPiece)getBoard().piece(position);
//        return  p == null || p.getColor() != getColor();
//    }
//
//    private boolean testRookCastling(Position position){
//        ChessPiece p = (ChessPiece)getBoard().piece(position);
//        return position !=null && p instanceof Rook && getColor() == getColor() && p.getMoveCount() == 0;
//    }
//
//    @Override
//    public boolean[][] possibleMoves() {
//        boolean[][] mat= new boolean[8][8];
//        Position p = new Position(0,0);
//
//        //above
//        p.setValues(position.getRow() - 1, position.getColumn());
//        if(getBoard().positionExists(p) && canMove(p)){
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//        //below
//        p.setValues(position.getRow() + 1, position.getColumn());
//        if(getBoard().positionExists(p) && canMove(p)){
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//        //left
//        p.setValues(position.getRow(), position.getColumn() - 1);
//        if(getBoard().positionExists(p) && canMove(p)){
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//        //right
//        p.setValues(position.getRow(), position.getColumn() + 1);
//        if(getBoard().positionExists(p) && canMove(p)){
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//
//        p.setValues(position.getRow() - 1, position.getColumn() - 1);
//        if(getBoard().positionExists(p) && canMove(p)){
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//
//        p.setValues(position.getRow() + 1, position.getColumn() + 1);
//        if(getBoard().positionExists(p) && canMove(p)){
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//
//        p.setValues(position.getRow() + 1, position.getColumn() - 1);
//        if(getBoard().positionExists(p) && canMove(p)){
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//
//        //southeast
//        p.setValues(position.getRow() - 1, position.getColumn() + 1);
//        if(getBoard().positionExists(p) && canMove(p)){
//            mat[p.getRow()][p.getColumn()] = true;
//        }
//
//
//        //Special move castling
//        if(getMoveCount() == 0 && !chessMatch.isCheck()){
//            //# special move castling kingside rook
//            Position positionT1 = new Position(position.getRow(), position.getColumn() + 3);
//            if(testRookCastling(positionT1)){
//                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
//                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
//                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null){
//                    mat[position.getRow()][position.getColumn() + 2] = true;
//                }
//            }
//            //# special move castling queenside rook
//            Position positionT2 = new Position(position.getRow(), position.getColumn() - 4);
//            if(testRookCastling(positionT2)){
//                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
//                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
//                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
//                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
//                    mat[position.getRow()][position.getColumn() - 2] = true;
//                }
//            }
//
//        }
//        return mat;
//    }


}