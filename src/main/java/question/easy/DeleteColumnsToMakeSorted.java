package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-16 14:00
 * @version V1.0
 *
 * We are given an array A of N lowercase letter strings, all of the same length.
 *
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
 *
 * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3},
 * then the final array after deletions is ["bef", "vyz"], 
 * and the remaining columns of A are ["b","v"], ["e","y"], and ["f","z"]. 
 * (Formally, the c-th column is [A[0][c], A[1][c], ..., A[A.length-1][c]].)
 *
 * Suppose we chose a set of deletion indices D such that after deletions,
 * each remaining column in A is in non-decreasing sorted order.
 *
 * Return the minimum possible value of D.length.
 *
 *  
 *
 * Example 1:
 *
 * Input: ["cba","daf","ghi"]
 * Output: 1
 * Explanation:
 * After choosing D = {1}, each column ["c","d","g"] and ["a","f","i"] are in non-decreasing sorted order.
 * If we chose D = {}, then a column ["b","a","h"] would not be in non-decreasing sorted order.
 * Example 2:
 *
 * Input: ["a","b"]
 * Output: 0
 * Explanation: D = {}
 * Example 3:
 *
 * Input: ["zyx","wvu","tsr"]
 * Output: 3
 * Explanation: D = {0, 1, 2}
 *  
 *
 * Note:
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 1000
 *
 */
public class DeleteColumnsToMakeSorted {

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted sorted = new DeleteColumnsToMakeSorted();
        String[] A = new String[]{
//                "cba", "daf", "ghi"
//                "a", "b"
//                "zyx", "wvu", "tsr"
                "rrjk", "furt", "guzm"
        };
        System.out.println(sorted.minDeletionSize(A));
    }

    public int minDeletionSize(String[] A) {
        int minSize = 0;

        int len = A[0].length();
        for (int i = 0; i < len; i++) {
            char last = A[0].charAt(i);
            for (int i1 = 1; i1 < A.length; i1++) {
                char current = A[i1].charAt(i);
                if (last > current) {
                    minSize++;
                    break;
                } else {
                    last = current;
                }
            }
        }

        return minSize;
    }

    /**
     * 贪心算法，每列都比较是否为降序，
     * @param A
     * @return
     */
    public int minDeletionSize1(String[] A) {
        int ans = 0;
        for (int c = 0; c < A[0].length(); ++c)
            for (int r = 0; r < A.length - 1; ++r)
                if (A[r].charAt(c) > A[r + 1].charAt(c)) {
                    ans++;
                    break;
                }

        return ans;
    }

}
