package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-06 14:01.
 * @version V1.0
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInABST {

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

    public int kthSmallest(TreeNode root, int k) {
        int[] mark = new int[1];
        mark[0] = 0;

        return visit(root, k, mark);
    }

    private Integer visit(TreeNode node, int k, int[] mark) {
        if (node == null) return null;

        Integer left = visit(node.left, k, mark);
        if (left != null) return left;

        mark[0]++;
        if (mark[0] == k) return node.val;

        Integer right = visit(node.right, k, mark);
        if (right != null) return right;

        return null;
    }

}
