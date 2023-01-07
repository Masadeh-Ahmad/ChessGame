package game;

import board.ChessBoard;
import board.Position;
import exceptions.ChessException;

import java.io.IOException;
import java.util.regex.Pattern;

public class DirectMove extends InputHandler{

    public DirectMove(ChessBoard chessBoard){
        super(Pattern.compile("move\\s+[a-h][1-8]\\s*[a-h][1-8]"),chessBoard);
    }
    @Override
    public MoveParameter handleInput(String input) throws ChessException, IOException {
        MoveParameter moveParameter = new MoveParameter();
        if(isDirectMove(input)){
            char [] inputArr = input.replace(" ", "").toCharArray();
            moveParameter.setSourceColumn( columnsConvert(inputArr[4]));
            moveParameter.setSourceRow(Character.getNumericValue(inputArr[5])-1);
            if(chessBoard.getBoard()[moveParameter.getSourceRow()][moveParameter.getSourceColumn()].getPiece() == null)
                throw new ChessException("There is no piece in this position");
            else if(chessBoard.getBoard()[moveParameter.getSourceRow()][moveParameter.getSourceColumn()].getPiece().getColor() != chessBoard.getTurn()
                    || chessBoard.isBlocked(chessBoard.getBoard()[moveParameter.getSourceRow()][moveParameter.getSourceColumn()].getPiece()))
                throw new ChessException("You can't move this piece");
            moveParameter.setDestinationColumn(columnsConvert(inputArr[6]));
            moveParameter.setDestinationRow(Character.getNumericValue(inputArr[7])-1);
            return moveParameter;
        }
        if(nextHandler!=null)
            return nextHandler.handleInput(input);
        else
            throw new ChessException("Invalid input");
    }
    private boolean isDirectMove(String input){
        return pattern.matcher(input).matches();
    }
}
