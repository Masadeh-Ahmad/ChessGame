package game;

import board.ChessBoard;
import board.Position;
import exceptions.ChessException;

import java.io.IOException;
import java.util.regex.Pattern;

public abstract class InputHandler {
    protected InputHandler nextHandler = null;
    protected Pattern pattern;
    protected ChessBoard chessBoard;
    protected InputHandler(Pattern pattern, ChessBoard chessBoard){
        this.pattern = pattern;
        this.chessBoard = chessBoard;
    }
    public void setNext(InputHandler nextHandler){
        if(nextHandler == null)
            throw new IllegalArgumentException();
        this.nextHandler = nextHandler;
    }
    public abstract MoveParameter handleInput(String input) throws ChessException, IOException;
    protected int columnsConvert(char x) throws ChessException {
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

}
