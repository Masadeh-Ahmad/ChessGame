package game;


import board.ChessBoard;
import board.Position;
import exceptions.ChessException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static board.View.printBoard;

public class ChessGame {
    private ChessGame() {
        throw new IllegalStateException("ChessGame class");
    }
    public static void start() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        ChessBoard chessBoard = new ChessBoard(30);
        InputHandler handler1 = new DirectMove(chessBoard);
        InputHandler handler2 = new TowStepMove(chessBoard);
        handler1.setNext(handler2);
        while (!chessBoard.testCheckMate(chessBoard.getTurn()) && chessBoard.getNumOfMoves() > 0){
            try{
                printBoard(chessBoard);
                if(chessBoard.testCheck(chessBoard.getTurn()))
                    System.out.println("There is a check");
                System.out.println("Choose a piece to move (" +chessBoard.getTurn()+"): " );
                MoveParameter moveParameter = handler1.handleInput(reader.readLine());
                if(!moveParameter.isValid())
                    throw new ChessException("You can't move this piece");
                Position [][] board = chessBoard.getBoard();
                if(!chessBoard.move(board[moveParameter.getSourceRow()][moveParameter.getSourceColumn()],
                        board[moveParameter.getDestinationRow()][moveParameter.getDestinationColumn()],chessBoard.getTurn()))
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
