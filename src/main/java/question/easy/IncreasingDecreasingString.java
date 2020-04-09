package question.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-09 15:43
 * @version V1.0
 *
 * Given a string s. You should re-order the string using the following algorithm:
 *
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 *
 * Return the result string after sorting s with this algorithm.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 * Example 2:
 *
 * Input: s = "rat"
 * Output: "art"
 * Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
 * Example 3:
 *
 * Input: s = "leetcode"
 * Output: "cdelotee"
 * Example 4:
 *
 * Input: s = "ggggggg"
 * Output: "ggggggg"
 * Example 5:
 *
 * Input: s = "spo"
 * Output: "ops"
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s contains only lower-case English letters.
 *
 *
 */
public class IncreasingDecreasingString {

    public static void main(String[] args) {

    }

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return s;
    }

    private int checkMin(char[] chars) {
        int index = 0;
        int len = chars.length;
        char temp = chars[0];
        for (int i = 1; i < len; i++) {
            if (temp > chars[i]) {
                index = i;
                temp = chars[i];
            }
        }

        return index;
    }

    public String sortString1(String s) {
        //将字符串按照各字符大小装入TreeMap中，key为字符，value为出现次数
        TreeMap<Character, Integer> params = new TreeMap<>(Comparator.comparingInt(Character::charValue));
        for (char item : s.toCharArray()) {
            if (params.containsKey(item)) {
                params.put(item, params.get(item) + 1);
            } else {
                params.put(item, 1);
            }
        }

        StringBuilder result = new StringBuilder();
        boolean desc = true;
        //由题意知结果字符串为先从小到大筛选各字符排列，然后从大到小筛选排列，然后又从小到大筛选排列，直至全部筛选完
        //故此可利用有序treeMap的higherEntry和lowerEntry方法进行筛选获取
        Map.Entry<Character, Integer> entry = params.firstEntry();
        Map.Entry<Character, Integer> temp = entry;
        while (params.size() > 0) {
            if (entry != null) {
                result.append(entry.getKey());
                if (entry.getValue() > 1) {
                    params.put(entry.getKey(), entry.getValue() - 1);
                } else {
                    params.remove(entry.getKey());
                }
            } else {
                desc = !desc;
            }
            if (desc) {
                entry = (entry != null ? params.higherEntry(entry.getKey()) : params.firstEntry());
            } else {
                entry = (entry != null ? params.lowerEntry(entry.getKey()) : params.lastEntry());
            }

        }
        return result.toString();
    }


}
