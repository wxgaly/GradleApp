package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-07-12 13:57.
 * @version V1.0
 *
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 *
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{
                0, 1, 0, 3, 12, 0
        };
        System.out.println(Arrays.toString(nums));
        moveZeroesBest(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 破坏了原有顺序，应该用快慢指针
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] == 0) {
                if (nums[end] == 0) {
                    end--;
                    start--;
                } else {
                    int temp = nums[end];
                    nums[end] = nums[start];
                    nums[start] = temp;
                    end--;
                }
            }
            start++;
        }

    }

    /**
     * 最优解
     *
     * @param nums
     */
    public static void moveZeroesBest(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroFoundAt++, cur);
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
