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
        String winner = "";
        Character[] downDiagonal = {board[0][2], board[1][1], board[2][0]};
        winner = winningSet(downDiagonal);
        if (!winner.equals("")) return winner;
        Character[] upDiagonal = {board[0][0], board[1][1], board[2][2]};
        winner = winningSet(upDiagonal);
        if (!winner.equals("")) return winner;
        for (int i = 0; i < board.length; i++) {
            winner = winningSet(board[i]);
            if (!winner.equals("")) return winner;
            Character[] col = new Character[board.length];
            for(int j = 0; j < board.length; j++) {
                col[j] = board[j][i];
            }
            winner = winningSet(col);
            if (!winner.equals("")) return winner;
        }
        return winner;
    }


    private String winningSet(Character[] moves) {
        int xCount = 0;
        int oCount = 0;
        for (Character move : moves) {
            if (move.equals('X')) {
                xCount++;
            } else if (move.equals('O')) {
                oCount++;
            }
        }
        if (xCount == 3) {
            return "X";
        } else if (oCount == 3) {
            return "O";
        }
        return "";
    }

}
