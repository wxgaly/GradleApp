package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-05-24 14:02.
 * @version V1.0
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 */
public class ImplementstrStr {

    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issip";

        System.out.println(strStr(haystack, needle));
    }

    public static int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return 0;
        }

        if (needle.isEmpty()) {
            return 0;
        }

        if (haystack.isEmpty()) {
            return -1;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        char[] needleChars = needle.toCharArray();
        char[] haysChars = haystack.toCharArray();
        int needLen = needle.length();
        int haysLen = haystack.length();

        int index = -1;
        boolean isFirst = true;

        int i = 0;
        int j = 0;

        while (j < needLen) {
            if (i < haysLen) {
                if (needleChars[j] == haysChars[i]) {
                    if (isFirst) {
                        index = i;
                        isFirst = false;
                    }
                    i++;
                    j++;
                } else {
                    if (!isFirst) {
                        isFirst = true;
                        j = 0;
                        i--;
                    } else {
                        i++;
                    }
                }
            } else {
                break;
            }
        }

        if (j < needLen) {
            return -1;
        }

        return index;
    }

    public static int strStr(String S, String T) {
        if (T == null || T.length() == 0) return 0;
        int[] next = new int[T.length()];
        getNext(T, next);
        int i = 0;
        int j = 0;
        while (i < S.length() && j < T.length()) {
            if (j == -1 || S.charAt(i) == T.charAt(j)) {
                i++;
                j++;
            } else j = next[j];
        }
        if (j == T.length()) return i - j;
        return -1;


    }

    private static void getNext(String t, int[] next) {
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < t.length() - 1) {
            if (j == -1 || t.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

}
