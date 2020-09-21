package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-18 14:11.
 * @version V1.0
 *
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 *
 * For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 * OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
 * That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 *
 * Return the length of a maximum size turbulent subarray of A.
 *
 *
 *
 * Example 1:
 *
 * Input: [9,4,2,10,7,8,8,1,9]
 * Output: 5
 * Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
 * Example 2:
 *
 * Input: [4,8,12,16]
 * Output: 2
 * Example 3:
 *
 * Input: [100]
 * Output: 1
 *
 *
 * Note:
 *
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 *
 */
public class LongestTurbulentSubarray {

    public static void main(String[] args) {

        int[] A = new int[]{
                9, 4, 2, 10, 7, 8, 8, 1, 9
        };

        System.out.println(maxTurbulenceSize(A));
    }

    public static int maxTurbulenceSize(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        if (len == 1) {
            return 1;
        } else if (len == 2) {
            return 2;
        }

        int count = 0;
        int max = 0;
        boolean isOver = A[1] > A[0];

        for (int i = 1; i < len; i++) {
            if (A[i] > A[i - 1]) {
                if (isOver) {
                    i--;
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                } else {
                    count++;
                }
                isOver = !isOver;
            } else {
                if (!isOver) {
                    i--;
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                } else {
                    count++;
                }
                isOver = !isOver;
            }
        }

        return max;
    }

    public int num(int[] A) {
        if (A.length == 1) return 1;

        int sum, max = 1;
        long flag = A[1] - A[0];//----------------必须为long！！！
        sum = flag == 0 ? 1 : 2;

        for (int i = 2; i < A.length; i++) {
            long flag2 = A[i] - A[i - 1];//------------------必须为long！！！
            long temp = flag * flag2;

            if (temp < 0) sum++;
            else {//此处可能从来没进去过；固最后返回值时 要判断；
                if (max < sum) max = sum;
                sum = flag2 == 0 ? 1 : 2;
            }
            flag = flag2;
        }
        return max > sum ? max : sum;
    }

}
