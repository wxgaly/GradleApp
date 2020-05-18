package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-18 13:57
 * @version V1.0
 *
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order.
 *
 * Initially the number of elements in A and B are m and n respectively.
 *
 * Example:
 *
 * Input:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 *
 */
public class SortedMergeLCCI {

    public static void main(String[] args) {
        SortedMergeLCCI sortedMergeLCCI = new SortedMergeLCCI();
        int[] A = new int[]{
                1, 2, 3, 0, 0, 0
        };
        int m = 3;
        int n = 3;
        int[] B = new int[]{
                2, 5, 6
        };
        sortedMergeLCCI.merge(A, m, B, n);
    }

    public void merge(int[] A, int m, int[] B, int n) {
        int len = m + n;
        int[] temp = new int[A.length];
        for (int i = 0, j = 0, index = 0; index < len; index++) {
            if (j < n) {
                if (i < m) {
                    if (A[i] < B[j]) {
                        temp[index] = A[i];
                        i++;
                    } else {
                        temp[index] = B[j];
                        j++;
                    }
                } else {
                    temp[index] = B[j];
                    j++;
                }
            } else {
                temp[index] = A[i];
                i++;
            }
        }
        System.arraycopy(temp, 0, A, 0, len);
        System.out.println(Arrays.toString(A));
    }

    /**
     * 逆向双指针
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge1(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (B[j] >= A[i]) {
                A[i + j + 1] = B[j--];
            } else {
                A[i + j + 1] = A[i--];
            }
        }
        while (j >= 0) {
            A[j] = B[j--];
        }
    }

}
