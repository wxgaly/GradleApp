package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-23 17:28
 * @version V1.0
 *
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 *
 *  
 *
 * Example 1:
 *
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *  
 *
 * Note:
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *
 *
 */
public class SortArrayByParityII {

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] A = new int[]{
                4, 2, 6, 5, 7, 9
        };

        System.out.println(Arrays.toString(sortArrayByParityII.sortArrayByParityII(A)));

    }

    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int value : A) {
            if (value % 2 == 0) {
                ans[t] = value;
                t += 2;
            }
        }

        t = 1;
        for (int value : A) {
            if (value % 2 == 1) {
                ans[t] = value;
                t += 2;
            }
        }

        return ans;
    }

    /**
     * 让偶数部分下标 i 之前的所有数都是偶数。为了实现这个目标，把奇数部分作为暂存区，不断增加指向奇数部分的指针，
     * 直到找到一个偶数，然后交换指针 i，j 所指的数。
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII1(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;

                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

        return A;
    }


}
