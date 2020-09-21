package question.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-06 14:44.
 * @version V1.0
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        String s = "abb";
        String t = "cdd";

        System.out.println(isIsomorphic1(s, t));

    }

    public static boolean isIsomorphic(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        boolean isIsomorphic = true;

        Map<Character, Character> map = new HashMap<>();

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int len = schars.length;

        for (int i = 0; i < len; i++) {
            Character value = map.get(schars[i]);
            if (value != null) {
                if (value != tchars[i]) {
                    isIsomorphic = false;
                    break;
                }
            } else {
                map.put(schars[i], tchars[i]);
            }
        }

        if (isIsomorphic) {
            map.clear();
            for (int i = 0; i < len; i++) {
                Character value = map.get(tchars[i]);
                if (value != null) {
                    if (value != schars[i]) {
                        isIsomorphic = false;
                        break;
                    }
                } else {
                    map.put(tchars[i], schars[i]);
                }
            }
        }


        return isIsomorphic;
    }

    /**
     * 判断相同字符所在的位置是否相同
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic1(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i)))
                return false;
        }
        return true;
    }

}
