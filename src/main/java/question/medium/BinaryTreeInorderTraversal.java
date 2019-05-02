package question.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-02 14:17.
 * @version V1.0
 * <p>
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        root.right = right1;
        right1.left = left2;

        inorderTraversal1(root).forEach(System.out::println);
    }

    /**
     * 递归实现
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();

        if (root != null) {

            List<Integer> integerLeftList = inorderTraversal(root.left);
            if (!integerLeftList.isEmpty()) {
                nodeList.addAll(integerLeftList);
            }

            nodeList.add(root.val);

            List<Integer> integerRightList = inorderTraversal(root.right);
            if (!integerRightList.isEmpty()) {
                nodeList.addAll(integerRightList);
            }

            return nodeList;
        } else {
            return nodeList;
        }
    }

    /**
     * 迭代实现
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) {
                break;
            }

            root = stack.pop();
            nodeList.add(root.val);
            root = root.right;
        }

        return nodeList;
    }

}
