package question.medium;

import java.util.Arrays;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-07-29 15:03.
 * @version V1.0
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. 
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 *
 * Example:
 *
 * Input:
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * Output:
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * Follow up:
 *
 * Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 *
 *
 *
 */
public class GameOfLife {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println();

        gameOfLife(board);

        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int columnLen = board.length;
        int rowLen = board[0].length;

        int[][] board1 = new int[columnLen][rowLen];

        for (int i = 0; i < columnLen; i++) {
            for (int j = 0; j < rowLen; j++) {
                int a1 = -1, a2 = -1, a3 = -1, a4 = -1, a5 = -1, a6 = -1, a7 = -1, a8 = -1;
                int oneCOunt = 0;

                try {
                    a1 = board[i - 1][j - 1];
                } catch (Exception e) {

                }

                if (a1 == 1) {
                    ++oneCOunt;
                }

                try {
                    a2 = board[i - 1][j];
                } catch (Exception e) {

                }

                if (a2 == 1) {
                    ++oneCOunt;
                }

                try {
                    a3 = board[i - 1][j + 1];
                } catch (Exception e) {

                }

                if (a3 == 1) {
                    ++oneCOunt;
                }

                try {
                    a4 = board[i][j - 1];
                } catch (Exception e) {

                }

                if (a4 == 1) {
                    ++oneCOunt;
                }

                try {
                    a5 = board[i][j + 1];
                } catch (Exception e) {

                }

                if (a5 == 1) {
                    ++oneCOunt;
                }

                try {
                    a6 = board[i + 1][j - 1];
                } catch (Exception e) {

                }

                if (a6 == 1) {
                    ++oneCOunt;
                }

                try {
                    a7 = board[i + 1][j];
                } catch (Exception e) {

                }

                if (a7 == 1) {
                    ++oneCOunt;
                }

                try {
                    a8 = board[i + 1][j + 1];
                } catch (Exception e) {

                }

                if (a8 == 1) {
                    ++oneCOunt;
                }

                if (board[i][j] == 0 && oneCOunt == 3) {
                    board1[i][j] = 1;
                }

                if (board[i][j] == 1) {
                    if (oneCOunt < 2) {
                        board1[i][j] = 0;
                    } else if (oneCOunt > 3) {
                        board1[i][j] = 0;
                    } else {
                        board1[i][j] = 1;
                    }
                }
            }
        }


        for (int i = 0; i < columnLen; i++) {
            System.arraycopy(board1[i], 0, board[i], 0, rowLen);
        }
    }

    public void gameOfLife1(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                changeBorder(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
            }
        }

    }

    public void changeBorder(int[][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;

        int total = 0; // 这是记录该细胞周围活细胞的数量

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (i >= 0 && i < row && j >= 0 && j < col) {
                    if (board[i][j] > 0) {
                        total++;
                    }
                }
            }
        }
        if (board[x][y] > 0) {
            if (total < 2 || total > 3) {
                board[x][y] = 2;
            }
        }
        if (board[x][y] <= 0 && total == 3) {
            board[x][y] = -1;
        }

    }

}
