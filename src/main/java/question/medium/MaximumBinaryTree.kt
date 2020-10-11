package question.medium

/**
 *  question.medium.MaximumBinaryTree
 *
 * @author Created by WXG on 2020/10/11 15:44.
 * @version V1.0

    Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

    The root is the maximum number in the array.
    The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
    The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
    Construct the maximum tree by the given array and output the root node of this tree.

 *
 */
fun main() {

}

class MaximumBinaryTreeKT1 {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return construct(nums, 0, nums.size)
    }

    fun construct(nums: IntArray, l: Int, r: Int): TreeNode? {
        if (l == r) return null
        val max_i = max(nums, l, r)
        val root = TreeNode(nums[max_i])
        root.left = construct(nums, l, max_i)
        root.right = construct(nums, max_i + 1, r)
        return root
    }

    fun max(nums: IntArray, l: Int, r: Int): Int {
        var max_i = l
        for (i in l until r) {
            if (nums[max_i] < nums[i]) max_i = i
        }
        return max_i
    }
}