package question.easy;


import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-05-14 14:48.
 * @version V1.0
 *
 * Given a 2D integer matrix M representing the gray scale of an image,
 * you need to design a smoother to make the gray scale of each cell
 * becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 * If a cell has less than 8 surrounding cells, then use as many as you can.
 *
 * Example 1:
 * Input:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * Output:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * Explanation:
 * For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 * For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 * For the point (1,1): floor(8/9) = floor(0.88888889) = 0
 * Note:
 * The value in the given matrix is in the range of [0, 255].
 * The length and width of the given matrix are in the range of [1, 150].
 *
 */
public class ImageSmoother {

    public static void main(String[] args) {

        int[][] M = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] ints = imageSmoother(M);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }

    public static int[][] imageSmoother(int[][] M) {

        if (M == null || M.length == 0) {
            return new int[0][0];
        }

        int len = M.length;
        int len2 = M[0].length;
        int[][] result = new int[len][len2];
        int sum = 0;
        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len2; j++) {
                sum = 0;
                count = 0;
                int current = M[i][j];
                sum += current;
                count++;

                //第一个点
                if ((i - 1 >= 0) && (j - 1 >= 0)) {
                    sum += M[i - 1][j - 1];
                    count++;
                }

                if ((i - 1 >= 0)) {
                    sum += M[i - 1][j];
                    count++;
                }

                if (j - 1 >= 0) {
                    sum += M[i][j - 1];
                    count++;
                }

                if ((i + 1 < len) && (j - 1 >= 0)) {
                    sum += M[i + 1][j - 1];
                    count++;
                }

                if ((i + 1 < len)) {
                    sum += M[i + 1][j];
                    count++;
                }

                if ((i + 1 < len) && (j + 1 < len2)) {
                    sum += M[i + 1][j + 1];
                    count++;
                }

                if ((j + 1 < len2)) {
                    sum += M[i][j + 1];
                    count++;
                }

                if ((i - 1 >= 0) && (j + 1 < len2)) {
                    sum += M[i - 1][j + 1];
                    count++;
                }

                result[i][j] = (int) Math.floor(sum / count);
            }
        }

        return result;
    }

}
