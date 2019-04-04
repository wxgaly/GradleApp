package question.hard;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * question.hard.LongestConsecutiveSequence
 *
 * @author Created by WXG on 2019-4-4 13:52.
 * @version V1.0
 * <p>
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = new int[]{
                100, 4, 200, 1, 3, 2
        };

        nums = new int[]{
                9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6
        };

        System.out.println(longestConsecutive1(nums));
    }

    public static int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 1;
        int temp = 1;

        Iterator<Integer> iterator = set.iterator();
        int pre = iterator.next();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (pre + 1 == next) {
                temp++;
                if (temp > max) {
                    max = temp;
                }
            } else {
                temp = 1;
            }
            pre = next;
        }
        return max;
    }

    public static int longestConsecutive1(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 1;
        int temp = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre + 1 == nums[i]) {
                temp++;
                if (temp > max) {
                    max = temp;
                }
            } else {
                if (pre != nums[i]) {
                    temp = 1;
                }
            }
            pre = nums[i];
        }
        return max;
    }

}
