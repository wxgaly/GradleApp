package question.easy;

import java.util.Stack;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-11-13 17:35
 * @version V1.0
 *
 * Balanced?strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string?s?split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 *
 * ?
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 * Example 4:
 *
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 * ?
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 *
 *
 */
public class SplitaStringinBalancedStrings {

    public static void main(String[] args) {
        SplitaStringinBalancedStrings splitaStringinBalancedStrings = new SplitaStringinBalancedStrings();
        System.out.println(splitaStringinBalancedStrings.balancedStringSplit("RLRRRLLRLL"));
    }

    public int balancedStringSplit(String s) {
        int count = 0;

        if (s == null || s.isEmpty()) {
            return count;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        int len = chars.length;
        for (int i = 1; i < len; i++) {
            Character peek = stack.peek();
            if (peek == chars[i]) {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }

            if (stack.isEmpty()) {
                count++;
                if (i + 1 < len) {
                    i++;
                    stack.push(chars[i]);
                }
            }
        }

        return count;
    }

    /**
     * 用数字作为栈的记录，省去栈所占有的空间和时间消耗
     *
     * @param s
     * @return
     */
    public int balancedStringSplit1(String s) {
        int num = 0;
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'L')
                num++;
            else
                num--;
            if (num == 0)
                res++;
        }
        return res;
    }

}
