package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-07-12 14:19.
 * @version V1.0
 */
public class KdiffPairsInAnArray {

    public static void main(String[] args) {

        int[] nums = new int[]{
                3, 1, 4, 1, 5
        };
        int k = 2;

        System.out.println(findPairs(nums, k));
    }

    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = nums[i];
                int b = nums[j];

                if (Math.abs(a - b) == k) {
                    if (map.isEmpty()) {
                        map.put(a, b);
                    } else {
                        Integer valueA = map.get(a);
                        Integer valueB = map.get(b);

                        if (valueA == null && valueB == null) {
                            map.put(a, b);
                        } else {
                            if (valueA != null && valueA != b) {
                                if (valueB == null) {
                                    map.put( b, a);
                                } else {
                                    if (valueB != a) {
                                        map.put(a, b);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return map.size();
    }


    /**
     * 速度较快的题解
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs1(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int pairCount = 0;
        Arrays.sort(nums);
        int smallIndex = 0;
        int bigIndex = 1;
        while (bigIndex < nums.length) {
            int distance = nums[bigIndex] - nums[smallIndex];
            if (distance < k) {
                bigIndex++;
            } else {
                if (distance == k) {
                    pairCount++;
                    smallIndex = toNextNumber(smallIndex, nums);
                    bigIndex = toNextNumber(bigIndex, nums);
                } else {
                    smallIndex++;
                }
                if (smallIndex == bigIndex) {
                    bigIndex++;
                }
            }
        }
        return pairCount;
    }

    private int toNextNumber(int index, int[] nums) {
        int temp = nums[index];
        while (index < nums.length && nums[index] == temp) {
            index++;
        }
        return index;
    }

}
