package question.easy;

import java.util.ArrayList;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-11-14 14:29
 * @version V1.0
 *
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 *  
 *
 * Example 1:
 *
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move. 
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 *  
 *
 * Note:
 *
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 *
 */
public class RemoveAdjacentDuplicatesInString {

    public static void main(String[] args) {
        RemoveAdjacentDuplicatesInString removeAdjacentDuplicatesInString = new RemoveAdjacentDuplicatesInString();
        System.out.println(removeAdjacentDuplicatesInString.removeDuplicates1("abbaca"));
    }

    public String removeDuplicates(String S) {
        if (S == null || S.isEmpty()) {
            return S;
        }

        char[] chars = S.toCharArray();
        int len = chars.length;
        ArrayList<Character> temp = new ArrayList<>();
        boolean hasRepeatChar = false;
        for (int i = 0; i < len; i++) {
            if (i + 1 < len) {
                if (chars[i] == chars[i + 1]) {
                    i += 2;
                    hasRepeatChar = true;
                }
            }

            temp.add(chars[i]);
        }

        String s = "";
        if (hasRepeatChar) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : temp) {
                stringBuilder.append(character);
            }
            s = removeDuplicates(stringBuilder.toString());
        }

        return s;
    }

    /**
     * 利用栈把不相同的元素压入栈，相同的元素从栈中移除
     *
     * @param S
     * @return
     */
    public String removeDuplicates1(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1))
                sb.deleteCharAt(sbLength-- - 1);
            else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

}
