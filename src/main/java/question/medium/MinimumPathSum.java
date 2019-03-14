package question.medium;

/**
 * question.medium.MinimumPathSum
 *
 * @author Created by WXG on 2019/3/14 014 19:06.
 * @version V1.0
 * <p>
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSum {

    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {

        int rows = grid[0].length, columns = grid.length, minSum = 0;

        int row = 0, col = 0;
        int start = grid[0][0];

        for (int i = 0; i < rows; i++) {
            int sum = onePathSum(i, col, grid);
        }


    }

    private static int onePathSum(int row, int col, int[][] grid) {


    }

}
