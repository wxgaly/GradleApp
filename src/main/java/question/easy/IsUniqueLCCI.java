package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-18 16:31
 * @version V1.0
 *
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: false
 * Example 2:
 *
 * Input: s = "abc"
 * Output: true
 *  
 *
 * Note:
 *
 * 0 <= len(s) <= 100
 *
 *
 */
public class IsUniqueLCCI {

    public static void main(String[] args) {
        IsUniqueLCCI isUniqueLCCI = new IsUniqueLCCI();
        isUniqueLCCI.isUnique("dd");
    }

    public boolean isUnique(String astr) {
        int len = 'z' - 'A' + 1;
        char[] map = new char[len];
        for (int i = 0; i < len; i++) {
            map[i] = (char) ('A' + i);
        }

        System.out.println(Arrays.toString(map));
        return false;
    }

    public boolean isUnique1(String astr) {
        int[] ASIIs = new int[127];

        for (int i = 0, len = astr.length(); i < len; i++) {
            if (ASIIs[astr.charAt(i)] > 0) {
                return false;
            }
            ASIIs[astr.charAt(i)] = astr.charAt(i);
        }

        return true;
    }


}
