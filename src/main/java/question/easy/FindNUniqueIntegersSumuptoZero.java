package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-01-16 17:00
 * @version V1.0
 * <p>
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: [0]
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 1000
 */
public class FindNUniqueIntegersSumuptoZero {

    public static void main(String[] args) {
        FindNUniqueIntegersSumuptoZero findNUniqueIntegersSumuptoZero = new FindNUniqueIntegersSumuptoZero();
        for (int i = 1; i < 10; i++) {
            System.out.println(Arrays.toString(findNUniqueIntegersSumuptoZero.sumZero(i)));
        }

        for (int i = 1; i < 10; i++) {
            System.out.println(Arrays.toString(findNUniqueIntegersSumuptoZero.sumZero1(i)));
        }

    }

    /**
     * 执行用时 : 0 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 35 MB, 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        }

        int[] arr = new int[n];
        int len = n / 2;
        for (int i = 0; i < len; i++) {
            arr[i] = len - i;
            arr[n - i - 1] = -arr[i];
        }

        if (n % 2 == 1) {
            arr[len] = 0;
        }

        return arr;
    }

    /**
     * 官方题解
     *
     * @param n
     * @return
     */
    public int[] sumZero1(int n) {
        if (n == 1) {
            return new int[]{0};
        }

        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = i;
            sum += i;
        }

        arr[n - 1] = -sum;

        return arr;
    }


}
