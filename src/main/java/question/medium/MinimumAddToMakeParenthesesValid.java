package question.medium;

import java.util.Stack;

/**
 * question.medium.MinimumAddToMakeParenthesesValid
 *
 * @author Created by WXG on 2019/3/28 028 17:42.
 * @version V1.0
 * <p>
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')',
 * and in any positions ) so that the resulting parentheses string is valid.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "())"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "((("
 * Output: 3
 * Example 3:
 * <p>
 * Input: "()"
 * Output: 0
 * Example 4:
 * <p>
 * Input: "()))(("
 * Output: 4
 * <p>
 * <p>
 * Note:
 * <p>
 * S.length <= 1000
 * S only consists of '(' and ')' characters.
 */

public class MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {

        String S = "()))((";
        S = "())";
        S = "(((";
        S = "()";
        S = ")";

        System.out.println(minAddToMakeValid(S));

    }

    public static int minAddToMakeValid(String S) {

        if (S == null || S.length() == 0) {
            return 0;
        }

        char[] chars = S.toCharArray();

        char beforeBracket = '(';

        Stack<Character> stack = new Stack<>();

        int len = chars.length;

        stack.push(chars[0]);
        for (int i = 1; i < len; i++) {
            if (!stack.isEmpty()) {
                if (chars[i] == ')' && stack.peek() == beforeBracket) {
                    stack.pop();
                } else {
                    stack.push(chars[i]);
                }
            } else {
                stack.push(chars[i]);
            }
        }

        return stack.size();

    }

}
