package question.easy;

import java.util.Arrays;

/**
 * question.easy.PlusOne
 *
 * @author Created by WXG on 2019/3/20 020 15:06.
 * @version V1.0
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = new int[]{
                4, 3, 2, 1
        };
        digits = new int[]{
                9, 9, 9, 9
        };
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        boolean isS = false;
        for (int i = len - 1; i >= 0; i--) {
            int s = digits[i] + 1;
            if (s >= 10) {
                digits[i] = s % 10;
                isS = true;
            } else {
                digits[i] = s;
                return digits;
            }
        }

        int[] sum = new int[len + 1];
        if (isS) {
            sum[0] = 1;
            System.arraycopy(digits, 0, sum, 1, digits.length);
            digits = sum;
        }
        return digits;

    }

}
