package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-17 14:35.
 * @version V1.0
 *
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation:
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 *
 * Note:
 *
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 *
 */
public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        int[] A = new int[]{
                1, 0, 1, 0, 1
        };
        int S = 2;
        System.out.println(numSubarraysWithSum(A, S));
        System.out.println(numSum(A, S));
    }

    /**
     * 会有重复计算，可能超出时间限制，需要优化重复计算的部分
     *
     * @param A
     * @param S
     * @return
     */
    public static int numSubarraysWithSum(int[] A, int S) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int ret = 0;

        int len = A.length;

        for (int i = 0; i < len; i++) {
            int sum = A[i];
            if (sum == S) {
                ret++;
            }
            for (int j = i + 1; j < len; j++) {
                sum += A[j];
                if (sum == S) {
                    ret++;
                }
            }
        }

        return ret;
    }

    public static int numSum(int[] A, int S) {
        int count = 0, i = 0, ans = 0;
        if (S == 0) {
            while (i < A.length) {
                if (A[i++] == 1) {
                    ans += count++ * count / 2;
                    count = 0;
                } else count++;
            }
            return ans + count++ * count / 2;
        }
        while (S > 0) {
            if (i == A.length) return 0;
            else if (A[i++] == 1) S--;
        }
        int j = 0;
        while (i < A.length) {
            do count++; while (i < A.length && A[i++] == 0);
            do ans += count; while (A[j++] == 0);
            count = 0;
        }
        if (A[i - 1] == 1) do ans++; while (A[j++] == 0);
        return ans;
    }

}
