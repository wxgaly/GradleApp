package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-09-26 15:38
 * @version V1.0
 *
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 *
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0,?..., N-1:
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * ?
 *
 * Example 1:
 *
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 *
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 *
 * Input: "DDI"
 * Output: [3,2,0,1]
 * ?
 *
 * Note:
 *
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 *
 *
 */
public class DIStringMatch {

    public static void main(String[] args) {
        DIStringMatch diStringMatch = new DIStringMatch();
        System.out.println(Arrays.toString(diStringMatch.diStringMatch1("DDI")));

    }

    public int[] diStringMatch(String S) {
        int len = S.length() + 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i;
        }

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'I') {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            } else if (aChar == 'D') {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return arr;
    }

    /**
     *
     * 分析
     *
     * 我们首先考虑字符串中的第一个字母。如果 S[0] == 'I'，那么我们只要令 A[0] = 0，就一定能满足 A[0] < A[1]。如果 S[0] == 'D'，
     * 同样我们只要令 A[0] = N，就一定能满足 A[0] > A[1]。
     *
     * 接下来，当我们考虑 S 中剩下的 N - 1 个字母时，还剩下 N 个数可以使用，这 N 个数为 [0 .. N - 1] 或 [1 .. N]。可以发现，
     * 由于 S[0] 的值已经确定，那么剩下 S 中的 N - 1 个字母和 N 个可用的数变成了一个和原问题相同，但规模为 N - 1 的问题。
     * 即如果 S[1] == 'I'，我们就令 A[1] 为剩下数中最小的那个数；如果 S[1] == 'D'，我们就令 A[1] 为剩下数中最大的那个数。
     *
     * 我们每次会把可以使用的数的集合中的最小值或最大值取出，并放到当前的位置，因此可以使用的数的集合总是连续的，就可以非常方便的进行维护。
     *
     * 算法
     *
     * 我们维护当前未使用的最小和最大的数，它们对应的区间为当前未使用的数的集合。从左向右扫描字符串，如果碰到 'I'，就取出当前最小的数，
     * 否则取出当前最大的数。
     *
     *
     *
     * @param S
     * @return
     */
    public int[] diStringMatch1(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }

}
