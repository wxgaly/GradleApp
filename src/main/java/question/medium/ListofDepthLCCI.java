package question.medium;

import java.util.*;

/**
 * question.medium.
 *
 * @author Created by WXG on 2020-06-08 14:03
 * @version V1.0
 *
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
 * (e.g., if you have a tree with depth D, you'll have D linked lists). Return a array containing all the linked lists.
 *
 * ?
 *
 * Example:
 *
 * Input: [1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * Output: [[1],[2,3],[4,5,7],[8]]
 *
 *
 */
public class ListofDepthLCCI {

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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 层序遍历，每层都会在队列中存储，然后在遍历
     * @param tree
     * @return
     */
    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        TreeNode temp;
        while (queue.isEmpty()) {
            temp = queue.poll();

        }

        return new ListNode[3];
    }

    public ListNode[] listOfDepth1(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<ListNode> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummyHead = new ListNode(-1), pre = dummyHead;
            for (int i = 0; i < size; i++) {
                TreeNode root = queue.poll();
                pre.next = new ListNode(root.val);
                pre = pre.next;
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            list.add(dummyHead.next);
        }

        return list.toArray(new ListNode[list.size()]);
    }

}
