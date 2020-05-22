package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-22 13:49
 * @version V1.0
 *
 * Count the number of segments in a string,
 * where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 *
 *
 */
public class NumberofSegmentsinaString {

    public static void main(String[] args) {

    }

    public int countSegments(String s) {

        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int count = 0;

        char[] chars = s.toCharArray();
        //先不考虑连续空格问题
        for (char aChar : chars) {
            if (aChar == ' ') {
                count++;
            }
        }

        return count + 1;
    }

    public int countSegments1(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }


}
