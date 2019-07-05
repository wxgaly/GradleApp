package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-07-05 15:16.
 * @version V1.0
 *
 * Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed. 
 * For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example,
 * inverting [0, 1, 1] results in [1, 0, 0].
 *
 * Example 1:
 *
 * Input: [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 *
 * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Notes:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 *
 */
public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        A = new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };

        for (int[] ints : A) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println();
        flipAndInvertImage(A);
        System.out.println();

        for (int[] ints : A) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return new int[0][0];
        }

        //水平翻转
        for (int[] ints : A) {
            int len = ints.length;
            int[] old = new int[len];
            for (int i = ints.length - 1, j = 0; i >= 0; i--, j++) {
                old[j] = ints[i];
            }
            System.arraycopy(old, 0, ints, 0, len);
        }

//        for (int[] ints : A) {
//            System.out.println(Arrays.toString(ints));
//        }

        //反转图片
        for (int[] ints : A) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = ints[i] == 0 ? 1 : 0;
            }
        }

        return A;
    }

    /**
     * 左右指针交换，完成水平翻转，
     * 1- 完成反转图片
     *
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage1(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int left = 0;
            int right = A[0].length - 1;
            while (left < right) {
                int temp = A[i][left];
                A[i][left] = 1 - A[i][right];
                A[i][right] = 1 - temp;
                left++;
                right--;
            }
            if (left == right) A[i][left] = 1 - A[i][left];
        }
        return A;
    }

}
