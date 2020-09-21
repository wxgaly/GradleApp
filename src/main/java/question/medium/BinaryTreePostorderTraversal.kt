package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-21 14:15
 * @version V1.0
 *

    Given the root of a binary tree, return the postorder traversal of its nodes' values.

    Follow up: Recursive solution is trivial, could you do it iteratively?

     

    Example 1:


    Input: root = [1,null,2,3]
    Output: [3,2,1]
    Example 2:

    Input: root = []
    Output: []
    Example 3:

    Input: root = [1]
    Output: [1]
    Example 4:


    Input: root = [1,2]
    Output: [2,1]
    Example 5:


    Input: root = [1,null,2]
    Output: [2,1]
     

    Constraints:

    The number of the nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100


 *
 */
fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(3)
    postorderTraversalTreeLoop(root).forEach {
        print("$it, ")
    }
}

var posResList = arrayListOf<Int>()

fun postorderTraversal(root: TreeNode?): List<Int> {
    postorderTraversalTree(root)
    return posResList
}

/**
 * 简单粗暴，递归
 */
fun postorderTraversalTree(root: TreeNode?) {
    if (root != null) {
        postorderTraversalTree(root.left)
        postorderTraversalTree(root.right)
        posResList.add(root.`val`)
    }
}

/**
 * 迭代实现
 * 官方题解：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode/
 */
fun postorderTraversalTreeLoop(root: TreeNode?): List<Int> {
    val stack = LinkedList<TreeNode?>()
    val resList = LinkedList<Int>()
    if (root == null) {
        return resList
    }

    stack.add(root)
    while (!stack.isEmpty()) {
        val node = stack.pollLast()
        resList.addFirst(node!!.`val`)
        if (node.left != null) {
            stack.add(node.left)
        }
        if (node.right != null) {
            stack.add(node.right)
        }
    }

    return resList
}
