package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-25 16:43
 * @version V1.0
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 *
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int[] nums = new int[]{
                1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1
        };
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int num : nums) {
            if (num == 1) {
                temp++;
            } else {
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
            }
        }

        return temp > max ? temp : max;
    }

    /**
     * 以0位分割，每次到0的时候，计算上一次0到本次0的距离，就是1的个数
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        int prev = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(i - prev - 1, max);
                prev = i;
            }
        }
        return Math.max(nums.length - prev - 1, max);
    }

}
