package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-07 14:46
 * @version V1.0
 * <p>
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.?
 * Each digit must be rotated - we cannot choose to leave it alone.
 * <p>
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves;
 * 2 and 5 rotate to each other; 6 and 9 rotate to each other,
 * and the rest of the numbers do not rotate to any other number and become invalid.
 * <p>
 * Now?given a positive number N, how many numbers X from 1 to N are good?
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 * <p>
 * N? will be in range [1, 10000].
 */
public class RotatedDigits {

    public static void main(String[] args) {
        RotatedDigits rotatedDigits = new RotatedDigits();
        System.out.println(rotatedDigits.rotatedDigits(10));
    }

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            String x = String.valueOf(N);
            int len = x.length();
            int j = 1;
            for (; j <= len; j++) {
                if (!isGood(N >> j & 0x01)) {
                    break;
                }
            }
            if (j == len + 1) {
                count++;
            }
        }
        return count;
    }

    private boolean isGood(int n) {
        boolean[] results = new boolean[]{
                false,
                false,
                true,
                false,
                false,
                true,
                true,
                false,
                false,
                true
        };
        return results[n];
    }

    /**
     * 遍历
     *
     * @param N
     * @return
     */
    public int rotatedDigits1(int N) {
        // Count how many n in [1, N] are good.
        int ans = 0;
        for (int n = 1; n <= N; ++n)
            if (good(n, false)) ans++;
        return ans;
    }

    // Return true if n is good.
    // The flag is true iff we have an occurrence of 2, 5, 6, 9.
    public boolean good(int n, boolean flag) {
        if (n == 0) return flag;

        int d = n % 10;
        if (d == 3 || d == 4 || d == 7) return false;
        if (d == 0 || d == 1 || d == 8) return good(n / 10, flag);
        return good(n / 10, true);
    }

    /**
     * 动态规划
     *
     * @param N
     * @return
     */
    public int rotatedDigits2(int N) {
        char[] A = String.valueOf(N).toCharArray();
        int K = A.length;

        int[][][] memo = new int[K + 1][2][2];
        memo[K][0][1] = memo[K][1][1] = 1;
        for (int i = K - 1; i >= 0; --i) {
            for (int eqf = 0; eqf <= 1; ++eqf)
                for (int invf = 0; invf <= 1; ++invf) {
                    // We will compute ans = memo[i][eqf][invf],
                    // the number of good numbers with respect to N = A[i:].
                    // If eqf is true, we must stay below N, otherwise
                    // we can use any digits.
                    // Invf becomes true when we write a 2569, and it
                    // must be true by the end of our writing as all
                    // good numbers have a digit in 2569.
                    int ans = 0;
                    for (char d = '0'; d <= (eqf == 1 ? A[i] : '9'); ++d) {
                        if (d == '3' || d == '4' || d == '7') continue;
                        boolean invo = (d == '2' || d == '5' || d == '6' || d == '9');
                        ans += memo[i + 1][d == A[i] ? eqf : 0][invo ? 1 : invf];
                    }
                    memo[i][eqf][invf] = ans;
                }
        }

        return memo[0][1][0];
    }

}
