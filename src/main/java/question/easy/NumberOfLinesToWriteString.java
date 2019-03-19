package question.easy;

import java.util.Arrays;

/**
 * question.easy.NumberOfLinesToWriteString
 *
 * @author Created by WXG on 2019/3/19 019 15:14.
 * @version V1.0
 * We are to write the letters of a given string S, from left to right into lines. Each line has maximum width 100 units,
 * and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line.
 * We are given an array widths, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ...,
 * and widths[25] is the width of 'z'.
 * <p>
 * Now answer two questions: how many lines have at least one character from S,
 * and what is the width used by the last such line? Return your answer as an integer list of length 2.
 * <p>
 * <p>
 * <p>
 * Example :
 * Input:
 * widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "abcdefghijklmnopqrstuvwxyz"
 * Output: [3, 60]
 * Explanation:
 * All letters have the same length of 10. To write all 26 letters,
 * we need two full lines and one line with 60 units.
 * Example :
 * Input:
 * widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * S = "bbbcccdddaaa"
 * Output: [2, 4]
 * Explanation:
 * All letters except 'a' have the same length of 10, and
 * "bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
 * For the last 'a', it is written on the second line because
 * there is only 2 units left in the first line.
 * So the answer is 2 lines, plus 4 units in the second line.
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of S will be in the range [1, 1000].
 * S will only contain lowercase letters.
 * widths is an array of length 26.
 * widths[i] will be in the range of [2, 10].
 */

public class NumberOfLinesToWriteString {

    public static void main(String[] args) {

        int[] widths = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String S = "abcdefghijklmnopqrstuvwxyz";

        widths = new int[]{11, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10};
        S = "bbbcccdddaaa";

        System.out.println(Arrays.toString(numberOfLines(widths, S)));

    }

    public static int[] numberOfLines(int[] widths, String S) {
        int MAX_WIDTH = 100;
        int[] result = new int[2];
        int lineLen = 1;
        int width = 0;

        char[] chars = S.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (width > MAX_WIDTH) {
                lineLen++;
                i -= 2;
                width = 0;
            } else {
                width += widths[chars[i] - 'a'];
            }
        }

        if (width >= MAX_WIDTH) {
            lineLen++;
            width = widths[chars[len - 1] - 'a'];
        }

        result[0] = lineLen;
        result[1] = width;

        return result;
    }

}
