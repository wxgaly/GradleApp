package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-01-19 16:26
 * @version V1.0
 *
 * Given a positive integer num consisting only of digits 6 and 9.
 *
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 *  
 *
 * Example 1:
 *
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666. 
 * The maximum number is 9969.
 * Example 2:
 *
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * Example 3:
 *
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 *  
 *
 * Constraints:
 *
 * 1 <= num <= 10^4
 * num's digits are 6 or 9.
 *
 *
 */
public class Maximum69Number {

    public static void main(String[] args) {
        Maximum69Number maximum69Number = new Maximum69Number();
        System.out.println(maximum69Number.maximum69Number(6669));
    }

    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }

        return Integer.valueOf(new String(chars));
    }

}
