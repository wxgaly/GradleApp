package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-17 14:57
 * @version V1.0
 *

    Given a binary tree, imagine yourself standing on the right side of it,
    return the values of the nodes you can see ordered from top to bottom.

    Example:

    Input: [1,2,3,null,5,null,4]
    Output: [1, 3, 4]


 *
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.right = TreeNode(5)
    root.right!!.right = TreeNode(4)
    for (i in rightSideView(root)) {
        print("$i, ")
    }
}

fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val queue = LinkedList<TreeNode>()
    queue.push(root)
    val res = arrayListOf<Int>()
    while (queue.isNotEmpty()) {
        res.add(queue.first().`val`)
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.poll()
            print("${node.`val`}, ")
            if (node.left != null) {
                queue.push(node.left)
            }
            if (node.right != null) {
                queue.push(node.right)
            }
        }
    }
    println("-----")
    return res
}

/**
 * 广度优先搜索，自己有点笨
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/er-cha-shu-de-you-shi-tu-by-leetcode-solution/
 */
fun rightSideView1(root: TreeNode): List<Int> {
    val rightmostValueAtDepth = HashMap<Int, Int>()
    var max_depth = -1

    val nodeQueue = LinkedList<TreeNode?>()
    val depthQueue = LinkedList<Int>()
    nodeQueue.add(root)
    depthQueue.add(0)

    while (!nodeQueue.isEmpty()) {
        val node = nodeQueue.remove()
        val depth = depthQueue.remove()

        if (node != null) {
            // 维护二叉树的最大深度
            max_depth = Math.max(max_depth, depth)

            // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
            rightmostValueAtDepth[depth] = node.`val`

            nodeQueue.add(node.left)
            nodeQueue.add(node.right)
            depthQueue.add(depth + 1)
            depthQueue.add(depth + 1)
        }
    }

    val rightView = ArrayList<Int>()
    for (depth in 0..max_depth) {
        rightView.add(rightmostValueAtDepth[depth]!!)
    }

    return rightView
}
