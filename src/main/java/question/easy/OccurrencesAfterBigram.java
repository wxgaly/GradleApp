package question.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-01-06 14:36
 * @version V1.0
 * <p>
 * Given words first and second, consider occurrences in some text of the form "first second third",
 * where second comes immediately after first, and third comes immediately after second.
 * <p>
 * For each such occurrence, add "third" to the answer, and return the answer.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 * Output: ["girl","student"]
 * Example 2:
 * <p>
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 *  
 * <p>
 * Note:
 * <p>
 * 1 <= text.length <= 1000
 * text consists of space separated words, where each word consists of lowercase English letters.
 * 1 <= first.length, second.length <= 10
 * first and second consist of lowercase English letters.
 */
public class OccurrencesAfterBigram {

    public static void main(String[] args) {
        OccurrencesAfterBigram occurrencesAfterBigram = new OccurrencesAfterBigram();
//        System.out.println(Arrays.toString(occurrencesAfterBigram.findOcurrences("alice is a good girl she is a good student", "a", "good")));
        System.out.println(Arrays.toString(occurrencesAfterBigram.findOcurrences("we will we will rock you", "we", "will")));
    }

    /**
     * 执行用时 : 1 ms, 在所有 Java 提交中击败了 97.74% 的用户
     * 内存消耗 : 34.7 MB, 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
        String[] texts = text.split(" ");
        List<String> res = new ArrayList<>();

        int len = texts.length;
        for (int i = 0; i < len; i++) {
            if (i + 2 < len) {
                if (texts[i].equals(first) && texts[i + 1].equals(second)) {
                    res.add(texts[i + 2]);
                    i = i + 1;
                }
            }
        }

        int size = res.size();
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            result[i] = res.get(i);
        }

        return result;
    }

}
