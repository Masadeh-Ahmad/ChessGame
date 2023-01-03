package Game;


import board.ChessBoard;
import board.Position;
import pieces.Piece;

import java.util.Scanner;

public class ChessGame {

    public static int ColumnsConvert(char x){
        switch (x){
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                throw new RuntimeException();
        }
    }
    private static void printPossibleMoves(int row,int column,ChessBoard chessBoard){
        boolean [][] mat =  chessBoard.getBoard()[row][column].getPiece().possibleMoves(chessBoard);
        chessBoard.printBoard(mat,row,column);
    }

    public static void start(){
        Scanner sc = new Scanner(System.in);
        ChessBoard chessBoard = new ChessBoard("Ahmad","Ali");
        Position [][] board = chessBoard.getBoard();
        while (!chessBoard.testCheckMate(chessBoard.getTurn())){
//            board[1][0].removePiece();
//            Piece p = board[0][4].removePiece();
//            board[3][4].setPiece(p);
            chessBoard.printBoard();
            System.out.println("Choose a piece to move (" +chessBoard.getTurn()+"): " );
            String nextMove = sc.nextLine();
            int SC = ColumnsConvert(nextMove.charAt(0));
            int SR =Character.getNumericValue(nextMove.charAt(1))-1;
            if(board[SR][SC].getPiece() != null && board[SR][SC].getPiece().getColor() == chessBoard.getTurn())
                printPossibleMoves(SR,SC,chessBoard);
            else
                continue;
            System.out.println("Choose a place to move the piece at (" +chessBoard.getTurn()+"): " );
            nextMove = sc.nextLine();
            int DC = ColumnsConvert(nextMove.charAt(0));
            int DR =Character.getNumericValue(nextMove.charAt(1))-1;
            if(!chessBoard.move(board[SR][SC],board[DR][DC],chessBoard.getTurn()))
                continue;
            chessBoard.printBoard();
            chessBoard.switchTurn();

        }
        System.out.println(chessBoard.opponent().toString()+" Player Win");

    }
}
