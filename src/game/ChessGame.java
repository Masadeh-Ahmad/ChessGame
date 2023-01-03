package game;


import board.ChessBoard;
import board.Position;
import exceptions.ChessException;

import java.nio.charset.CharacterCodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;

import static board.View.printBoard;

public class ChessGame {
    private ChessGame() {
        throw new IllegalStateException("ChessGame class");
    }

    public static int columnsConvert(char x) throws ChessException {
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
                throw new ChessException("Invalid column Character");
        }
    }
    private static void printPossibleMoves(int row,int column,ChessBoard chessBoard){
        boolean [][] mat =  chessBoard.getBoard()[row][column].getPiece().possibleMoves(chessBoard);
        printBoard(mat,row,column,chessBoard);
    }

    public static void start() throws ChessException {
        Scanner sc = new Scanner(System.in);
        ChessBoard chessBoard = new ChessBoard("Ahmad","Ali",30);
        Position [][] board = chessBoard.getBoard();
        Pattern pattern = Pattern.compile("[a-h][1-8]");
        Matcher matcher;
        String nextMove;
        int sourceColumn;
        int sourceRow;
        int destinationColumn;
        int destinationRow;
        while (!chessBoard.testCheckMate(chessBoard.getTurn()) && chessBoard.getNumOfMoves() > 0){
            try{
                printBoard(chessBoard);
                if(chessBoard.testCheck(chessBoard.getTurn()))
                    System.out.println("There is a check");
                System.out.println("Choose a piece to move (" +chessBoard.getTurn()+"): " );
                nextMove = sc.nextLine();
                matcher = pattern.matcher(nextMove);
                if(!matcher.find())
                    throw new ChessException("Invalid input");

                sourceColumn = columnsConvert(nextMove.charAt(0));
                sourceRow =Character.getNumericValue(nextMove.charAt(1))-1;
                if(board[sourceRow][sourceColumn].getPiece() == null)
                    throw new ChessException("There is no piece in this position");
                else if(board[sourceRow][sourceColumn].getPiece().getColor() != chessBoard.getTurn() || !chessBoard.canMove(board[sourceRow][sourceColumn].getPiece()))
                    throw new ChessException("You can't move this piece");
                printPossibleMoves(sourceRow,sourceColumn,chessBoard);

                System.out.println("Choose a place to move the piece at (" +chessBoard.getTurn()+"): " );
                nextMove = sc.nextLine();
                matcher = pattern.matcher(nextMove);
                if(!matcher.find())
                    throw new ChessException("Invalid input");

                destinationColumn = columnsConvert(nextMove.charAt(0));
                destinationRow =Character.getNumericValue(nextMove.charAt(1))-1;
                if(!chessBoard.move(board[sourceRow][sourceColumn],board[destinationRow][destinationColumn],chessBoard.getTurn()))
                    throw new ChessException("You can't move this piece at this location");
                printBoard(chessBoard);
                chessBoard.switchTurn();

            }
            catch (ChessException ex){
                System.out.println(ex.getMessage() + " please try again");
                continue;
            }
        }
        System.out.println(chessBoard.opponent().toString()+" Player Win");

    }
}
