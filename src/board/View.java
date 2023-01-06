package board;

import game.Color;

public class View {
    private static final String RESET = "\u001B[0m";
    private static final String BLUE_BACKGROUND = "\u001B[46m";
    private static final String YELLOW ="\u001B[33m";
    private static final String RED = "\u001B[31m";
    private View() {
        throw new IllegalStateException("View class");
    }
    private static void printRow(ChessBoard chessBoard,int row){
        Position[] board = chessBoard.getBoard()[row-1];
        for (int i = 0; i < 8; i++) {
            if (i == 0)
                System.out.print(row + "  | ");
            if (board[i].getPiece() != null) {
                if (board[i].getPiece().getColor() == Color.BLACK)
                    System.out.print(YELLOW);
                System.out.print(board[i].getPiece().getIcon());
            }
            else
                System.out.print("-");
            System.out.print(RESET);
            System.out.print(" | ");
            if(i == 7)
                System.out.print(" "+row);
        }
    }
    private static void printRow(ChessBoard chessBoard,boolean [][] mat,int r,int c,int row){
        Position[] board = chessBoard.getBoard()[row-1];
        for (int i = 0; i < 8; i++) {
            if (i == 0)
                System.out.print(row + "  | ");
            if(mat[row-1][i])
                System.out.print(BLUE_BACKGROUND);
            if (board[i].getPiece() != null) {
                if(row-1 == r && i == c)
                    System.out.print(RED);
                else if (board[i].getPiece().getColor() == Color.BLACK)
                    System.out.print(YELLOW);
                System.out.print(board[i].getPiece().getIcon());
                }
            else{
                System.out.print("-");
            }
            System.out.print(RESET);
            System.out.print(" | ");
            if(i == 7)
                System.out.print(" "+row);
        }
    }
    private static void printColumnsCharters(){
        System.out.println("     a   b   c   d   e   f   g   h");
    }
    public static void printBoard(ChessBoard chessBoard) {
        printColumnsCharters();
        for (int i = 8; i > 0; i--) {
            printRow(chessBoard,i);
            System.out.println();
        }
        printColumnsCharters();
    }
    public static void printBoard(boolean [][] mat,int r,int c,ChessBoard chessBoard){
        printColumnsCharters();
        for (int i = 8; i > 0; i--) {
            printRow(chessBoard,mat,r,c,i);
            System.out.println();
        }
        printColumnsCharters();
    }
}
