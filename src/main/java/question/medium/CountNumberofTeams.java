package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2020-06-02 13:53
 * @version V1.0
 * <p>
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 * <p>
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * <p>
 * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 * A team is valid if:  (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: rating = [2,5,3,4,1]
 * Output: 3
 * Explanation: We can form three teams given the conditions. (2,3,4), (5,4,1), (5,3,1).
 * Example 2:
 * <p>
 * Input: rating = [2,1,3]
 * Output: 0
 * Explanation: We can't form any team given the conditions.
 * Example 3:
 * <p>
 * Input: rating = [1,2,3,4]
 * Output: 4
 *  
 * <p>
 * Constraints:
 * <p>
 * n == rating.length
 * 1 <= n <= 200
 * 1 <= rating[i] <= 10^5
 */
public class CountNumberofTeams {

    public static void main(String[] args) {
        CountNumberofTeams countNumberofTeams = new CountNumberofTeams();
        System.out.println(countNumberofTeams.numTeams(new int[]{
                2, 5, 3, 4, 1
        }));
    }

    public int numTeams(int[] rating) {
        int count = 0;

        int len = rating.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * 链接：https://leetcode-cn.com/problems/count-number-of-teams/solution/tong-ji-zuo-zhan-dan-wei-shu-by-leetcode-solution/
     *
     * @return
     */
    public int numTeams1(int[] rating) {
        int n = rating.length;
        int ans = 0;
        // 枚举三元组中的 j
        for (int j = 1; j < n - 1; ++j) {
            int iless = 0, imore = 0;
            int kless = 0, kmore = 0;
            for (int i = 0; i < j; ++i) {
                if (rating[i] < rating[j]) {
                    ++iless;
                }
                // 注意这里不能直接写成 else
                // 因为可能有评分相同的情况
                else if (rating[i] > rating[j]) {
                    ++imore;
                }
            }
            for (int k = j + 1; k < n; ++k) {
                if (rating[k] < rating[j]) {
                    ++kless;
                } else if (rating[k] > rating[j]) {
                    ++kmore;
                }
            }
            ans += iless * kmore + imore * kless;
        }
        return ans;
    }


}
