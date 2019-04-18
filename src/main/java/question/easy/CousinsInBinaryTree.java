package question.easy;

/**
 * question.easy.CousinsInBinaryTree
 *
 * @author Created by WXG on 2019-4-18 13:57.
 * @version V1.0
 * <p>
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */

public class CousinsInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        root.left = left1;
        root.right = right1;
        left1.right = new TreeNode(4);
        right1.right = new TreeNode(5);
        System.out.println(isCousins(root, 5, 4));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isCousins(TreeNode root, int x, int y) {

        int[] result = new int[4];
        for (int i = 0; i < result.length; ++i) {
            result[i] = -1;
        }

        getResult(root, x, y, result, 0);

        return (result[0] != result[1]) && (result[2] == result[3]);
    }

    public static void getResult(TreeNode root, int x, int y, int[] result, int depth) {
        //result[2] 和 result[3]分别记录x和y的父节点的深度 result[0]和result[1]分别表示x和y的父节点的值
        if (root == null) return;
        if (result[0] != -1 && result[1] != -1) return;

        if (root.left != null) {
            if (root.left.val == x) {
                result[0] = root.val;
                result[2] = depth;
            }
            if (root.left.val == y) {
                result[1] = root.val;
                result[3] = depth;
            }
        }
        if (root.right != null) {
            if (root.right.val == x) {
                result[0] = root.val;
                result[2] = depth;
            }
            if (root.right.val == y) {
                result[1] = root.val;
                result[3] = depth;
            }
        }

        getResult(root.left, x, y, result, depth + 1);
        getResult(root.right, x, y, result, depth + 1);
    }

    public static boolean isCousins1(TreeNode root, int x, int y) {

        if (root == null) {
            return false;
        }

        int[] rootAndDepthX = getRootAndDepth(root, x);
        int[] rootAndDepthY = getRootAndDepth(root, y);


        return (rootAndDepthX[0] != rootAndDepthY[0]) && (rootAndDepthX[1] == rootAndDepthY[1]);
    }

    public static int[] getRootAndDepth(TreeNode root, int value) {
        int depth = 0;
        int rootValue = 0;

        TreeNode tempRoot = root;
        depth = minDepth(root, value);
        while (tempRoot != null) {
            if (tempRoot.val == value) {

            }
        }
        return new int[]{rootValue, depth};
    }

    public static int minDepth(TreeNode root, int value) {
        if (root == null) {
            return 0;
        } else {
            if (root.left != null) {
                if (root.left.val == value) {
                    return 0;
                }
            }

            if (root.right != null) {
                if (root.right.val == value) {
                    return 0;
                }
            }
        }

        int leftDepth = minDepth(root.left, value);
        int rightDepth = minDepth(root.right, value);

        if (leftDepth == 0 || rightDepth == 0) {
            return 1 + leftDepth + rightDepth;
        } else {
            return leftDepth > rightDepth ? 1 + rightDepth : 1 + leftDepth;
        }
    }


}
