package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-06 14:10
 * @version V1.0
 *

    Given a binary tree, find the leftmost value in the last row of the tree.

    Example 1:
    Input:

        2
       / \
      1  3

    Output:
    1
    Example 2:
    Input:

        1
       / \
      2  3
     /  / \
    4  5  6
   /
  7

 *
 */
fun main() {
    var root = TreeNode(2)
//    root.left = TreeNode(1)
//    root.right = TreeNode(3)
//    println(findBottomLeftValue(root))

    root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(4)
    root.right = TreeNode(3)
    root.right!!.left = TreeNode(5)
    root.right!!.left!!.left = TreeNode(7)
    root.right!!.right = TreeNode(6)
    println(findBottomLeftValue(root))
}

//这种做法没有考虑最后一层只有右节点的情况
fun findBottomLeftValue(root: TreeNode?): Int {
    val queue = LinkedList<TreeNode?>()
    queue.add(root)
    var res = root!!.`val`
    while (queue.isNotEmpty()) {
        val temp = queue.poll()
        if (temp != null) {
            var node = temp.left
            var find = false
            if (node != null) {
                if (node.left == null && node.right == null) {
                    find = true
                    res = node.`val`
                }
                queue.add(node)
            }
            node = temp.right
            if (node != null) {
                if (!find) {
                    if (node.left == null && node.right == null) {
                        res = node.`val`
                    }
                }
                queue.add(node)
            }
        }
    }
    return res
}

/**
 * 递归解法，
 */
var max = -1
var value = 0
fun findBottomLeftValue1(root: TreeNode?): Int {
    get(root, 0)
    return value
}

fun get(node: TreeNode?, num: Int) {
    if (node == null) {
        return
    }
    if (num > max) {
        max = num
        value = node.`val`
    }
    get(node.left, num + 1)
    get(node.right, num + 1)
}
