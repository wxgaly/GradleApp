package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-09 14:03
 * @version V1.0
 *
 * Given a paragraph?and a list of banned words, return the most frequent word that is not in the list of banned words.?
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.?
 * Words in the paragraph are not case sensitive.? The answer is in lowercase.
 *
 * ?
 *
 * Example:
 *
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * ?
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph?may have?uppercase symbols,
 * and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 *
 *
 */
public class MostCommonWord {

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{
                "hit"
        };
        System.out.println(mostCommonWord.mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String s = paragraph.toLowerCase();
        String[] strings = s.split(" ");
        Set<String> set = new HashSet<>();
        Collections.addAll(set, banned);
        Map<String, Integer> map = new HashMap<>();
        int max = -1;
        String result = strings[0];
        for (String string : strings) {
            if (!set.contains(string)) {
                //需要增加模糊匹配
                Integer count = map.getOrDefault(string, 0);
                if (count == 0) {
                    map.put(string, 1);
                } else {
                    count++;
                    if (count > max) {
                        max = count;
                        result = string;
                    }
                    map.put(string, count);
                }
            }
        }
        return result;
    }

    public String mostCommonWord1(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet<>();
        Collections.addAll(banset, banned);
        Map<String, Integer> count = new HashMap<>();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }


}
