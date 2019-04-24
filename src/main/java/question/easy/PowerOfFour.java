package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-04-24 15:17.
 * @version V1.0
 * <p>
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * Example 2:
 * <p>
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
    }

    public static boolean isPowerOfFour(int num) {
        return ((num & 0x55555555) != 0) && ((num & (num - 1)) == 0);
    }

}
