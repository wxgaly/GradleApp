package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-11 14:14
 * @version V1.0
 *
 * ����һ�ö������ĸ��ڵ㣬�жϸ����ǲ���ƽ������������ĳ������������ڵ���������������������1����ô������һ��ƽ���������
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ���������� [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ���� true ��
 *
 * ʾ�� 2:
 *
 * ���������� [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * ����?false ��
 *
 * ?
 *
 * ���ƣ�
 *
 * 1 <= ���Ľ����� <= 10000
 * ע�⣺��������վ 110?����ͬ��https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 *
 */
public class BalanceBinaryTree {

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

    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    /**
     * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/
     * ʹ����ⷽ��һ
     *
     * @param root
     * @return
     */
    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
