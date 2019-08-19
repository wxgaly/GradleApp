package question.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-08-19 14:01.
 * @version V1.0
 *
 * n a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 *
 * Return the element repeated N times.
 *
 *  
 *
 * Example 1:
 *
 * Input: [1,2,3,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,1,2,5,3,2]
 * Output: 2
 * Example 3:
 *
 * Input: [5,1,5,2,5,3,5,4]
 * Output: 5
 *  
 *
 * Note:
 *
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length is even
 *
 *
 */
public class NRepeatedElementInSize2NArray {

    public static void main(String[] args) {

    }

    public int repeatedNTimes(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            Integer mapOrDefault = map.getOrDefault(i, -1);
            if (mapOrDefault == -1) {
                map.put(i, 1);
            } else {
                mapOrDefault += 1;
                map.put(i, mapOrDefault);
            }
        }


        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue() == A.length / 2) {
               return  integerIntegerEntry.getKey();
            }
        }

        return -1;
    }

    public int repeatedNTimes1(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }

}
