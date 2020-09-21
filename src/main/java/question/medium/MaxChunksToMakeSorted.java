package question.medium;

import java.util.Arrays;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-05 13:51.
 * @version V1.0
 * <p>
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
 * we split the array into some number of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.
 * <p>
 * What is the most number of chunks we could have made?
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * Example 2:
 * <p>
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 * Note:
 * <p>
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */
public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        int[] arr = new int[]{
                4, 3, 2, 1, 0
        };
        maxChunksToSorted(arr);
    }

    public static int maxChunksToSorted(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int count = 1;

        if (arr.length == 0) {
            return 1;
        }

        int len = arr.length;

        int[] sortedArr = new int[len];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);

        for (int i = 1; i < len + 1; i++) {

            for (int j = i; j < len; j++) {
                for (int k = j + 1; k < len; k++) {

                }
            }
        }

        return count;
    }

    public int maxChunksToSorted1(int[] arr) {
        int max = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            //记录这个区间的最大值
            max = Math.max(max, arr[i]);
            //最大值等于下标，说明这个区间的数升序排序后刚好等于下标
            if (max == i) {
                result++;
                max = 0;
            }
        }
        return result;
    }

}
