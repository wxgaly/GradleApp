package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-04-26 16:46.
 * @version V1.0
 * <p>
 * Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot,
 * and two sightseeing spots i and j have distance j - i between them.
 * <p>
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) :
 * the sum of the values of the sightseeing spots, minus the distance between them.
 * <p>
 * Return the maximum score of a pair of sightseeing spots.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class BestSightseeingPair {

    public static void main(String[] args) {

        int[] A = new int[]{8, 1, 5, 2, 6};
        System.out.println(maxScoreSightseeingPair(A));
    }

    public static int maxScoreSightseeingPair(int[] A) {

        int max_left = 0;
        int max_value = 0;
        for (int i = 0; i < A.length; i++) {
            max_value = Math.max(max_value, max_left + A[i] - i);
            max_left = Math.max(max_left, i + A[i]);
        }
        return max_value;
    }

}
