package question;

/**
 * question.SortColors
 *
 * @author Created by WXG on 2019/3/10 17:36.
 * @version V1.0
 * <p>
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note: You are not suppose to use the library's sort function for this problem.
 * <p>
 * Example:
 * <p>
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 * <p>
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */

public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        nums = new int[]{1, 0};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;

        if (len > 0) {
            int left = 0;
            int right = len - 1;
            int index = 0;
            while (index <= right) {
                if (nums[index] == 0) {
                    int temp = nums[left];
                    nums[left] = nums[index];
                    nums[index] = temp;
                    left++;
                    index++;
                } else if (nums[index] == 2) {
                    int temp = nums[right];
                    nums[right] = nums[index];
                    nums[index] = temp;
                    right--;
                } else {
                    index++;
                }
            }
        }
    }

}
