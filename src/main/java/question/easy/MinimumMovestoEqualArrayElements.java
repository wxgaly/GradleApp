package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-12 16:42
 * @version V1.0
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 3
 *
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 *
 */
public class MinimumMovestoEqualArrayElements {

    public static void main(String[] args) {

    }


    /**
     * 方法六：改进的数学法 【通过】
     * 算法
     *
     * 上一个方法可能存在问题。 \sum_{i=0}^{n-1} a[i]∑
     * i=0
     * n?1
     * ?
     *  a[i] 可能会非常大，造成整数越界。为了避免这一问题，我们可以即时计算 movesmoves。\sum_{i=0}^{n-1} (a[i]-min(a))∑
     * i=0
     * n?1
     * ?
     *  (a[i]?min(a))。
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        return moves;
    }

}
