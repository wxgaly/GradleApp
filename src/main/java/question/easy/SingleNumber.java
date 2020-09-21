package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 * <p>
 * 剑指offer面试题， hash， 排序， 异或
 *
 * @author Created by WXG on 2019-05-31 14:49.
 * @version V1.0
 * <p>
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 0, 1
        };

        System.out.println(singleNumber(nums));
    }

    /**
     * 排序的方式， 时间复杂度O(nlogn), 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int value = Integer.MIN_VALUE;

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i + 1 < len) {
                if (nums[i] == nums[i + 1]) {
                    i++;
                } else {
                    value = nums[i];
                    break;
                }
            }
        }

        if (value == Integer.MIN_VALUE) {
            value = nums[len - 1];
        }

        return value;
    }

    /**
     * 使用异或的方式， 时间复杂度O(n), 空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public int singNumber1(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

}
