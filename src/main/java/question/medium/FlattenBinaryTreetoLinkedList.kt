package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-07 14:13
 * @version V1.0
 *
 *

    Given a binary tree, flatten it to a linked list in-place.

    For example, given the following tree:

        1
       / \
      2   5
     / \   \
    3  4   6
    The flattened tree should look like:

    1
     \
     2
      \
      3
       \
       4
        \
        5
         \
          6

 *
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(4)
    root.right = TreeNode(5)
    root.right?.right = TreeNode(6)

    flatten(root)
    println(root.`val`)
}

fun flatten(root: TreeNode?): Unit {
    if (root != null) {
        var temp = root
        var node: TreeNode? = null
        var tempNode: TreeNode? = null
        val stack = Stack<TreeNode?>()
        while (true) {
            while (temp != null) {
                if (node == null) {
                    node = TreeNode(temp.`val`)
                    tempNode = node
                } else {
                    tempNode?.right = TreeNode(temp.`val`)
                    tempNode = tempNode?.right
                }
                stack.push(temp)
                temp = temp.left
            }

            if (stack.isEmpty()) {
                break
            }

            temp = stack.pop()
            temp = temp?.right
        }
        println(node)
    }
}

/**
 * 先序遍历，转成右节点
 */
fun flatten1(root: TreeNode) {
    val list = ArrayList<TreeNode>()
    val stack = LinkedList<TreeNode>()
    var node: TreeNode? = root
    while (node != null || !stack.isEmpty()) {
        while (node != null) {
            list.add(node)
            stack.push(node)
            node = node.left
        }
        node = stack.pop()
        node = node!!.right
    }
    val size = list.size
    for (i in 1 until size) {
        val prev = list[i - 1]
        val curr = list[i]
        prev.left = null
        prev.right = curr
    }
}

