package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-25 14:38
 * @version V1.0
 *
 *
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns. 
 * These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces,
 * and lowercase characters represent black pieces.
 *
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
 * then moves in that direction until it chooses to stop, reaches the edge of the board,
 * or captures an opposite colored pawn by moving to the same square it occupies. 
 * Also, rooks cannot move into the same square as other friendly bishops.
 *
 * Return the number of pawns the rook can capture in one move.
 *
 *  
 *
 * Example 1:
 *
 *
 *
 * Input:
 * [[".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".","R",".",".",".","p"],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * In this example the rook is able to capture all the pawns.
 * Example 2:
 *
 *
 *
 * Input:
 * [[".",".",".",".",".",".",".","."],
 * [".","p","p","p","p","p",".","."],
 * [".","p","p","B","p","p",".","."],
 * [".","p","B","R","B","p",".","."],
 * [".","p","p","B","p","p",".","."],
 * [".","p","p","p","p","p",".","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation:
 * Bishops are blocking the rook to capture any pawn.
 * Example 3:
 *
 *
 *
 * Input:
 * [[".",".",".",".",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * ["p","p",".","R",".","p","B","."],
 * [".",".",".",".",".",".",".","."],
 * [".",".",".","B",".",".",".","."],
 * [".",".",".","p",".",".",".","."],
 * [".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * The rook can capture the pawns at positions b5, d6 and f5.
 *  
 *
 * Note:
 *
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 *
 *
 */
public class AvailableCapturesForRook {

    public static void main(String[] args) {

    }

    public int numRookCaptures(char[][] board) {
        int x = 0, y = 0;
        int xLen = board.length, ylen = board[0].length;
        for (int i = 0; i < xLen; i++) {
            char[] arr = board[i];
            for (int i1 = 0; i1 < ylen; i1++) {
                if (board[i][i1] == 'R') {
                    x = i;
                    y = i1;
                }
            }
        }

        int count = 0;

        //第一种固定y，遍历x，
        if (x == 0) {
            int BIndex = 0;

            for (int i = 1; i < xLen; i++) {
                if (board[i][y] == 'B') {
                    BIndex = i;
                } else if (board[i][y] == 'p') {
                    if (i > BIndex) {
                        count++;
                        break;
                    } else {
                        break;
                    }
                }

            }
        } else if (x == xLen - 1) {
            int BIndex = 0;

            for (int i = xLen - 2; i >= 0; i--) {
                if (board[i][y] == 'B') {
                    BIndex = i;
                } else if (board[i][y] == 'p') {
                    if (i > BIndex) {
                        count++;
                        break;
                    } else {
                        break;
                    }
                }
            }

        } else {
            int BIndex = 0;


        }


        return count;
    }

    public int x(char[][] board) {
        int row = -1, col = -1;
        int count = 0;
        boolean find = false;
        for (row = 0; row < board.length && !find; ++row) {
            for (col = 0; col < board.length && !find; ++col) {
                if (board[row][col] == 'R') find = true;
            }
        }
        --row;
        --col;
        for (int nrow = row - 1; nrow >= 0; --nrow) {
            if (board[nrow][col] == 'p') {
                ++count;
                break;
            }
            if (board[nrow][col] == 'B') break;
        }
        for (int nrow = row + 1; nrow < board.length; ++nrow) {
            if (board[nrow][col] == 'p') {
                ++count;
                break;
            }
            if (board[nrow][col] == 'B') break;
        }
        for (int ncol = col - 1; ncol >= 0; --ncol) {
            if (board[row][ncol] == 'p') {
                ++count;
                break;
            }
            if (board[row][ncol] == 'B') break;
        }
        for (int ncol = col + 1; ncol < board[0].length; ++ncol) {
            if (board[row][ncol] == 'p') {
                ++count;
                break;
            }
            if (board[row][ncol] == 'B') break;
        }
        return count;

    }

}
