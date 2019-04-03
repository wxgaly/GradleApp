package question.medium;

/**
 * question.medium.DivideTwoIntegers
 *
 * @author Created by WXG on 2019/4/3 003 14:57.
 * @version V1.0
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication,
 * division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * <p>
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 231 − 1 when the division result overflows.
 */

public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) < 0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {//找出足够大的数2^n*divisor
                result += 1 << i;//将结果加上2^n
                t -= d << i;//将被除数减去2^n*divisor
            }
        }
        return negative ? -result : result;//符号相异取反
    }

}
