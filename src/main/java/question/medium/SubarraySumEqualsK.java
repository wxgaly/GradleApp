package question.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-07-02 14:22.
 * @version V1.0
 *
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 *
 *
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] nums = new int[]{
                1, 1, 1
        };

        System.out.println(subarraySum(nums, 1));

    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        // k - k == 0
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            // 检查是否存在 sum[j] + k == sum[i]
            int pSum = sum - k;
            if (map.containsKey(pSum)) {
                ans += map.get(pSum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}
