package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-16 13:54
 * @version V1.0
 *
 *
Given a binary tree, return the sum of values of its deepest leaves.

Example 1:



Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
 

Constraints:

The number of nodes in the tree is between 1 and 10^4.
The value of nodes is between 1 and 100.
 *
 */


fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun deepestLeavesSum(root: TreeNode?): Int {
    val queue = LinkedList<TreeNode?>()
    var res = 0
    queue.add(root)

    while (queue.isNotEmpty()) {
        res = 0

        val size = queue.size
        for (i in 0..size) {
            val q = queue.poll()
            q?.`val`?.plus(res)
            q?.left?.let {
                queue.add(it.left)
            }

            q?.right?.let {
                queue.add(it.right)
            }
        }
    }

    return res
}

var maxDepth = -1
var sum = 0

fun deepestLeavesSum1(root: TreeNode): Int {
    return dfs(root, 0)
}

private fun dfs(root: TreeNode?, depth: Int): Int {
    if (root == null) {
        return 0
    }
    if (maxDepth < depth) {
        maxDepth = depth
        sum = root.`val`
    } else if (depth == maxDepth) {
        sum += root.`val`
    }
    if (root.left != null) {
        dfs(root.left, depth + 1)
    }
    if (root.right != null) {
        dfs(root.right, depth + 1)
    }
    return sum
}

