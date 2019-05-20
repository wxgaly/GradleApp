package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-05-20 17:03.
 * @version V1.0
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only
 * store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {
//        System.out.println(reverse(123));
//        System.out.println(reverse(-123));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        if (x > 0) {
            try {
                return Integer.valueOf(new StringBuilder(Integer.toString(x)).reverse().toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            try {
                return -Integer.parseInt(new StringBuilder(Integer.toString(x * (-1))).reverse().toString());
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }

}
