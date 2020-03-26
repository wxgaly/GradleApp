package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-26 13:49
 * @version V1.0
 *
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j]. 
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 *  
 *
 * Example 1:
 *
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: [1,1,1]
 * Output: true
 *  
 *
 * Note:
 *
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 *
 *
 */
public class MonotonicArray {

    public static void main(String[] args) {
        MonotonicArray monotonicArray = new MonotonicArray();
        System.out.println(monotonicArray.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(monotonicArray.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println(monotonicArray.isMonotonic(new int[]{1, 3, 2}));
        System.out.println(monotonicArray.isMonotonic(new int[]{1, 2, 4, 5}));
        System.out.println(monotonicArray.isMonotonic(new int[]{1, 1, 1}));
    }

    public boolean isMonotonic(int[] A) {
        return increasing(A) || decreasing(A);
    }

    public boolean increasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] > A[i+1]) return false;
        return true;
    }

    public boolean decreasing(int[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i] < A[i+1]) return false;
        return true;
    }

    public boolean isMonotonic1(int[] A) {
        int store = 0;
        for (int i = 0; i < A.length - 1; ++i) {
            int c = Integer.compare(A[i], A[i+1]);
            if (c != 0) {
                if (c != store && store != 0)
                    return false;
                store = c;
            }
        }

        return true;
    }


}
