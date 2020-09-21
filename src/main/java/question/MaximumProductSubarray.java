package question;

/**
 * question.MaximumProductSubarray
 *
 * @author Created by WXG on 2019/3/5 005 16:23.
 * @version V1.0
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

public class MaximumProductSubarray {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, -2, 4, 1, 7};
        System.out.println(maxProduct(nums));

    }

    public static int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //һ���������ģ�һ��������С�ġ�
        for (int num : nums) {
            if (num < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            } //�����������Ǹ�������ô�ᵼ�����ı���С�ģ���С�ı����ġ���˽���������ֵ��
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }
        return max;
    }

}
