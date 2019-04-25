package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-04-25 13:50.
 * @version V1.0
 * <p>
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 * Note:
 * <p>
 * Your solution should be in logarithmic complexity.
 */
public class FindPeakElement {

    public static void main(String[] args) {

    }

    public static int findPeakElement(int[] nums) {
        int index = -1;

        if (nums == null || nums.length == 0) {
            return index;
        }

        if (nums.length == 3) {
            if ((nums[0] < nums[1]) && (nums[1] > nums[2])) {
                return 1;
            }
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if ((nums[start] < nums[start + 1]) && (nums[start + 1] > nums[start + 2])) {
                index = start + 1;
                break;
            }

            if ((nums[end] < nums[end - 1]) && (nums[end - 1] > nums[end - 2])) {
                index = end - 1;
                break;
            }

            start++;
            end--;
        }

        return index;
    }

    /**
     * O(logN)一般考虑二分搜索。有如下规律：
     * <p>
     * 规律一：如果nums[i] > nums[i+1]，则在i之前一定存在峰值元素
     * <p>
     * 规律二：如果nums[i] < nums[i+1]，则在i+1之后一定存在峰值元素
     *
     * @param nums
     * @return
     */
    public int findPeakElement1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
