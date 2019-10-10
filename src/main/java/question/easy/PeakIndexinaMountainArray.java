package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-10 15:10
 * @version V1.0
 * <p>
 * <p>
 * Let's call an array A a mountain if the following properties hold:
 * <p>
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [0,2,1,0]
 * Output: 1
 * Note:
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A is a mountain, as defined above.
 */
public class PeakIndexinaMountainArray {

    public static void main(String[] args) {
        PeakIndexinaMountainArray array = new PeakIndexinaMountainArray();
        int[] A = new int[]{
                0, 2, 1, 0
        };
        System.out.println(array.peakIndexInMountainArray(A));
    }

    /**
     * 二分法，时间复杂度O(logN)
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int len = A.length;
        int index = 0;

        int left = index;
        int right = len - 1;
        int mid = len / 2;

        while (left < right) {
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                index = mid;
                break;
            } else {
                if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                    left = mid;
                    mid = mid + (right - left) / 2;
                } else {
                    right = mid;
                    mid = mid - (right - left) / 2;
                }
            }
        }

        return index;
    }

    public int peakIndexInMountainArray1(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if ((A[mid] > A[mid + 1]) && A[mid] > A[mid - 1]) {
                return mid;
            } else if ((A[mid] > A[mid + 1]) && A[mid] < A[mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
