package question.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-07 13:55
 * @version V1.0
 *
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 * Example 2:
 *
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 * Example 3:
 *
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *  
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 *
 */
public class HowManyNumbersAreSmallerThantheCurrentNumber {

    public static void main(String[] args) {
        HowManyNumbersAreSmallerThantheCurrentNumber currentNumber = new HowManyNumbersAreSmallerThantheCurrentNumber();
        System.out.println(Arrays.toString(currentNumber.smallerNumbersThanCurrent(new int[]{
                8, 1, 2, 2, 3
        })));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int len = nums.length;
        List<Integer> cnt = new ArrayList<>(101);
        for (int i = 0; i < 101; i++) {
            cnt.add(0);
        }
        int[] res = new int[len];
        for (int num : nums) {
            cnt.set(num, cnt.get(num) + 1);
        }

        for (int i = 1; i <= 100; ++i) {
            cnt.set(i, cnt.get(i) + cnt.get(i - 1));
        }
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) {
                res[i] = cnt.get(nums[i] - 1);
            }
        }

        return res;
    }

}
