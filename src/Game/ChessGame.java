package Game;


import board.ChessBoard;
import board.Position;

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
    public static void start(){
        Scanner sc = new Scanner(System.in);
        ChessBoard chessBoard = new ChessBoard("Ahmad","Ali");
        Position [][] board = chessBoard.getBoard();
        while (!chessBoard.testCheckMate(chessBoard.getTurn())){
            board[1][0].removePiece();
            chessBoard.printBoard();
            System.out.println("Enter next move (" +chessBoard.getTurn()+"): " );
            String nextMove = sc.nextLine();
            int c = ColumnsConvert((char)nextMove.charAt(0));
            int r =Character.getNumericValue(nextMove.charAt(1))-1 ;
            boolean [][] mat =  board[r][c].getPiece().possibleMoves(chessBoard);
            chessBoard.printBoard(mat,r,c);
            break;


        }
        System.out.println(chessBoard.opponent().toString()+" Player Win");

    }
}
