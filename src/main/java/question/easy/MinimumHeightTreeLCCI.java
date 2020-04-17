package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-17 16:09
 * @version V1.0
 *
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algo­rithm to create a binary search tree with minimal height.
 *
 * Example:
 *
 * Given sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5]，which represents the following tree:
 *
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 *
 *
 */
public class MinimumHeightTreeLCCI {

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
        if (nums.length == 0) return null;
        TreeNode n = new TreeNode(nums[nums.length / 2]);
        n.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
        n.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
        return n;
    }

}
