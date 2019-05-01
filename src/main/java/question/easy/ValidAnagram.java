package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-05-01 14:14.
 * @version V1.0
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "aacc";
        String t = "accc";
        System.out.println(isAnagram(s, t));
    }

    /**
     * 考虑了unicode的可能，但效率太低
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.isEmpty() && t.isEmpty()) {
            return true;
        } else if (s.isEmpty() || t.isEmpty()) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int length = s.length();
        Map<String, Integer> sMap = new HashMap<>();
        List<String> sList = new ArrayList<>();
        List<String> tList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            sList.add(s.substring(i, i + 1));
            tList.add(t.substring(i, i + 1));
        }

        return tList.isEmpty();
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] as = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(as);
        Arrays.sort(ts);
        return Arrays.equals(as, ts);
    }

}
