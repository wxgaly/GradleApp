package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-21 14:17.
 * @version V1.0
 * <p>
 * Given an array of integers where 1 ¡Ü a[i] ¡Ü n (n = size of array),
 * some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{
                4, 3, 2, 7, 8, 2, 3, 1
        };

        findDisappearedNumbers(nums).forEach(System.out::println);
    }

    /**
     * ÏÂ±ê¼õÒ»
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int elem;
        for (int i = 0; i < nums.length; i++) {
            elem = nums[i] - 1;
            while (elem < 0) {
                elem += nums.length;
            }
            nums[elem] = nums[elem] - nums.length;
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                ans.add(j + 1);
            }
        }
        return ans;
    }

}
