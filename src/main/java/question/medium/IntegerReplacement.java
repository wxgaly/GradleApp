package question.medium;

/**
 * question.medium.IntegerReplacement
 *
 * @author Created by WXG on 2019/3/21 021 15:37.
 * @version V1.0
 *
 * Given a positive integer n and you can do operations as follow:
 *
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 *
 * Example 1:
 *
 * Input:
 * 8
 *
 * Output:
 * 3
 *
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * Example 2:
 *
 * Input:
 * 7
 *
 * Output:
 * 4
 *
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 */

public class IntegerReplacement {

    public static void main(String[] args) {
        int n = 11;
        System.out.println(integerReplacement(n));
    }

    public static int integerReplacement(int n) {

        if (n == Integer.MAX_VALUE) {
            return 32;
        }

        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }

        long l = 1 + integerReplacement(n - 1);
        long r = 1 + integerReplacement(n + 1);

        return (int) (l < r ? l : r);

    }

}
