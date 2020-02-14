package question.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-14 17:04
 * @version V1.0
 * <p>
 * Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
 * <p>
 * In one shift operation:
 * <p>
 * Element at grid[i][j] moves to grid[i][j + 1].
 * Element at grid[i][n - 1] moves to grid[i + 1][0].
 * Element at grid[m - 1][n - 1] moves to grid[0][0].
 * Return the 2D grid after applying shift operation k times.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * Output: [[9,1,2],[3,4,5],[6,7,8]]
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * Example 3:
 * <p>
 * Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * Output: [[1,2,3],[4,5,6],[7,8,9]]
 *  
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 */
public class Shift2DGrid {

    public static void main(String[] args) {
        Shift2DGrid shift2DGrid = new Shift2DGrid();
        int[][] grid = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        shift2DGrid.shiftGrid(grid, 9);
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m * n;
        int move = k % len;
        System.out.println(move);

        int[] expand = new int[len];
        int index = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                expand[index] = ints[j];
                index++;
            }
        }
        System.out.println(Arrays.toString(expand));

        int i = move / m;
        int j = move / n;
        index = move;
        for (; i < m; i++) {
            for (; j < n; j++) {
                grid[i][j] = expand[index];
            }
            j = 0;
        }


        return new ArrayList<>();
    }

    public List<List<Integer>> shiftGrid1(int[][] grid, int k) {
        // 准备返回的列表
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < grid.length; i++) {
            ret.add(new ArrayList<>());
        }
        //
        k = k % (grid.length * grid[0].length);
        // 如果k是二维数组元素个数的倍数,说明数组没有变化,直接返回
        if (k == 0) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    ret.get(i).add(grid[i][j]);
                }
            }
        }
        // 就像计算时钟时间一样进制计算数组中元素位置
        else {
            int ColumnNum = grid.length;
            int RowNum = grid[0].length;
            // 数组右移几位,开始遍历的时候起始位置就是倒数几位
            int qishi = ColumnNum * RowNum - k;
            int line = qishi / grid[0].length;
            int row = qishi % grid[0].length;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    ret.get(i).add(grid[line][row]);
                    row++;
                    // 进制
                    if (row == RowNum) {
                        row = 0;
                        line++;
                    }
                    if (line == ColumnNum)
                        line = 0;
                }
            }
        }
        return ret;
    }

}
