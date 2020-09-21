package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-22 13:48
 * @version V1.0
 *
 * ����һ�ö������ĸ��ڵ㣬���������ȡ��Ӹ��ڵ㵽Ҷ�ڵ����ξ����Ľڵ㣨������Ҷ�ڵ㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 *
 * ���磺
 *
 * ���������� [3,9,20,null,null,15,7]��
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ��������������?3 ��
 *
 *
 */
public class TheDepthOfBinaryTree {

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

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

}
