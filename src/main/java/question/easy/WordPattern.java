package question.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-06-01 13:47
 * @version V1.0
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 *
 *
 */
public class WordPattern {

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();

        String pattern = "abba", str = "dog cat cat dog";
        System.out.println(wordPattern.wordPattern(pattern, str));
    }

    /**
     * 转换一种规则，通过hashmap判断重复项
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {

        StringBuilder sbPattern = new StringBuilder(pattern.length());
        char[] chars = pattern.toCharArray();
        Map<Character, Integer> mapP = new HashMap<>();
        int index = 1;
        for (char aChar : chars) {
            Integer integer = mapP.get(aChar);
            if (integer != null) {
                sbPattern.append(integer);
            } else {
                sbPattern.append(index);
                mapP.put(aChar, index);
                index++;
            }
        }

        String[] s = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sbStr = new StringBuilder();
        int i = 1;
        for (String s1 : s) {
            Integer integer = map.get(s1);
            if (integer != null) {
                sbStr.append(integer);
            } else {
                sbStr.append(i);
                map.put(s1, i);
                i++;
            }
        }
        System.out.println(sbPattern.toString());
        System.out.println(sbStr.toString());

        return sbPattern.toString().equals(sbStr.toString());
    }

    /**
     * 直接做char和String的映射关系
     *
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern1(String pattern, String str) {
        if (pattern == null || str == null) return false;
        String[] string = str.split(" ");
        if (pattern.length() != string.length) return false;
        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char tmp = pattern.charAt(i);
            //key已经在
            if (map.containsKey(tmp)) {
                //不对应就失败
                if (!map.get(tmp).equals(string[i])) return false;
            }
            //key不存在
            else {
                //两个value的值一样 a-dog b-dog->false
                if (map.containsValue(string[i])) return false;
                else
                    //添加k-v值
                    map.put(tmp, string[i]);
            }
        }
        return true;
    }

}
