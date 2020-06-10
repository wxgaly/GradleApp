package question.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * question.medium.
 *
 * @author Created by WXG on 2020-06-10 14:01
 * @version V1.0
 *
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 *
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 *
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 * Example 4:
 *
 * Input: s = "xxyyzz", t = "xxyyzz"
 * Output: 0
 * Example 5:
 *
 * Input: s = "friend", t = "family"
 * Output: 4
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 50000
 * s.length == t.length
 * s and t contain lower-case English letters only.
 *
 *
 */
public class MinimumNumberofStepstoMakeTwoStringsAnagram {

    public static void main(String[] args) {
        MinimumNumberofStepstoMakeTwoStringsAnagram anagram = new MinimumNumberofStepstoMakeTwoStringsAnagram();
        String s = "bab";
        String t = "aba";
        System.out.println(anagram.minSteps(s, t));
    }

    int count = 0;

    public int minSteps(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        getMap(s, sMap);
        getMap(t, tMap);

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {

        }
        tMap.forEach((character, integer) -> {
            Integer sCount = sMap.get(character);
            if (sCount == null) {
                count += integer;
            } else {
                count++;
                sCount--;
                sMap.put(character, sCount);
            }
        });
        return count;
    }

    private void getMap(String s, Map<Character, Integer> map) {
        char[] sChars = s.toCharArray();
        for (char sChar : sChars) {
            Integer integer = map.get(sChar);
            if (integer == null) {
                map.put(sChar, 1);
            } else {
                integer++;
                map.put(sChar, integer);
            }
        }
    }

    public int minSteps1(String s, String t) {
        int[] s_cnt = new int[26];
        int[] t_cnt = new int[26];
        for (char c : s.toCharArray())
            ++s_cnt[c - 'a'];
        for (char c : t.toCharArray())
            ++t_cnt[c - 'a'];
        int ans = 0;
        for (int i = 0; i != 26; ++i)
            if (s_cnt[i] < t_cnt[i])
                ans += t_cnt[i] - s_cnt[i];
        return ans;
    }

}
