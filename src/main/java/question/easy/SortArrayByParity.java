package question.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-14 14:44
 * @version V1.0
 * <p>
 * <p>
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * ?
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * ?
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        SortArrayByParity parity = new SortArrayByParity();
        int[] arr = new int[]{
                3, 1, 2, 4, 5
        };
        System.out.println(Arrays.toString(parity.sortArrayByParity(arr)));
    }

    public int[] sortArrayByParity(int[] A) {
        ArrayList<Integer> oddList = new ArrayList<>();
        ArrayList<Integer> evenList = new ArrayList<>();

        for (int i : A) {
            if (i % 2 == 0) {
                evenList.add(i);
            } else {
                oddList.add(i);
            }
        }

        int[] oddArray = new int[oddList.size()];
        int[] evenArray = new int[evenList.size()];
        for (int i = 0; i < oddList.size(); i++) {
            oddArray[i] = oddList.get(i);
        }
        for (int i = 0; i < evenList.size(); i++) {
            evenArray[i] = evenList.get(i);
        }

        int[] arr = new int[A.length];
        System.arraycopy(evenArray, 0, arr, 0, evenArray.length);
        System.arraycopy(oddArray, 0, arr, evenArray.length, oddArray.length);

        return arr;
    }

    /**
     * 两遍遍历，一次拿奇数，一次拿偶数
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity1(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int value : A)
            if (value % 2 == 0)
                ans[t++] = value;

        for (int value : A)
            if (value % 2 == 1)
                ans[t++] = value;

        return ans;
    }

    /**
     * 一遍遍历，偶数从数组前部放，奇数从数组后部放
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity2(int[] A) {
        int[] ret = new int[A.length];
        int min = 0, max = A.length - 1;
        for (int i : A) {
            if (i % 2 == 0) {
                ret[min++] = i;
            } else {
                ret[max--] = i;
            }
        }
        return ret;
    }

}
