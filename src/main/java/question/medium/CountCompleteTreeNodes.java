package question.medium;

/**
 * question.medium.CountCompleteTreeNodes
 *
 * @author Created by WXG on 2019/3/26 026 14:55.
 * @version V1.0
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 */

public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        System.out.println(countNodes(t2));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int countNodes(TreeNode root) {
        int count = 0;

        if (root != null) {
            count++;
            count += countNodes(root.left);
            count += countNodes(root.right);
        }

        return count;
    }

}
