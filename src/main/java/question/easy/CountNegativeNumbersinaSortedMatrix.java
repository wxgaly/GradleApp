package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-16 15:10
 * @version V1.0
 * <p>
 * Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise. 
 * <p>
 * Return the number of negative numbers in grid.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * Example 2:
 * <p>
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * Example 3:
 * <p>
 * Input: grid = [[1,-1],[-1,-1]]
 * Output: 3
 * Example 4:
 * <p>
 * Input: grid = [[-1]]
 * Output: 1
 *  
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 */
public class CountNegativeNumbersinaSortedMatrix {

    public static void main(String[] args) {

    }

    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int[] ints : grid) {
            int len = ints.length;
            int start = 0;
            int end = len - 1;
            //第一个数小于0，则数组中全为负数
            if (ints[start] < 0) {
                count += len;
                continue;
            }

            //最后一个数大于0，则数组中全为非负数
            if (ints[end] >= 0) {
                continue;
            }

            while (start < end) {
                int mid = (end - start) / 2;
                if (mid < 0) {
                    end = mid;
                } else if (mid > 0) {
                    start = mid;
                } else {
                    break;
                }
            }

            count += end - start;
        }

        return count;
    }

    public int countNegatives1(int[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int count = 0;
        for (int[] ints : grid) {
            int n = ints.length;
            for (int j = n - 1; j >= 0; j--) {
                if (ints[j] < 0)
                    count++;
                else
                    break;
            }
        }
        return count;
    }


}
