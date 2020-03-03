package question.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-03 12:08
 * @version V1.0
 *
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *  
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 *
 */
public class TwoSumIVInputisaBST {

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

    public class Solution {
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                if (queue.peek() != null) {
                    TreeNode node = queue.remove();
                    if (set.contains(k - node.val))
                        return true;
                    set.add(node.val);
                    queue.add(node.right);
                    queue.add(node.left);
                } else
                    queue.remove();
            }
            return false;
        }
    }

}
