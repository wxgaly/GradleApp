package question.medium;

import java.util.Arrays;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-04-30 15:13.
 * @version V1.0
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 * <p>
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1}, 1));
    }

    public static boolean search(int[] nums, int target) {
        Arrays.sort(nums);

        int index = Arrays.binarySearch(nums, target);

        return index >= 0;
    }

}
