package question.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * question.medium.
 *
 * @author Created by WXG on 2020-06-09 14:17
 * @version V1.0
 *
 * Write a method to return all subsets of a set. The elements in a set are?pairwise distinct.
 *
 * Note: The result set should not contain duplicated subsets.
 *
 * Example:
 *
 *  Input:  nums = [1,2,3]
 *  Output:
 * [
 *   [3],
 * ? [1],
 * ? [2],
 * ? [1,2,3],
 * ? [1,3],
 * ? [2,3],
 * ? [1,2],
 * ? []
 * ]
 *
 */
public class PowerSetLCCI {

    public static void main(String[] args) {
        System.out.println("a");
    }

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }

        if (nums.length == 0) {
            return Collections.singletonList(new ArrayList<>());
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        int size = nums.length;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    for (int l = 0; l < i; l++) {


                    }
                }
            }
        }

        return res;
    }

    /**
     * 链接：https://leetcode-cn.com/problems/power-set-lcci/solution/java-wei-tu-by-1ujin/
     */
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            int bmp = (int) Math.pow(2, nums.length);
            // 从 nums.length 个 0 遍历到 nums.length 个 1
            for (int i = 0; i < bmp; i++) {
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < nums.length; j++)
                    // 将每一位右移最低位，检测其是否为1
                    if ((i >>> j & 1) == 1) subset.add(nums[j]);
                subsets.add(subset);
            }
            return subsets;
        }
    }

    /**
     * 回溯的方法
     */
    class Solution1 {
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> list = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            backtrack(nums, 0, list, res);

            return res;
        }


        private void backtrack(int[] nums, int cur, List<Integer> list, List<List<Integer>> res) {
            res.add(new ArrayList<>(list));
            for (int i = cur; i < nums.length; ++i) {
                list.add(nums[i]);
                backtrack(nums, i + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }


}
