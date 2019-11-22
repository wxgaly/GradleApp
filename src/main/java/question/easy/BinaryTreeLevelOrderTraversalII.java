package question.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-11-22 14:10
 * @version V1.0
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class BinaryTreeLevelOrderTraversalII {

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size(); // 当前层元素的个数
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    subList.add(curNode.val);
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            if (subList.size() > 0) {
                ans.add(0, subList);
            }
        }
        return ans;
    }

}
