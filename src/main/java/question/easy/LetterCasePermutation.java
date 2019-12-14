package question.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-12-14 23:30
 * @version V1.0
 *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string. 
 * Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 * Note:
 *
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 *
 *
 */
public class LetterCasePermutation {

    public static void main(String[] args) {

    }

    public List<String> letterCasePermutation(String S) {
        if (S == null || S.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        String s = S.toLowerCase();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            if (temp >= 'A' && temp <= 'z') {
                if (temp <= 'Z') {
                    result.add(s);
                } else if(temp >= 'a') {

                }


            }
        }

        return result;
    }

    public List<String> letterCasePermutation1(String S) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (char c: S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList<>();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }

}
