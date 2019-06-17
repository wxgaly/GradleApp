package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-17 15:32.
 * @version V1.0
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 * Example:
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 *
 */
public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = new int[]{
                1, 2, 4, 5, 6, 0


        };
        int m = 5;
        int[] nums2 = new int[]{
                3
        };
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1 == null || nums1.length == 0 || m > nums1.length) {
            return;
        }

        if (nums2 == null || nums2.length == 0 || n > nums2.length) {
            return;
        }

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        Arrays.sort(nums1);

    }

}
