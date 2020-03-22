package question.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-18 14:47
 * @version V1.0
 *
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has,
 * and B[j] is the size of the j-th bar of candy that Bob has.
 *
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange,
 * they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 *
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange,
 * and ans[1] is the size of the candy bar that Bob must exchange.
 *
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * Example 2:
 *
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * Example 3:
 *
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * Example 4:
 *
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * It is guaranteed that Alice and Bob have different total amounts of candy.
 * It is guaranteed there exists an answer.
 *
 */
public class FairCandySwap {

    public static void main(String[] args) {

    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] result = new int[2];
        int sumA = 0;
        int sumB = 0;

        for (int i : A) {
            sumA += i;
        }

        for (int i : B) {
            sumB += i;
        }

        int delta = (sumA - sumB) / 2;
        Set<Integer> setB = new HashSet<>();
        for (int x : B) setB.add(x);

        for (int x : A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        return result;
    }

    /**
     * 数学大法好
     *
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap1(int[] A, int[] B) {
        int sa = 0, sb = 0;  // sum of A, B respectively
        for (int x : A) sa += x;
        for (int x : B) sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet<>();
        for (int x : B) setB.add(x);

        for (int x : A)
            if (setB.contains(x + delta))
                return new int[]{x, x + delta};

        throw null;
    }

}