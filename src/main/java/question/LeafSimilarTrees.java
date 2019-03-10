package question;


import java.util.ArrayList;
import java.util.List;

/**
 * question.LeafSimilarTrees
 *
 * @author Created by WXG on 2019/3/7 007 15:18.
 * @version V1.0
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * <p>
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */

public class LeafSimilarTrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(8);

        System.out.println(leafSimilar(node, node));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leaves1 = getLeafNode(new ArrayList<>(), root1);
        List<Integer> leaves2 = getLeafNode(new ArrayList<>(), root2);
        for (Integer integer : leaves1) {
            System.out.println(integer);
        }
        return leaves1.equals(leaves2);
    }

    public static List<Integer> getLeafNode(List<Integer> list, TreeNode root) {

        if (root != null) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
            }
            getLeafNode(list, root.left);
            getLeafNode(list, root.right);
        }
        return list;
    }

}
