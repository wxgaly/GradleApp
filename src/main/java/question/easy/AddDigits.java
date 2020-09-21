package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-28 14:14
 * @version V1.0
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * ?            Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 *
 */
public class AddDigits {

    public static void main(String[] args) {

    }

    /**
     * 十进制，9份打包
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

}
