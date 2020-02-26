package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-26 14:12
 * @version V1.0
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *  
 *
 * Note: There are at least two nodes in this BST.
 *
 *
 */
public class MinimumAbsoluteDifferenceinBST {

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (pre != null) {
            min = Math.min(min, node.val - pre.val);
        }
        pre = node;
        inOrder(node.right);
    }

}
