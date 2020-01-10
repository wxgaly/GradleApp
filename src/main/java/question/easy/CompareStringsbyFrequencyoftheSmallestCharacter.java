package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-01-10 14:49
 * @version V1.0
 *
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s.
 * For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 *
 * Now, given string arrays queries and words, return an integer array answer,
 * where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 *
 *  
 *
 * Example 1:
 *
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * Example 2:
 *
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 *  
 *
 * Constraints:
 *
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters.
 *
 *
 */
public class CompareStringsbyFrequencyoftheSmallestCharacter {

    public static void main(String[] args) {

    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int[] target = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            target[i] = f(words[i]);
        }
        Arrays.sort(target);
        for (int i = 0; i < res.length; i++) {
            int queryCount = f(queries[i]);
            int queryRes = 0;
            for (int j = 0; j < target.length; j++) {
                if (target[j] > queryCount) {
                    queryRes = target.length - j;
                    break;
                }
            }
            res[i] = queryRes;
        }
        return res;
    }
    private int f(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res++;
            if (i != arr.length - 1) {
                if (arr[i] != arr[i + 1]) {
                    break;
                }
            }
        }
        return res;
    }

}
