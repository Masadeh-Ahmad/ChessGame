package game;

import board.ChessBoard;
import exceptions.ChessException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import static board.View.printBoard;

public class TowStepMove extends InputHandler {

    public TowStepMove(ChessBoard chessBoard){
        super(Pattern.compile("[a-h][1-8]"),chessBoard);
    }
    @Override
    public MoveParameter handleInput(String input) throws ChessException, IOException {
        MoveParameter moveParameter = new MoveParameter();
        if(isTowStepMove(input)){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            moveParameter.setSourceColumn(columnsConvert(input.charAt(0)));
            moveParameter.setSourceRow(Character.getNumericValue(input.charAt(1))-1);
            if(chessBoard.getBoard()[moveParameter.getSourceRow()][moveParameter.getSourceColumn()].getPiece() == null)
                throw new ChessException("There is no piece in this position");
            else if(chessBoard.getBoard()[moveParameter.getSourceRow()][moveParameter.getSourceColumn()].getPiece().getColor() != chessBoard.getTurn()
                    || chessBoard.isBlocked(chessBoard.getBoard()[moveParameter.getSourceRow()][moveParameter.getSourceColumn()].getPiece()))
                throw new ChessException("You can't move this piece");
            printPossibleMoves(moveParameter.getSourceRow(), moveParameter.getSourceColumn(),chessBoard);
            System.out.println("Choose a place to move the piece at (" +chessBoard.getTurn()+"): " );
            String input2 =reader.readLine();
            if(!isTowStepMove(input2))
                throw new ChessException("Invalid input");
            moveParameter.setDestinationColumn(columnsConvert(input2.charAt(0)));
            moveParameter.setDestinationRow(Character.getNumericValue(input2.charAt(1))-1);
            return moveParameter;
        }
        if(nextHandler!=null)
            return nextHandler.handleInput(input);
        else
            throw new ChessException("Invalid input");
    }
    private void printPossibleMoves(int row,int column,ChessBoard chessBoard){
        boolean [][] mat =  chessBoard.getBoard()[row][column].getPiece().possibleMoves(chessBoard);
        printBoard(mat,row,column,chessBoard);
    }
    private boolean isTowStepMove(String input){
        return pattern.matcher(input).matches();
    }
}
