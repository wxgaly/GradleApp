package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-12 14:44
 * @version V1.0
 * <p>
 * You are given an array of integers (both positive and negative). Find the contiguous sequence with the largest sum. Return the sum.
 * <p>
 * Example:
 * <p>
 * Input:  [-2,1,-3,4,-1,2,1,-5,4]
 * Output:  6
 * Explanation:  [4,-1,2,1] has the largest sum 6.
 * Follow Up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class ContiguousSequenceLCCI {

    public static void main(String[] args) {

    }

    int[] nums;

    public int maxSubArray(int[] nums) {
        this.nums = nums;
        return solve(0, nums.length);
    }

    private int solve(int l, int r) {
        if (l == r - 1) {
            return nums[l];
        }
        int leftSum, rightSum, middleSum;
        int middle = (l + r) >> 1;
        leftSum = solve(l, middle);
        rightSum = solve(middle, r);

        int middleftSum = nums[middle - 1], maxMiddleLeftSum = nums[middle - 1];
        for (int i = middle - 2; i >= l; i--) {
            middleftSum += nums[i];
            if (middleftSum > maxMiddleLeftSum) {
                maxMiddleLeftSum = middleftSum;
            }
        }

        int middleRightSum = nums[middle], maxMiddleRightSum = nums[middle];
        for (int i = middle + 1; i < r; i++) {
            middleRightSum += nums[i];
            if (middleRightSum > maxMiddleRightSum) {
                maxMiddleRightSum = middleRightSum;
            }
        }

        return Math.max(leftSum, Math.max(rightSum, maxMiddleLeftSum + maxMiddleRightSum));
    }


}
