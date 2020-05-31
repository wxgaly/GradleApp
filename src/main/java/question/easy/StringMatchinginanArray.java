package question.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-31 17:00
 * @version V1.0
 *
 * Given an array of string words. Return all strings in words which is substring of another word in any order. 
 *
 * String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
 *
 *  
 *
 * Example 1:
 *
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 * Example 2:
 *
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * Example 3:
 *
 * Input: words = ["blue","green","bu"]
 * Output: []
 *  
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] contains only lowercase English letters.
 * It's guaranteed that words[i] will be unique.
 *
 */
public class StringMatchinginanArray {

    public static void main(String[] args) {

    }

    /**
     * 直接暴力求解
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {

        Set<String> set = new HashSet<>();

        for (String word : words) {
            for (String s : words) {
                if (word.contains(s) && !word.equals(s)) {
                    set.add(s);
                }
            }
        }

        return new ArrayList<>(set);
    }

}
