package question.easy;

import java.util.Stack;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-05-21 15:17.
 * @version V1.0
 * <p>
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("[]("));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Stack<Character> parenthesesStack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                parenthesesStack.push(aChar);
            } else {
                if (!parenthesesStack.isEmpty()) {
                    if (aChar == ')') {
                        if (parenthesesStack.peek() == '(') {
                            parenthesesStack.pop();
                        } else {
                            return false;
                        }
                    } else if (aChar == ']') {
                        if (parenthesesStack.peek() == '[') {
                            parenthesesStack.pop();
                        } else {
                            return false;
                        }
                    } else if (aChar == '}') {
                        if (parenthesesStack.peek() == '{') {
                            parenthesesStack.pop();
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }

        }

        return parenthesesStack.isEmpty();
    }

}
