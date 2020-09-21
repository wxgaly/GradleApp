package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-15 14:39.
 * @version V1.0
 * <p>
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is
 * that adjacent houses have security system connected and it will
 * automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * ?            Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * ?            Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    public static void main(String[] args) {

        int[] nums = new int[]{
                1, 2, 3, 1
        };

        nums = new int[]{
                2, 7, 9, 3, 1
        };

        System.out.println(rob(nums));
    }

    /**
     * ����������������������ݣ��������������뵽��ż��������ⷨ���Ǵ���������
     * <p>
     * ��������������sumOdd �� sumEven �ֱ�������������ż��Ԫ����͡�
     * ���Ƚ���������˭����˭�������Ž⡣
     *
     * @return
     */
    public static int rob(int[] nums) {

        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sumEven += nums[i];
                sumEven = Math.max(sumOdd, sumEven);
            } else {
                sumOdd += nums[i];
                sumOdd = Math.max(sumOdd, sumEven);
            }
        }
        return Math.max(sumOdd, sumEven);
    }


}
