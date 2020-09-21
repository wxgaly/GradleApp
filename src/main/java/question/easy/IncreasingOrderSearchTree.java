package question.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-11-21 18:58
 * @version V1.0
 *
 * ����һ���������������������������ʹ��������ߵĽ�����������ĸ�������ÿ�����û�����ӽ�㣬ֻ��һ�����ӽ�㡣
 *
 * ?
 *
 * ʾ�� ��
 *
 * ���룺[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 * ?/        / \
 * 1        7   9
 *
 * �����[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 * ? \
 * ?  2
 * ?   \
 * ?    3
 * ?     \
 * ?      4
 * ?       \
 * ?        5
 * ?         \
 * ?          6
 * ?           \
 * ?            7
 * ?             \
 * ?              8
 * ?               \
 *                  9
 * ?
 *
 * ��ʾ��
 *
 * �������еĽ�������� 1 ��?100 ֮�䡣
 * ÿ����㶼��һ���� 0 �� 1000 ��Χ�ڵ�Ψһ����ֵ��
 *
 *
 */
public class IncreasingOrderSearchTree {

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

    public TreeNode increasingBST(TreeNode root) {
        if (root != null) {
            TreeNode treeNode = null;
            TreeNode treeNodeRoot = null;
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
                if (treeNode == null) {
                    treeNode = new TreeNode(root.val);
                    treeNodeRoot = treeNode;
                } else {
                    treeNode.right = new TreeNode(root.val);
                    treeNode = treeNode.right;
                }
                System.out.println(root.val);
                root = root.right;
            }

            return treeNodeRoot;
        }

        return null;
    }

    /**
     * �ı����ĸ߶�
     */
    TreeNode cur;

    public TreeNode increasingBST1(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    /**
     * �������
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST2(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v : vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

}
