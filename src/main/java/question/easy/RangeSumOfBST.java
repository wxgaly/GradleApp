package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-09-09 14:42
 * @version V1.0
 *
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 *  
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *  
 *
 * Note:
 *
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 *
 *
 */
public class RangeSumOfBST {

    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    private void dfs(TreeNode root, int L, int R) {
        if (root != null) {
            int val = root.val;
            if (L <= val && val <= R) {
                sum += val;
            }
            if (val > L) {
                dfs(root.left, L, R);
            }
            if (root.val < R) {
                dfs(root.right, L, R);
            }
        }

    }

}
