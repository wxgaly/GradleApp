package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-08-26 14:28.
 * @version V1.0
 *
 * Given a List of words, return the words that can be typed using letters of alphabet
 * on only one row's of American keyboard like the image below.
 *
 *
 * ?
 * Example:
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * ?
 *
 * Note:
 *
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 * ������Ҫ��˫��forѭ���������ú�����һ��ѭ������
 *
 */
public class KeyboardRow {

    public static void main(String[] args) {
        //
        String[] words = new String[]{
                "Hello", "Alaska", "Dad", "Peace"
        };

        System.out.println(Arrays.toString(findWords1(words)));
    }

    public static String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return words;
        }

        Map<Character, Integer> oneMap = new HashMap<>();
        Map<Character, Integer> twoMap = new HashMap<>();
        Map<Character, Integer> threeMap = new HashMap<>();

        oneMap.put('q', 1);
        oneMap.put('w', 1);
        oneMap.put('e', 1);
        oneMap.put('r', 1);
        oneMap.put('t', 1);
        oneMap.put('y', 1);
        oneMap.put('u', 1);
        oneMap.put('i', 1);
        oneMap.put('o', 1);
        oneMap.put('p', 1);

        twoMap.put('a', 2);
        twoMap.put('s', 2);
        twoMap.put('d', 2);
        twoMap.put('f', 2);
        twoMap.put('g', 2);
        twoMap.put('h', 2);
        twoMap.put('j', 2);
        twoMap.put('k', 2);
        twoMap.put('l', 2);

        threeMap.put('z', 3);
        threeMap.put('x', 3);
        threeMap.put('c', 3);
        threeMap.put('v', 3);
        threeMap.put('b', 3);
        threeMap.put('n', 3);
        threeMap.put('m', 3);

        List<Map<Character, Integer>> maps = new ArrayList<>();
        maps.add(oneMap);
        maps.add(twoMap);
        maps.add(threeMap);

        List<String> list = new ArrayList<>();

        for (String word : words) {
            int length = word.length();
            if (length == 1) {
                list.add(word);
                continue;
            }

            char[] chars = word.toLowerCase().toCharArray();
            int line = 0;
            for (Map<Character, Integer> map : maps) {
                Integer integer = map.get(chars[0]);
                if (integer != null) {
                    line = integer;
                    break;
                }
            }

            boolean same = false;
            for (int i = 1; i < chars.length; i++) {
                for (Map<Character, Integer> map : maps) {
                    Integer integer = map.get(chars[i]);
                    if (integer != null) {
                        same = line == integer;
                        break;
                    }
                }

                if (!same) {
                    break;
                }
            }
            if (same) {
                list.add(word);
            }
        }

        int len = list.size();
        String[] s = new String[len];

        for (int i = 0; i < len; i++) {
            s[i] = list.get(i);
        }

        return s;
    }


    public static String[] findWords1(String[] words) {
        if (words == null) {
            return null;
        }

        List<String> ans = new ArrayList<>();

        // �ֵ���
        String lines[] = new String[]{
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };

        // ��������ƥ���Ƿ���������
        for (String word : words) {
            if (judge(word.toLowerCase(), lines)) {
                ans.add(word);
            }
        }

        // �տ�����ʱ���е��ɻ󷵻�ֵΪʲô����List<String>����String[]
        // list��ֱ������APIת��ΪString���鼴��
        return ans.toArray(new String[ans.size()]);
    }

    private static boolean judge(String word, String[] lines) {
        boolean ok = true;
        String find = null;

        // ����word���ַ�ȷ��������һ��
        for (String line : lines) {
            if (line.indexOf(word.charAt(0)) > -1) {
                find = line;
                break;
            }
        }

        if (find == null) {
            ok = false;
            return ok;
        }

        // �ж�word�ַ��������ַ��Ƿ�����ͬһ��
        for (int i = 1; i < word.length(); i++) {
            if (find.indexOf(word.charAt(i)) < 0) {
                ok = false;
                break;
            }
        }

        return ok;
    }


}
