package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-06 13:52
 * @version V1.0
 *
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 *
 *
 */
public class SumofLeftLeaves {

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

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root, false);
    }

    // 先序遍历求所有左叶子节点值之和
    public int sumOfLeftLeavesHelper(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        int leave = 0;
        // 左叶子节点
        if (flag && root.left == null && root.right == null) {
            leave = root.val;
        }
        int left = sumOfLeftLeavesHelper(root.left, true);
        int right = sumOfLeftLeavesHelper(root.right, false);
        return left + right + leave;
    }

}
