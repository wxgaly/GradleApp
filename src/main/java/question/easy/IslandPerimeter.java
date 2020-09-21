package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-11-06 14:46
 * @version V1.0
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 * ?
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 *
 *
 *
 */
public class IslandPerimeter {

    public static void main(String[] args) {

    }

    /**
     * 题解，由于岛屿内没有湖,所以只需要求出 北面(或南面) + 西面(或东面)的长度再乘2即可
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {

        int sum = 0;
        int length = grid.length;
        int width = grid[0].length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    if (j == 0 || grid[i][j - 1] == 0) {
                        sum += 1;
                    }
                    if (i == 0 || grid[i - 1][j] == 0) {
                        sum += 1;
                    }
                }
            }
        }

        return sum * 2;
    }

}
