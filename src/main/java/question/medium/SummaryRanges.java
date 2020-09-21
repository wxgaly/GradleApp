package question.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * question.medium.SummaryRanges
 *
 * @author Created by WXG on 2019-4-10 13:57.
 * @version V1.0
 * <p>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * <p>
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 * <p>
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */

public class SummaryRanges {

    public static void main(String[] args) {

        int[] nums = new int[]{
                0, 1, 2, 4, 5, 7
        };

        nums = new int[]{
                0, 2, 3, 4, 6, 8, 9
        };

        System.out.println(summaryRanges(nums));

    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> strings = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return strings;
        }

        if (nums.length == 1) {
            strings.add(nums[0] + "");
            return strings;
        }

        int min = nums[0];
        int max = min;

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            if (max + 1 == temp) {
                if (i + 1 == nums.length) {
                    max = temp;
                    if (min == max) {
                        strings.add(min + "");
                    } else {
                        strings.add(min + "->" + max);
                    }
                    break;
                }
                max = temp;
            } else {

                if (min == max) {
                    strings.add(min + "");
                } else {
                    strings.add(min + "->" + max);
                }

                if (i + 1 == nums.length) {
                    if (max < temp) {
                        strings.add(temp + "");
                    }
                    break;
                }
                max = temp;
                min = max;
            }

        }

        return strings;
    }

    /**
     * 思路更清晰一些
     *
     * @param nums
     * @return
     */
    public static List<String> summaryRanges1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 1; ; i++) {
            while (i < nums.length && nums[i - 1] == nums[i] - 1) {
                i++;
            }
            end = i - 1;
            if (nums[start] == nums[end]) {
                list.add("" + nums[start]);
            } else {
                list.add(nums[start] + "->" + nums[end]);
            }
            if (i == nums.length) {
                break;
            }
            start = i;
            end = i;
        }
        return list;
    }

}
