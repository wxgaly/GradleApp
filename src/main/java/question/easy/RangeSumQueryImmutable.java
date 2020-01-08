package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-01-08 14:13
 * @version V1.0
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 */
public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] nums = new int[]{
                -2, 0, 3, -5, 2, -1
        };
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    static class NumArray {

        private int[] source;

        public NumArray(int[] nums) {
            int len = nums.length;
            source = new int[len];
            System.arraycopy(nums, 0, source, 0, len);
        }

        public int sumRange(int i, int j) {
            int sum = 0;

            if (j >= i && i >= 0 && j < source.length) {
                for (int i1 = i; i1 <= j; i1++) {
                    sum += source[i1];
                }
            }

            return sum;
        }
    }

    static class NumArray1 {

        private int[] sum;

        public NumArray1(int[] nums) {
            sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }

}
