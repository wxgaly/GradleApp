package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-10 14:10.
 * @version V1.0
 * <p>
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, 4, 1
        };
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);

        boolean isContain = false;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i + 1 == len) {
                break;
            }
            if (nums[i] == nums[i + 1]) {
                isContain = true;
                break;
            }
        }

        return isContain;
    }

}
