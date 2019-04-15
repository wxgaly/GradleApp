package question.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * question.easy.BinaryPrefixDivisibleBy5
 *
 * @author Created by WXG on 2019-4-15 18:03.
 * @version V1.0
 * <p>
 * Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number (from most-significant-bit to least-significant-bit.)
 * <p>
 * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,1]
 * Output: [true,false,false]
 * Explanation:
 * The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
 * Only the first number is divisible by 5, so answer[0] is true.
 * Example 2:
 * <p>
 * Input: [1,1,1]
 * Output: [false,false,false]
 * Example 3:
 * <p>
 * Input: [0,1,1,1,1,1]
 * Output: [true,false,false,false,true,false]
 * Example 4:
 * <p>
 * Input: [1,1,1,0,1]
 * Output: [false,false,false,false,false]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 30000
 * A[i] is 0 or 1
 */

public class BinaryPrefixDivisibleBy5 {

    public static void main(String[] args) {
        int[] A = new int[]{
                1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1
        };

        System.out.println(prefixesDivBy5(A).toString());
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        if (A == null || A.length == 0) {
            return list;
        }

        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (sum << 1) + A[i];
            sum = sum % 5;
            list.add(sum == 0);
        }

        return list;
    }

}
