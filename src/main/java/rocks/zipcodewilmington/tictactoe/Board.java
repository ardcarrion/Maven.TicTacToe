package rocks.zipcodewilmington.tictactoe;

import com.sun.org.apache.xpath.internal.operations.Bool;

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
        //Character[] leftDiagonal = new Character[this.board.length];
        //Character[] rightDiagonal = new Character[this.board.length];
        Integer colCount = 0;
        Integer rowCount = 0;
        //Integer diagonalCount = 0;
        String winner;
        for (Character[] row : this.board) {
            winner = winningSet(row);
            if (!winner.equals("")) return winner;
//            for (Character move : row) {
//                cols[rowCount][colCount] = move;
//                //rightDiagonal[diagonalCount] = this.board[colCount][rowCount];
//                colCount++;
//            }
            //winner = winningSet(cols[rowCount]);
            //if (!winner.equals("")) return winner;
            //leftDiagonal[diagonalCount] = this.board[rowCount][colCount];
            colCount = 0;
            //rowCount++;
        }
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
