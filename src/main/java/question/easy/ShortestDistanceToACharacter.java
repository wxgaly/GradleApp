package question.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-09-02 13:56.
 * @version V1.0
 *
 * Given a string S?and a character C, return an array of integers representing the shortest distance
 * from the character C in the string.
 *
 * Example 1:
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * ?
 *
 * Note:
 *
 * S string length is?in?[1, 10000].
 * C?is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 *
 *
 */
public class ShortestDistanceToACharacter {

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';

        System.out.println(Arrays.toString(shortestToChar(S, C)));

    }

    public static int[] shortestToChar(String S, char C) {
        if (S == null || S.isEmpty()) {
            return new int[]{};
        }

        int len = S.length();
        List<Integer> list = new ArrayList<>(len);
        char[] chars = S.toCharArray();
        for (int i = 0; i < len; i++) {
            if (C == chars[i]) {
                list.add(i);
                System.out.println(i);
            }
        }

        System.out.println();
        int[] res = new int[len];

        int size = list.size();

        if (size == 1) {
            int index = list.get(0);
            for (int i = 0; i < len; i++) {
                res[i] = Math.abs(index - i);
            }
        } else {

            int index = 0;
            for (int i = 0; i < size - 1; i++) {
                int i1 = list.get(i);
                int i2 = list.get(i + 1);
                int mid = i1 + (i2 - i1) / 2;

                for (; index < len; index++) {
                    if (index < mid) {
                        res[index] = Math.abs(i1 - index);
                    } else {
                        break;
                    }
                }
            }

        }

        return res;
    }

    /**
     * 从左向右遍历，记录一次距离，再从右向左遍历，比较距离最小的值记录数组即可
     *
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar1(String S, char C) {

        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N-1; i >= 0; --i) {
            if (S.charAt(i) == C) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;


    }

}
