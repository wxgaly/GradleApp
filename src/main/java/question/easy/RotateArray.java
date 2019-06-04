package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-04 14:14.
 * @version V1.0
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    public static void main(String[] args) {

        int[] nums = new int[]{
                1, 2, 3, 4, 5, 6, 7
        };
        int k = 3;

        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int moveIndex = len - k;
        List<Integer> temp = new ArrayList<>(k);

        for (int i = moveIndex; i < len; i++) {
            temp.add(nums[i]);
        }

        for (int i = 0; i < moveIndex; i++) {
            temp.add(nums[i]);
        }

        for (int i = 0; i < len; i++) {
            nums[i] = temp.get(i);
        }
//        List<Integer> temp = new ArrayList<>();
//        for (int num : nums) {
//            temp.add(num);
//        }
//        Collections.rotate(temp, k);
//        for (int i = 0; i < len; i++) {
//            nums[i] = temp.get(i);
//        }

    }

}
