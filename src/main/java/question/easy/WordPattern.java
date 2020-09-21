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
     * ת��һ�ֹ���ͨ��hashmap�ж��ظ���
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
     * ֱ����char��String��ӳ���ϵ
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
            //key�Ѿ���
            if (map.containsKey(tmp)) {
                //����Ӧ��ʧ��
                if (!map.get(tmp).equals(string[i])) return false;
            }
            //key������
            else {
                //����value��ֵһ�� a-dog b-dog->false
                if (map.containsValue(string[i])) return false;
                else
                    //���k-vֵ
                    map.put(tmp, string[i]);
            }
        }
        return true;
    }

}
