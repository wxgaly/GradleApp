package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-07-03 14:14.
 * @version V1.0
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 */
public class ReverseWordsInAStringIII {

    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";
        String s1 = "s'teL ekat edoCteeL tsetnoc";

        System.out.println(reverseWords(s).equals(s1));
    }

    public static String reverseWords(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder();

        String[] strings = s.split(" ");

        int len = strings.length;
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strings[i]);
            stringBuilder.append(sb.reverse());
            if (i < len - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

}
