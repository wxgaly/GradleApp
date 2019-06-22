package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-22 14:06.
 * @version V1.0
 *
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so f*** off.
 *
 *
 */
public class InvertBinaryTree {

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

    public TreeNode invertTree(TreeNode root) {

        //递归结束条件
        if (root == null || (root.right == null && root.left == null))
            return root;
        //临时变量记录左右节点地址
        TreeNode left = root.left;
        TreeNode right = root.right;
        //交换左右节点
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;


    }

}
