package question.medium;

import java.util.Arrays;

/**
 * question.medium.ThreeSumClosest
 *
 * @author Created by WXG on 2019-4-9 15:31.
 * @version V1.0
 * <p>
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{
                -3, -2, -5, 3, -4
        };

        System.out.println(threeSumClosest1(nums, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;

        if (nums == null || nums.length == 0) {
            return sum;
        }

        if (nums.length <= 3) {
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        sum = nums[0] + nums[1] + nums[2];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 2 < nums.length) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        temp = nums[i] + nums[j] + nums[k];
                        if (Math.abs(temp - target) < Math.abs(sum - target)) {
                            sum = temp;
                        }
                    }
                }
            }
        }

        return sum;
    }

    /**
     * 先排序, 然后遍历, 然后内部使用双指针, 时间复杂度应该是O(n²)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest1(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }

            }

        }

        return closestNum;
    }

}
