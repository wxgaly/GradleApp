package question;

/**
 * question.SubarraySumsDivisibleByK
 *
 * @author Created by WXG on 2019/2/28 028 13:53.
 * @version V1.0
 */

public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {

        int[] A = new int[]{4, 5, 0, -2, -3, 1};
        int K = 5;
        System.out.println("结果是: " + subarraysDivByK(A, K));
    }

    public static int subarraysDivByK(int[] A, int K) {
        int result = 0;

        int len = A.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += A[j];
                if ((sum % K) == 0) {
                    result++;
                }
            }
        }

        return result;
    }

}
