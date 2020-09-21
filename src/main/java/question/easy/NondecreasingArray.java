package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-03 14:58
 * @version V1.0
 *
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i?(0-based) such that (0?<= i <= n - 2).
 *
 * ?
 *
 * Example 1:
 *
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 *
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * ?
 *
 * Constraints:
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5?<= nums[i] <= 10 ^ 5
 *
 *
 */
public class NondecreasingArray {

    public static void main(String[] args) {

    }

    /**
     * ������������һ�����飬˵���������1���޸�ĳ�����ֵĻ��ᣬ
     * ���ܲ��ܽ������Ϊ�ǵݼ����顣��Ŀ�и�������̫�٣����ܸ���������������������������������ӣ�
     * 4��2��3
     * -1��4��2��3
     * 2��3��3��2��4
     * ����ͨ�����������������ӿ��Է��֣������Ƿ��ֺ��������С��ǰ������ֲ�����ͻ��
     * [1]��ʱ����Ҫ�޸�ǰ��ϴ������(����ǰ����������Ҫ�޸�4)��
     * [2]��ʱ��ȴҪ�޸ĺ����С���Ǹ�����(����ǰ������������Ҫ�޸�2)��
     * ��ô��ʲô���ڹ��������еģ��ж��޸��Ǹ�������ʵ����ǰ��һ�����Ĵ�С�й�ϵ��
     * ���������ǰ����������ڣ���������1��4ǰ��û�������ˣ�����ֱ���޸�ǰ�������Ϊ��ǰ������2���ɡ�
     * ������ǰ������ִ��ڣ�����С�ڵ�ǰ��ʱ����������2��-1С��2�����ǻ�����Ҫ�޸�ǰ�������4Ϊ��ǰ����2��
     * �����ǰ��������ڵ�ǰ������������3��3����2��������Ҫ�޸ĵ�ǰ��2Ϊǰ�����3��
     *
     * https://leetcode-cn.com/problems/non-decreasing-array/comments/59727
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            cnt++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt <= 1;
    }

}
