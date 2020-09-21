package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-29 15:31
 * @version V1.0
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * ?
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 * ?
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 * ?
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 *
 *
 */
public class DetectCapital {

    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        System.out.println(detectCapital.detectCapitalUse("USA"));
        System.out.println(detectCapital.detectCapitalUse("leetcode"));
        System.out.println(detectCapital.detectCapitalUse("Google"));
        System.out.println(detectCapital.detectCapitalUse("FlaG"));
    }

    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (len == 1) {
            return true;
        }

        boolean res = false;

        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            String temp = word.substring(1);
            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                //全部都是大写
                res = temp.equals(temp.toUpperCase());
            } else {
                //除了首字母都是小写
                res = temp.equals(temp.toLowerCase());
            }
        } else {
            //全部都是小写
            res = word.equals(word.toLowerCase());
        }

        return res;
    }

    /**
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse1(String word) {
        int cnt = 0;
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) - 'A' <= 25) {
                cnt++;
                index = i;
            }
        }
        if ((cnt == word.length()) || (cnt == 1 && index == 0) || (cnt == 0)) {
            return true;
        }
        if ((cnt > 1 && cnt < word.length()) || (cnt == 1 && index != 0)) {
            return false;
        }
        return false;
    }

}
