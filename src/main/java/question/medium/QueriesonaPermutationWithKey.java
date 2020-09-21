package question.medium;

import java.util.Arrays;

/**
 * question.medium.
 *
 * @author Created by WXG on 2020-06-05 13:58
 * @version V1.0
 * <p>
 * Given the array queries of positive integers between 1 and m,
 * you have to process all queries[i] (from i=0 to i=queries.length-1) according to the following rules:
 * <p>
 * In the beginning, you have the permutation P=[1,2,3,...,m].
 * For the current i, find the position of queries[i] in the permutation P (indexing from 0) and then move this at the beginning of the permutation P.
 * ?Notice that the position of queries[i] in P is the result for queries[i].
 * Return an array containing the result for the given queries.
 * <p>
 * ?
 * <p>
 * Example 1:
 * <p>
 * Input: queries = [3,1,2,1], m = 5
 * Output: [2,1,2,1]
 * Explanation: The queries are processed as follow:
 * For i=0: queries[i]=3, P=[1,2,3,4,5], position of 3 in P is 2, then we move 3 to the beginning of P resulting in P=[3,1,2,4,5].
 * For i=1: queries[i]=1, P=[3,1,2,4,5], position of 1 in P is 1, then we move 1 to the beginning of P resulting in P=[1,3,2,4,5].
 * For i=2: queries[i]=2, P=[1,3,2,4,5], position of 2 in P is 2, then we move 2 to the beginning of P resulting in P=[2,1,3,4,5].
 * For i=3: queries[i]=1, P=[2,1,3,4,5], position of 1 in P is 1, then we move 1 to the beginning of P resulting in P=[1,2,3,4,5].
 * Therefore, the array containing the result is [2,1,2,1].
 * Example 2:
 * <p>
 * Input: queries = [4,1,2,2], m = 4
 * Output: [3,1,2,0]
 * Example 3:
 * <p>
 * Input: queries = [7,5,5,8,3], m = 8
 * Output: [6,5,0,7,5]
 * ?
 * <p>
 * Constraints:
 * <p>
 * 1 <= m <= 10^3
 * 1 <= queries.length <= m
 * 1 <= queries[i] <= m
 */
public class QueriesonaPermutationWithKey {

    public static void main(String[] args) {
        QueriesonaPermutationWithKey withKey = new QueriesonaPermutationWithKey();
        int[] queries = new int[]{
                4, 1, 2, 2
        };
        int m = 4;
        System.out.println(Arrays.toString(withKey.processQueries(queries, m)));

    }

    /**
     * 暴力模拟
     * 二分查找竟然出错了。。。
     *
     * @param queries
     * @param m
     * @return
     */
    public int[] processQueries(int[] queries, int m) {
        int len = queries.length;
        int[] res = new int[len];

        int[] mm = new int[m];
        for (int i = 0; i < m; i++) {
            mm[i] = i + 1;
        }

        for (int i = 0; i < len; i++) {
            int index = 0;
            for (int j = 0; j < m; j++) {
                if (mm[j] == queries[i]) {
                    index = j;
                    break;
                }
            }
            res[i] = index;
            int last = mm[index];
            if (index != 0) {
                System.arraycopy(mm, 0, mm, 1, index);
            }
            mm[0] = last;
        }

        return res;
    }

}
