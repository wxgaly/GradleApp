package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-30 13:48
 * @version V1.0
 *
 * ��Ŀ��
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 */
public class BinaryTreeKMax {

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

    /**
     * ������⣺
     * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
     *
     * �����������ʣ��׵ö����������� ����������� Ϊ �ݼ�����
     * ��ˣ��� �������������� k ��Ľڵ㡱 ��ת��Ϊ�� �������������������ĵ� k ���ڵ㡱 ��
     */
    int res, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.left);
    }

}
