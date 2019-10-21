package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-21 14:38
 * @version V1.0
 *
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 *
 *  
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *  
 *
 * Note:
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 *
 *
 */
public class TransposeMatrix {

    public static void main(String[] args) {
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        int[][] A = new int[][]{
                {1, 2, 3}, {4, 5, 6}
        };
        for (int[] ints : A) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println();

        int[][] transpose = transposeMatrix.transpose(A);
        for (int[] ints : transpose) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] AA = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                AA[i][j] = A[j][i];
            }
        }

        return AA;
    }

}
