package question.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * question.medium.
 *
 * @author Created by WXG on 2020-06-07 16:41
 * @version V1.0
 *
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x),
 * we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters:
 * every letter maps to another letter, and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern. 
 *
 * You may return the answer in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 *  
 *
 * Note:
 *
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 *
 */
public class FindandReplacePattern {

    public static void main(String[] args) {

        String[] words = new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        FindandReplacePattern findandReplacePattern = new FindandReplacePattern();
        for (String s : findandReplacePattern.findAndReplacePattern(words, pattern)) {
            System.out.println(s);
        }
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (wordPattern(pattern, word)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        if (pattern.length() != str.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char tmp = pattern.charAt(i);
            //key已经在
            if (map.containsKey(tmp)) {
                //不对应就失败
                if (!map.get(tmp).equals(str.charAt(i))) return false;
            }
            //key不存在
            else {
                //两个value的值一样 a-dog b-dog->false
                if (map.containsValue(str.charAt(i))) return false;
                else
                    //添加k-v值
                    map.put(tmp, str.charAt(i));
            }
        }
        return true;
    }


    /**
     * 官方题解，双映射表
     */
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> ans = new ArrayList();
            for (String word: words)
                if (match(word, pattern))
                    ans.add(word);
            return ans;
        }

        public boolean match(String word, String pattern) {
            Map<Character, Character> m1 = new HashMap();
            Map<Character, Character> m2 = new HashMap();

            for (int i = 0; i < word.length(); ++i) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);
                if (!m1.containsKey(w)) m1.put(w, p);
                if (!m2.containsKey(p)) m2.put(p, w);
                if (m1.get(w) != p || m2.get(p) != w)
                    return false;
            }

            return true;
        }
    }

}
