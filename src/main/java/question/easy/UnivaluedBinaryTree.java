package question.easy;

import tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-22 13:54
 * @version V1.0
 *
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: [2,2,2,5,2]
 * Output: false
 *  
 *
 * Note:
 *
 * The number of nodes in the given tree will be in the range [1, 100].
 * Each node's value will be an integer in the range [0, 99].
 *
 *
 */
public class UnivaluedBinaryTree {

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

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode temp;
        int x = root.val;
        queue.add(root);

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (x != temp.val) {
                return false;
            }

            TreeNode node = temp.left;
            if (node != null) {
                queue.add(node);
            }

            node = temp.right;
            if (node != null) {
                queue.add(node);
            }
        }

        return true;
    }

    public boolean isUnivalTree1(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree1(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree1(root.right)));
        return left_correct && right_correct;
    }


}
