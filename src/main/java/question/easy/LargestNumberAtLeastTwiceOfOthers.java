package question.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-07-17 14:31.
 * @version V1.0
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 6, 1, 0
        };

        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int index = -1;

        int len = nums.length;
        int maxNum = 0;
        int secondMaxNum = 0;

        for (int i = 0; i < len; i++) {

            if (nums[i] > maxNum) {
                secondMaxNum = maxNum;
                maxNum = nums[i];
                index = i;
            } else {
                if (nums[i] > secondMaxNum) {
                    secondMaxNum = nums[i];
                }
            }
        }

        return index;
    }

}
