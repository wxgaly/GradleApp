package question.medium;

import java.util.*;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-06-22 15:31.
 * @version V1.0
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 *
 */
public class ThreeSum {

    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> tuples = new ArrayList<>();

        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue; //ȥ��

            int l = i+1, r = nums.length-1;
            if(nums[l] < 0 && Integer.MIN_VALUE-nums[l] > nums[i]) continue; //��������Сֵ������
            if(nums[i] > 0 && Integer.MAX_VALUE-nums[l] < nums[i]) break; //������ֱֵ�ӽ����������ܻ����µ���Ԫ�������

            while(l < r){
                if(nums[r] > -nums[i]-nums[l]){
                    while(l < r && nums[r-1] == nums[r]) r--; //��ָ��ȥ��
                    r--;
                }
                else if(nums[r] < -nums[i]-nums[l]){
                    while(l < r && nums[l+1] == nums[l]) l++; //��ָ��ȥ��
                    l++;
                }
                else{
                    tuples.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l < r && nums[r-1] == nums[r]) r--; //��ָ��ȥ��
                    while(l < r && nums[l+1] == nums[l]) l++; //��ָ��ȥ��
                    r--;
                    l++;
                }
            }
        }
        return tuples;

    }
}
