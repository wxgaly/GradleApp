package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-06 13:57
 * @version V1.0
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 *
 *
 */
public class LengthofLastWord {

    public static void main(String[] args) {

    }

    /**
     * 从右向左遍历，遇到第一个空格开始计数，再遇到下一个空格结束计数
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) continue;
                break;
            }
            count++;
        }
        return count;
    }

}
