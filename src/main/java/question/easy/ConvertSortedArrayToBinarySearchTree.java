package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-15 15:45
 * @version V1.0
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length <= 0)
            return null;
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTCore(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int min = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[min]);
        root.left = sortedArrayToBSTCore(nums, start, min - 1);
        root.right = sortedArrayToBSTCore(nums, min + 1, end);
        return root;
    }

}
