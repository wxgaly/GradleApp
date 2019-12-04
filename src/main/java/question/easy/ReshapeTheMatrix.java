package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-12-04 10:05
 * @version V1.0
 *
 * n MATLAB, there is a very useful function called 'reshape',
 * which can reshape a matrix into a new one with different size but keep its original data.
 *
 * You're given a matrix represented by a two-dimensional array,
 * and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise,
 * output the original matrix.
 *
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 *  [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 *
 *
 */
public class ReshapeTheMatrix {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2},
                {3, 4},
                {5, 6}
        };
        ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();
        int[][] ints = reshapeTheMatrix.matrixReshape(nums, 3, 2);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums[0].length;
        int col = nums.length;
        System.out.println("row: " + row + " --- col: " + col);
        if (col == 0 || (row * col == r * c)) {
            int[][] res = new int[r][c];
            int count = 0;
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < row; j++) {
                    res[count / c][count % c] = nums[i][j];
                    count++;
                }
            }

            return res;
        } else {
            return nums;
        }
    }


}
