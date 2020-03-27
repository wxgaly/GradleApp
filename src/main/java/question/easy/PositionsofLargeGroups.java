package question.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-27 14:06
 * @version V1.0
 *
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *  
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *  
 *
 * Note:  1 <= S.length <= 1000
 *
 *
 */
public class PositionsofLargeGroups {

    public static void main(String[] args) {

    }

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();

        char[] chars = S.toCharArray();
        int len = S.length();
        char temp = chars[0];
        int start = 0;
        for (int i = 1; i < len; i++) {
            if (temp == chars[i]) {
                start = i;
                if (i + 1 < len) {
                    while (temp == chars[i]) {
                        i++;
                    }
                } else {
                    if (i - start >= 3) {
                        List<Integer> pairs = new ArrayList<>();
                        pairs.add(start);
                        pairs.add(i);
                        result.add(pairs);
                    }
                }
            }

        }

        return result;
    }


    public List<List<Integer>> largeGroupPositions1(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N - 1 || S.charAt(j) != S.charAt(j + 1)) {
                // Here, [i, j] represents a group.
                if (j - i + 1 >= 3)
                    ans.add(Arrays.asList(i, j));
                i = j + 1;
            }
        }

        return ans;
    }


}
