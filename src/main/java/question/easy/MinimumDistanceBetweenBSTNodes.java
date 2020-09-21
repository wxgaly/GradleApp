package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-29 13:46
 * @version V1.0
 *
 * Given a Binary Search Tree (BST) with the root node root,
 * return?the minimum difference between the values of any two different nodes in the tree.
 *
 * Example :
 *
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 *
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * Note:
 *
 * The size of the BST will be between 2 and?100.
 * The BST is always valid, each node's value is an integer, and each node's value is different.
 * This question is the same as 530:?https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 *
 *
 */
public class MinimumDistanceBetweenBSTNodes {

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

    int min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return min;
        }

        if (root.left != null) {
            min = Math.min(min, root.val - root.left.val);
        }


        return min;
    }

    /**
     * 利用二叉搜索树的特性，
     * 中序遍历出的顺序即是排序，
     * 然后比较两两差值
     * 。。。。
     * <p>
     * 官方题解：
     * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/solution/er-cha-sou-suo-shu-jie-dian-zui-xiao-ju-chi-by-lee/
     */
    class Solution {
        Integer prev, ans;

        public int minDiffInBST(TreeNode root) {
            prev = null;
            ans = Integer.MAX_VALUE;
            dfs(root);
            return ans;
        }

        public void dfs(TreeNode node) {
            if (node == null) return;
            dfs(node.left);
            if (prev != null)
                ans = Math.min(ans, node.val - prev);
            prev = node.val;
            dfs(node.right);
        }
    }


}
