package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-12 16:37.
 * @version V1.0
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 *
 *
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 0, 1
        };

        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        int num = -1;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                num = i;
                break;
            }
        }

        if (num == -1) {
            num = len;
        }

        return num;
    }

}
