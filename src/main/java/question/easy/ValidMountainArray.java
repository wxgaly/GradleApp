package question.easy;

/**
 * question.easy.ValidMountainArray
 *
 * @author Created by WXG on 2019/4/14 18:55.
 * @version V1.0
 * <p>
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * <p>
 * Recall that A is a mountain array if and only if:
 * <p>
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1]
 * Output: false
 * Example 2:
 * <p>
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 * <p>
 * Input: [0,3,2,1]
 * Output: true
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */

public class ValidMountainArray {

    public static void main(String[] args) {

        int[] A = new int[]{
                0, 1, 2, 1
        };

        System.out.println(validMountainArray(A));
    }

    public static boolean validMountainArray(int[] A) {

        boolean ret = false;

        if (A == null || A.length < 3) {
            return ret;
        }

        int start = 0;

        //找到最大数
        for (int i = 0; i < A.length; i++) {
            if (i < A.length - 1) {
                if (A[i] >= A[i + 1]) {
                    start = i;
                    ret = true;
                    break;
                }
            }
        }

        //从最大数继续向后遍历，如果有小于等于的情况则不是山脉数组
        for (int i = start; i < A.length; i++) {
            if (i < A.length - 1) {
                if (A[i] <= A[i + 1]) {
                    ret = false;
                    break;
                }
            }
        }

        //如果山顶在数组头或者尾也不算山脉数组
        if (start == 0 || start == A.length - 1) {
            ret = false;
        }

        return ret;
    }

}
