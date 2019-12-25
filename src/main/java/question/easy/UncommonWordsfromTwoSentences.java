package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-12-25 18:53
 * @version V1.0
 *
 * We are given two sentences A and B.  (A sentence is a string of space separated words. 
 * Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words. 
 *
 * You may return the list in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 *
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 *  
 *
 * Note:
 *
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 *
 *
 */
public class UncommonWordsfromTwoSentences {

    public static void main(String[] args) {
        UncommonWordsfromTwoSentences uncommonWordsfromTwoSentences = new UncommonWordsfromTwoSentences();
        String A = "apple apple";
        String B = "banana";
        System.out.println(Arrays.toString(uncommonWordsfromTwoSentences.uncommonFromSentences1(A, B)));
    }

    public String[] uncommonFromSentences(String A, String B) {

        String[] splitA = A.split(" ");
        String[] splitB = B.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String s : splitA) {
            int count = map.getOrDefault(s, 0);
            if (count == 0) {
                map.put(s, 1);
            } else {
                map.put(s, ++count);
            }
        }

        for (String s : splitB) {
            int count = map.getOrDefault(s, 0);
            if (count == 0) {
                map.put(s, 1);
            } else {
                map.put(s, ++count);
            }
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() == 1) {
                list.add(stringIntegerEntry.getKey());
            }
        }

        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public String[] uncommonFromSentences1(String A, String B) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: A.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);
        for (String word: B.split(" "))
            count.put(word, count.getOrDefault(word, 0) + 1);

        List<String> ans = new LinkedList<>();
        for (String word: count.keySet())
            if (count.get(word) == 1)
                ans.add(word);

        return ans.toArray(new String[ans.size()]);
    }


}
