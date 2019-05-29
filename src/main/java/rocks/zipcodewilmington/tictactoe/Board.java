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
        Character[][] flatBoard = getFlatBoard();
        for (Character[] set : flatBoard) {
            winner = winningSet(set);
            if (!(winner.equals(""))) return winner;
        }
        return winner;
    }

    private Character[][] getFlatBoard() {
        ArrayList<Character[]> flattened = new ArrayList<Character[]>();
        Character[] downDiagonal = new Character[this.board.length];
        Character[] upDiagonal = new Character[this.board.length];
        int upCount = 0;
        int downCount = this.board.length-1;
        for (int i = 0; i < this.board.length; i++) {
            Character[] col = new Character[this.board.length];
            flattened.add(this.board[i]);
            for (int j = 0; j < this.board.length; j++) {
                col[j] = this.board[i][j];
                if (i == j) {
                    downDiagonal[downCount] = this.board[i][j];
                    upDiagonal[upCount] = this.board[i][j];
                    upCount++;
                    downCount--;
                }
            }
            flattened.add(col);
        }
        flattened.add(upDiagonal);
        flattened.add(downDiagonal);
        Character[][] flat = new Character[flattened.size()][this.board.length];
        return flattened.toArray(flat);
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
        if (xCount == this.board.length) {
            return "X";
        } else if (oCount == this.board.length) {
            return "O";
        }
        return "";
    }

}
