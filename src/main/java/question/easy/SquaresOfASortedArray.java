package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-09-25 11:13
 * @version V1.0
 * <p>
 * Given an array of integers A?sorted in non-decreasing order,?return an array of the squares of each number,?
 * also in sorted non-decreasing order.
 * <p>
 * ?
 * <p>
 * Example 1:
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * <p>
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * ?
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A?is sorted in non-decreasing order.
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(new int[]{
                -7, -3, 2, 3, 11
        })));
    }

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] * A[i];
        }

        Arrays.sort(result);

        return result;
    }

    /**
     * 双指针法， 正向遍历正值的平方，反向遍历负值的平方
     *
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     *
     * @param A
     * @return
     */
    public int[] sortedSquares1(int[] A) {
        int N = A.length;
        int j = 0;
        while (j < N && A[j] < 0)
            j++;
        int i = j-1;

        int[] ans = new int[N];
        int t = 0;

        while (i >= 0 && j < N) {
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
            } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }

        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }

        return ans;
    }

}
