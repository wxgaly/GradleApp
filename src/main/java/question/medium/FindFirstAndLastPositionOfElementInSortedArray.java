package question.medium;

import java.util.Arrays;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-07-15 14:44.
 * @version V1.0
 *
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 3

        };
        int target = 1;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int half = nums.length / 2;
        int len = nums.length;
        int first = -1;
        int last = -1;

        while (half < len && half >= 0) {
            int temp = nums[half];
            if (temp < target) {
                if (half + 1 < len) {
                    if (nums[half + 1] > target) {
                        break;
                    }
                }
                half++;
            } else if (temp > target) {
                if (half - 1 >= 0) {
                    if (nums[half - 1] < target) {
                        break;
                    }
                }
                half--;
            } else {
                if (half + 1 < len) {
                    if (nums[half + 1] == temp) {
                        result[0] = half;
                        result[1] = half + 1;
                    } else {
                        if (half - 1 >= 0) {
                            if (nums[half - 1] == temp) {
                                result[0] = half - 1;
                                result[1] = half;
                            } else {
                                result[0] = half;
                                result[1] = half;
                            }
                        } else {
                            if (nums[half + 1] == temp) {
                                result[0] = half;
                                result[1] = half + 1;
                            } else {
                                result[0] = half;
                                result[1] = half;
                            }
                        }
                    }
                } else {
                    if (half - 1 >= 0) {
                        if (nums[half - 1] == temp) {
                            result[0] = half - 1;
                            result[1] = half;
                        } else {
                            result[0] = half;
                            result[1] = half;
                        }
                    } else {
                        result[0] = half;
                        result[1] = half;
                    }
                }

                break;
            }
        }

        return result;
    }

    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

}
