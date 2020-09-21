package question.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-05 14:09.
 * @version V1.0
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ? n/2 ? times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = new int[]{
                2, 2, 2, 1, 1, 1, 2, 2
        };

        nums = new int[]{
                3, 2, 3
        };

        System.out.println(majorityElement2(nums));
    }

    /**
     * 用map存储
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int result = -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            Integer value = map.get(num);
            if (value != null) {
                map.put(num, ++value);
            } else {
                map.put(num, 1);
            }
        }

        int count = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > count) {
                count = value;
                result = entry.getKey();
            }
        }

        return result;
    }

    /**
     * 用栈存储
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i : nums) {
            if (stack.empty() || i == stack.peek()) {
                stack.push(i);
            } else {
                stack.pop();
            }
        }
        return stack.peek();
    }

    /**
     * 直接遍历，遇见不同减一，相同加一
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        int result = nums[0];
        int count = 1;

        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (result == nums[i])
                count++;
            else {
                count--;
                if (count == 0)
                    result = nums[i + 1];
            }
        }

        return result;
    }

}
