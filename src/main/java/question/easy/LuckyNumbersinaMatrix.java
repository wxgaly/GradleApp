package question.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-10 13:51
 * @version V1.0
 * <p>
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 * <p>
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 * Example 2:
 * <p>
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 * <p>
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 *  
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5.
 * All elements in the matrix are distinct.
 */
public class LuckyNumbersinaMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        matrix = new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        matrix = new int[][]{{76618, 42558, 65788, 20503, 29400, 54116}};
        LuckyNumbersinaMatrix luckyNumbersinaMatrix = new LuckyNumbersinaMatrix();
        for (Integer luckyNumber : luckyNumbersinaMatrix.luckyNumbers(matrix)) {
            System.out.println(luckyNumber);
        }
    }

    /**
     * 这种写法当遇见一行或者一列的时候会出现问题
     *
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        int col = matrix[0].length;
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();

        for (int[] ints : matrix) {
            rowList.add(findRowMinIndex(ints));
        }

        for (int j = 0; j < col; j++) {
            colList.add(findColMinIndex(matrix, j));
        }

        rowList.retainAll(colList);

        return rowList;
    }

    private int findRowMinIndex(int[] arr) {
        int min = arr[0];
        for (int i = 1, len = arr.length; i < len; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    private int findColMinIndex(int[][] arr, int col) {
        int max = arr[0][0];
        for (int i = 1, len = arr.length; i < len; i++) {
            if (max < arr[i][col]) {
                max = arr[i][col];
            }
        }
        return max;
    }

    public List<Integer> luckyNumbers1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] min = new int[m];
        int[] max = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                min[i] = Math.min(min[i], matrix[i][j]);// 第i行最小值
                max[j] = Math.max(max[j], matrix[i][j]);// 每一列最大值与当前值比较
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (min[i] == max[j])
                    list.add(min[i]);
            }
        }

        return list;
    }


}
