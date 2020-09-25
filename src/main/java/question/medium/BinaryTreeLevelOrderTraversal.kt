package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-25 14:04
 * @version V1.0

    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7
    return its level order traversal as:
    [
        [3],
        [9,20],
        [15,7]
    ]


 *
 */
fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)
    for (list in levelOrder(root)) {
        for (i in list) {
            print("$i, ")
        }
        println()
    }
}

fun levelOrder(root: TreeNode?): List<List<Int>> {

    if (root == null) {
        return emptyList()
    }

    val queue = LinkedList<TreeNode>()
    queue.add(root)
    val res = arrayListOf<MutableList<Int>>()

    while (true) {
        if (queue.isEmpty()) {
            break
        } else {
            val size = queue.size
            val list = arrayListOf<Int>()
            for (i in 0 until size) {
                val node = queue.poll()
                list.add(node.`val`)
                if (node.left != null) {
                    queue.add(node.left!!)
                }

                if (node.right != null) {
                    queue.add(node.right!!)
                }
            }
            res.add(list)
        }
    }

    return res
}
