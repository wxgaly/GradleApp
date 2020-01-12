package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-01-12 15:28
 * @version V1.0
 *
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 *
 * If there aren't two consecutive 1's, return 0.
 *
 *  
 *
 * Example 1:
 *
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 * Example 2:
 *
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 * Example 3:
 *
 * Input: 6
 * Output: 1
 * Explanation:
 * 6 in binary is 0b110.
 * Example 4:
 *
 * Input: 8
 * Output: 0
 * Explanation:
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 *  
 *
 * Note:
 *
 * 1 <= N <= 10^9
 *
 *
 */
public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.binaryGap(22));
        System.out.println(binaryGap.binaryGap(5));
        System.out.println(binaryGap.binaryGap(6));
        System.out.println(binaryGap.binaryGap(8));
    }

    public int binaryGap(int N) {
        int step = 0;

        int len = Integer.toBinaryString(N).length();

        int start = -1;
        int end;
        for (int i = 0; i < len; i++) {
            if (((N >> i) & 0x01) == 1) {
                if (start == -1) {
                    start = i;
                } else {
                    end = i;
                    if (end - start > step) {
                        step = end - start;
                    }
                    start = -1;
                    i--;
                }
            }
        }

        return step;
    }

    public int binaryGap1(int N) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }

    public int binaryGap2(int N) {
        int[] A = new int[32];
        int t = 0;
        for (int i = 0; i < 32; ++i)
            if (((N >> i) & 1) != 0)
                A[t++] = i;

        int ans = 0;
        for (int i = 0; i < t - 1; ++i)
            ans = Math.max(ans, A[i + 1] - A[i]);
        return ans;
    }


}
