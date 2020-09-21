package question.easy;


import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-21 23:55
 * @version V1.0
 * <p>
 * Given a non-empty array of non-negative integers nums,
 * the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums,
 * that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeofanArray {

    public static void main(String[] args) {
        DegreeofanArray degreeofanArray = new DegreeofanArray();
        System.out.println(degreeofanArray.findShortestSubArray2(new int[]{
                1, 2, 2, 3, 1, 4, 2
        }));
    }

    /**
     * 执行用时 : 48 ms
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(),
                right = new HashMap<>(), count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }

    public static class NumInfo {
        public int start = -1;
        public int end = -1;
        public int count = 0;

        public NumInfo(int start) {
            this.start = start;
        }
    }

    private int degree = -1;
    private int minLen = -1;

    /**
     * 执行用时 : 18 ms , 在所有 Java 提交中击败了 88.05% 的用户
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray2(int[] nums) {
        Map<Integer, NumInfo> map = new HashMap<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (map.get(num) == null) {
                map.put(num, new NumInfo(i));
            }
            map.get(num).end = i;
            map.get(num).count++;
        }

        map.forEach((key, value) -> {
            if (degree < value.count) {
                degree = value.count;
            }
        });

        minLen = len;
        map.forEach((key, value) -> {
            if (degree == value.count) {
                int infoLen = value.end - value.start + 1;
                if (infoLen < minLen) {
                    minLen = infoLen;
                }
            }
        });

        return minLen;
    }

}
