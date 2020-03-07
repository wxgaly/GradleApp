package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-07 14:24
 * @version V1.0
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 *
 *
 */
public class SumofTwoIntegers {

    public static void main(String[] args) {
        SumofTwoIntegers sumofTwoIntegers = new SumofTwoIntegers();
        System.out.println(sumofTwoIntegers.getSum(1, 2));
    }

    public int getSum(int a, int b) {
        int res = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int temp = (res & carry) << 1;
            res ^= carry;
            carry = temp;
        }
        return res;
    }

}
