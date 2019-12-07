package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-12-07 14:54
 * @version V1.0
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 *
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 *  
 *
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * Output: True
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 *
 * Note:
 *
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 *
 * Follow up:
 *
 * What if the matrix is stored on disk,
 * and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
 * What if the matrix is so large that you can only load up a partial row into the memory at once?
 *
 *
 */
public class ToeplitzMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };

        matrix = new int[][]{
                {1, 2},
                {2, 2}
        };
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        System.out.println(toeplitzMatrix.isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix[0].length;
        int col = matrix.length;
        boolean res = true;

        int i = 0;
        int j = 0;
        while (i < row && j < col) {
            int temp = matrix[i][j];
            i++;
            j++;
            if (j < col && i < row) {
                if (temp != matrix[i][j]) {
                    return false;
                }
            }
        }

        i = 0;
        j = 0;

        while (i < row && j < col) {
            int temp = matrix[i][j];
            i++;
            j++;
            if (i < row && j < col) {
                if (temp != matrix[i][j]) {
                    return false;
                }
            }
        }

        return res;
    }


    public boolean isToeplitzMatrix1(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r - 1][c - 1] != matrix[r][c])
                    return false;
        return true;
    }


}
