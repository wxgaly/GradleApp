package question.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-07-31 14:35.
 * @version V1.0
 *
 * Given a positive integer n,
 * break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 ×?3 ×?4 = 36.
 *
 *
 *
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        // 接下来就是 n >= 5 的时候的逻辑了
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;

    }

}
