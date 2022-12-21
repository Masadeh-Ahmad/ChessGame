package Game;


import board.ChessBoard;

import java.util.Scanner;

public class ChessGame {

    public static void start(){
        Scanner sc = new Scanner(System.in);
        ChessBoard board = new ChessBoard();
        board.printBoard();
    }
}
