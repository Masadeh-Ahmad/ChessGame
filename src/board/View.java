package board;

import game.Color;

public class View {

    private View() {
        throw new IllegalStateException("View class");
    }
    public static void printBoard(ChessBoard chessBoard) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_Yellow ="\u001B[33m";
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (j == 0)
                    System.out.print(i + "  ");
                if (chessBoard.getBoard()[i - 1][j].getPiece() != null) {
                    if (chessBoard.getBoard()[i - 1][j].getPiece().getColor() == Color.WHITE)
                        System.out.print(chessBoard.getBoard()[i - 1][j].getPiece().getIcon() + " | ");
                    else
                        System.out.print(ANSI_Yellow+chessBoard.getBoard()[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
                }
                else
                    System.out.print("- | ");
            }
            System.out.println();
        }
        System.out.println("   a   b   c   d   e   f   g   h");
    }
    public static void printBoard(boolean [][] mat,int r,int c,ChessBoard chessBoard){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[46m";
        final String ANSI_Yellow ="\u001B[33m";
        final String ANSI_RED = "\u001B[31m";
        for (int i = 8; i > 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (j == 0)
                    System.out.print(i + "  ");
                if (chessBoard.getBoard()[i - 1][j].getPiece() != null) {
                    if (chessBoard.getBoard()[i - 1][j].getPiece().getColor() == Color.WHITE){
                        if(i-1 == r && j == c)
                            System.out.print(ANSI_RED+chessBoard.getBoard()[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
                        else {
                            if(mat[i-1][j])
                                System.out.print(ANSI_BLUE+chessBoard.getBoard()[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
                            else
                                System.out.print(chessBoard.getBoard()[i - 1][j].getPiece().getIcon() + " | ");
                        }
                    }
                    else{
                        if(mat[i-1][j])
                            System.out.print(ANSI_Yellow+ANSI_BLUE+chessBoard.getBoard()[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
                        else
                            System.out.print(ANSI_Yellow+chessBoard.getBoard()[i - 1][j].getPiece().getIcon()+ANSI_RESET + " | ");
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
