package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-05-27 14:01.
 * @version V1.0
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class MaximumSubarray {


    public static void main(String[] args) {
        int[] nums = new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int sum = nums[i];
            if (sum > max) {
                max = sum;
            }
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    /**
     * 求得最优解
     *
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int sum = 0;
        int res = nums[0];
        for (int num : nums) {
            sum = sum > 0 ? sum + num : num;
            if (res < sum) {
                res = sum;
            }
        }
        return res;
    }

}
