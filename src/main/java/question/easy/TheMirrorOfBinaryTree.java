package question.easy;

import java.util.Stack;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-24 14:13
 * @version V1.0
 *
 *
 * �����һ������������һ�����������ú���������ľ���
 *
 * �������룺
 *
 * ? ? ?4
 * ? ?/ ? \
 * ? 2 ? ? 7
 * ?/ \ ? / \
 * 1 ? 3 6 ? 9
 * ���������
 *
 * ? ? ?4
 * ? ?/ ? \
 * ? 7 ? ? 2
 * ?/ \ ? / \
 * 9 ? 6 3? ?1
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺root = [4,2,7,1,3,6,9]
 * �����[4,7,2,9,6,3,1]
 *
 *
 */
public class TheMirrorOfBinaryTree {

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


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) return root;
//        �ݹ鷨
        TreeNode tmp = root.left;
        root.left = mirrorTree1(root.right);
        root.right = mirrorTree1(tmp);
        return root;

    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) return root;

        //����ջ��
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;

    }
}
