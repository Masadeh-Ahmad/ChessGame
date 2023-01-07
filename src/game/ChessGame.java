package game;


import board.ChessBoard;
import board.Position;
import exceptions.ChessException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private static int [] inputHandler(String input,ChessBoard chessBoard,BufferedReader reader) throws ChessException, IOException {
        Position [][] board = chessBoard.getBoard();

        int sourceColumn;
        int sourceRow;
        int destinationColumn;
        int destinationRow;

        Pattern pattern1 = Pattern.compile("[a-h][1-8]");
        Pattern pattern2 = Pattern.compile("move\\s+[a-h][1-8]\\s*[a-h][1-8]");
        Matcher matcher1 = pattern1.matcher(input);
        Matcher matcher2 = pattern2.matcher(input);
        if(matcher1.matches()){
            sourceColumn = columnsConvert(input.charAt(0));
            sourceRow =Character.getNumericValue(input.charAt(1))-1;
            if(board[sourceRow][sourceColumn].getPiece() == null)
                throw new ChessException("There is no piece in this position");
            else if(board[sourceRow][sourceColumn].getPiece().getColor() != chessBoard.getTurn() || chessBoard.isBlocked(board[sourceRow][sourceColumn].getPiece()))
                throw new ChessException("You can't move this piece");
            printPossibleMoves(sourceRow,sourceColumn,chessBoard);
            System.out.println("Choose a place to move the piece at (" +chessBoard.getTurn()+"): " );
            matcher1 = pattern1.matcher(reader.readLine());
            if(!matcher1.matches())
                throw new ChessException("Invalid input");

            destinationColumn = columnsConvert(input.charAt(0));
            destinationRow =Character.getNumericValue(input.charAt(1))-1;
        }
        else if(matcher2.matches()){
            char [] inputArr = input.replace(" ", "").toCharArray();
            sourceColumn = columnsConvert(inputArr[4]);
            sourceRow =Character.getNumericValue(inputArr[5])-1;
            if(board[sourceRow][sourceColumn].getPiece() == null)
                throw new ChessException("There is no piece in this position");
            else if(board[sourceRow][sourceColumn].getPiece().getColor() != chessBoard.getTurn() || chessBoard.isBlocked(board[sourceRow][sourceColumn].getPiece()))
                throw new ChessException("You can't move this piece");
            destinationColumn = columnsConvert(inputArr[6]);
            destinationRow = Character.getNumericValue(inputArr[7])-1;
        }
        else
            throw new ChessException("Invalid input");
        return new int[]{sourceRow,sourceColumn,destinationRow,destinationColumn};
    }

    public static void start() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        ChessBoard chessBoard = new ChessBoard(30);
        while (!chessBoard.testCheckMate(chessBoard.getTurn()) && chessBoard.getNumOfMoves() > 0){
            try{
                printBoard(chessBoard);
                if(chessBoard.testCheck(chessBoard.getTurn()))
                    System.out.println("There is a check");
                System.out.println("Choose a piece to move (" +chessBoard.getTurn()+"): " );
                int[] input = inputHandler(reader.readLine(),chessBoard,reader);
                Position [][] board = chessBoard.getBoard();
                if(!chessBoard.move(board[input[0]][input[1]],board[input[2]][input[3]],chessBoard.getTurn()))
                    throw new ChessException("You can't move this piece at this location");
                printBoard(chessBoard);
                chessBoard.switchTurn();
            }
            catch (ChessException | IOException ex) {
                System.out.println(ex.getMessage() + " please try again");
            }
        }
        if(chessBoard.getNumOfMoves() < 1)
            System.out.println("Draw");
        else
            System.out.println(chessBoard.opponent().toString()+" Player Win");

    }
}
