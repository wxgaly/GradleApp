package question;

import java.util.HashMap;
import java.util.Map;

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
        int[] sum = new int[A.length + 1];
        int count = 0;
        Map<Integer, Integer> map = new HashMap();
        int len = sum.length;
        for (int i = 1; i < len; i++) {
            sum[i] = (sum[i - 1] + A[i - 1]) % K;
            if (sum[i] < 0)
                sum[i] += K;
            if (sum[i] == 0)
                count++;
            if (map.containsKey(sum[i])) {
                count += map.get(sum[i]);
                map.put(sum[i], map.get(sum[i]) + 1);
            } else
                map.put(sum[i], 1);
        }
        return count;

    }

}
