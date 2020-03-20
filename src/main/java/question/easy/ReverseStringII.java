package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-20 14:01
 * @version V1.0
 *
 * Given a string and an integer k,
 * you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 *
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 *
 */
public class ReverseStringII {

    public static void main(String[] args) {

    }

    public String reverseStr(String s, int k) {
        int length = s.length();
        if (length < k) {
            return new StringBuilder(s).reverse().toString();
        } else if (length < 2 * k) {
            int index = 0;
            StringBuilder sb = new StringBuilder();

        } else {

        }
        return null;
    }

    public String reverseStr1(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

}
