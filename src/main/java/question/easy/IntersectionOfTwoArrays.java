package question.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-13 14:05.
 * @version V1.0
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};

        nums1 = new int[]{
                4, 9, 5
        };

        nums2 = new int[]{
                9, 4, 9, 8, 4
        };

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();

        for (int i : nums1) {
            for (int i1 : nums2) {
                if (i == i1) {
                    set.add(i);
                }
            }
        }
        int[] nums = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            nums[i] = integer;
            i++;
        }

        return nums;
    }

}
