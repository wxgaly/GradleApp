package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-08 15:48
 * @version V1.0
 *
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 * Note:
 * N is a positive integer and won't exceed 10,000.
 * All the scores of athletes are guaranteed to be unique.
 *
 *
 */
public class RelativeRanks {

    public static void main(String[] args) {
        RelativeRanks relativeRanks = new RelativeRanks();
        System.out.println(Arrays.toString(relativeRanks.findRelativeRanks(new int[]{
                5, 4, 3, 2, 1
        })));
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] s = new String[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) max = Math.max(max, nums[i]);
        int[] dp = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = i + 1;
        }
        for (int i = max, flag = 1; i >= 0; i--) {
            if (dp[i] > 0) {
                switch (flag) {
                    case 1:
                        s[dp[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        s[dp[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        s[dp[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        s[dp[i] - 1] = Integer.toString(flag);
                }
                flag++;
            }
        }
        return s;
    }

}
