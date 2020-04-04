package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-04 21:04
 * @version V1.0
 *
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 *
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 *
 *
 */
public class PerfectNumber {

    public static void main(String[] args) {

    }

    public int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }

    public boolean checkPerfectNumber(int num) {
        int[] primes = new int[]{2, 3, 5, 7, 13, 17, 19, 31};
        for (int prime : primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;
    }

}
