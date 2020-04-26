package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-26 13:44
 * @version V1.0
 *
 * A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index,
 * if one exists, in array A. If not, return -1. If there are more than one magic index, return the smallest one.
 *
 * Example1:
 *
 *  Input: nums = [0, 2, 3, 4, 5]
 *  Output: 0
 * Example2:
 *
 *  Input: nums = [1, 1, 1]
 *  Output: 1
 * Note:
 *
 * 1 <= nums.length <= 1000000
 *
 *
 */
public class MagicIndexLCCI {

    public static void main(String[] args) {

    }

    public int findMagicIndex(int[] nums) {
        int res = -1;
        if (nums == null || nums.length == 0) {
            return res;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                if (nums[mid] >= 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                left = mid + 1;
                res = left - 1;
            }
        }

        return res;
    }

    public int findMagicIndex1(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                if (nums[mid] >= 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

}
