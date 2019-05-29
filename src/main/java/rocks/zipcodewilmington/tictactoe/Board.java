package rocks.zipcodewilmington.tictactoe;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.ArrayList;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character[][] board;

    public Board(Character[][] matrix) {
        this.board = matrix;
    }

    public Boolean isInFavorOfX() {
        return getWinner().equals("X");
    }

    public Boolean isInFavorOfO() {
        return getWinner().equals("O");
    }

    public Boolean isTie() {
        return getWinner().equals("");
    }

    public String getWinner() {
        
        return "";
    }


    private String winningSet(Character[] moves) {
        int xCount = 0;
        int oCount = 0;
        for (Character move : moves) {
            if (move.equals('X')) xCount++;
            if (move.equals('O')) oCount++;
        }
        if (xCount == this.board.length) return "X";
        if (oCount == this.board.length) return "O";
        return "";
    }

}
