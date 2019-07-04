package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-07-04 16:35.
 * @version V1.0
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 *
 */
public class DiameterOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    //全局变量保留最大的值
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return res;
    }

    public int maxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归左右子树
        int r = maxDiameter(root.right);
        int l = maxDiameter(root.left);
        //更新二叉树直径
        res = Math.max(res, l + r);
        //返回的是该节点的层数
        return Math.max(l, r) + 1;
    }


}
