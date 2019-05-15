package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-05-15 14:09.
 * @version V1.0
 *
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00,
 * a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 *
 * Input: [5,5,5,5]
 * Output: ""
 *
 *
 * Note:
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 *
 */
public class LargestTimeForGivenDigits {

    public static void main(String[] args) {
        int[] A = new int[]{
                2, 0, 6, 6
        };

        System.out.println(largestTimeFromDigits(A));
    }

    /**
     * 最粗暴思路就是4种数字全排列，找到至最大且有效的时间
     *
     * @param A
     * @return
     */
    public static String largestTimeFromDigits(int[] A) {
        if (A == null || A.length != 4) {
            return "";
        }

        String str = "";
        boolean isValid = false;
        for (int i : A) {
            if (i < 5) {
                isValid = true;
                break;
            }
        }

        if (isValid) {
            Arrays.sort(A);
            if (A[0] < 3) {
                for (int i = 1; i < A.length; i++) {
                    if (A[0] < A[i] && A[i] < 3) {
                        int temp = A[i];
                        A[i] = A[0];
                        A[0] = temp;
                    }
                }

                if (A[0] != 2 || A[1] < 4) {
                    for (int i = 2; i < A.length; i++) {
                        if (A[1] < A[i] && (A[0] != 2 || A[i] < 4)) {
                            int temp = A[i];
                            A[i] = A[1];
                            A[1] = temp;
                        }
                    }

                    if (A[0] != 2 || A[2] < 6) {
                        if (A[2] < A[3] && A[3] < 6) {
                            int temp = A[3];
                            A[3] = A[2];
                            A[2] = temp;
                        }

                        return String.valueOf(A[0]) +
                                A[1] +
                                ":" +
                                A[2] +
                                A[3];
                    } else {
                        return str;
                    }
                } else {
                    return str;
                }
            } else {
                return str;
            }
        } else {
            return str;
        }
    }

    public String largestTimeFromDigits1(int[] A) {
        Arrays.sort(A);
        for (int i = 3; i >= 0; i--) {
            if (A[i] > 2) continue;
            for (int j = 3; j >= 0; j--) {
                if (j == i || A[i] == 2 && A[j] > 3) continue;
                for (int k = 3; k >= 0; k--) {
                    if (k == i || k == j || A[k] > 5) continue;
                    return "" + A[i] + A[j] + ':' + A[k] + A[6 - i - j - k];
                }
            }
        }
        return "";
    }

}
