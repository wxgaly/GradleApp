package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-01-14 19:40
 * @version V1.0
 * <p>
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 * <p>
 * Consider each adjacent pair?of elements [a, b] = [nums[2*i], nums[2*i+1]]?(with i >= 0).?
 * For each such pair, there are a elements with value b in the decompressed list.
 * <p>
 * Return the decompressed list.
 * <p>
 * ?
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * ?
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class DecompressRunLengthEncodedList {

    public static void main(String[] args) {
        DecompressRunLengthEncodedList decompressRunLengthEncodedList = new DecompressRunLengthEncodedList();
        System.out.println(Arrays.toString(decompressRunLengthEncodedList.decompressRLElist(new int[]{
                1, 2, 3, 4
        })));
    }

    /**
     * 执行用时 : 1 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 37.4 MB, 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param nums
     * @return
     */
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        int len = nums.length;
        for (int i = 0; i < len; i = i + 2) {
            size += nums[i];
        }
        int[] res = new int[size];
        int index = 0;
        len = nums.length / 2;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < nums[i * 2]; j++) {
                res[index++] = nums[i * 2 + 1];
            }
        }

        return res;
    }

}
