package question.medium

import java.util.*
import kotlin.collections.ArrayList

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-24 13:48
 * @version V1.0
 *

    Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).


    Example 1:


    Input: root = [1,3,2,5,3,null,9]
    Output: [1,3,9]
    Example 2:

    Input: root = [1,2,3]
    Output: [1,3]
    Example 3:

    Input: root = [1]
    Output: [1]
    Example 4:

    Input: root = [1,null,2]
    Output: [1,2]
    Example 5:

    Input: root = []
    Output: []
     

    Constraints:

    The number of nodes in the tree will be in the range [0, 104].
    -231 <= Node.val <= 231 - 1


 *
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(3)
    root.right = TreeNode(2)
    root.left!!.left = TreeNode(5)
    root.left!!.right = TreeNode(3)
    root.right!!.right = TreeNode(9)
    for (i in largestValues(root)) {
        print("$i, ")
    }
}

/**
 * 能想到比较简单的层序遍历，即BFS
 */
fun largestValues(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }

    val list = arrayListOf<Int>()

    val queue = LinkedList<TreeNode>()
    queue.push(root)
    while (true) {
        if (queue.isEmpty()) {
            break
        } else {
            val size = queue.size
            var max = queue.first.`val`
            for (i in 0 until size) {
                val temp = queue.poll()
                max = Math.max(max, temp.`val`)
                if (temp.left != null) {
                    queue.addLast(temp.left)
                }
                if (temp.right != null) {
                    queue.addLast(temp.right)
                }
            }
            list.add(max)
        }
    }

    return list
}

fun largestValues1(root: TreeNode?): List<Int> {
    val res = arrayListOf<Int>()
    largestValuesHelper(root, res, 1)
    return res
}

/**
 * DFS，
 */
fun largestValuesHelper(root: TreeNode?, res: ArrayList<Int>, level: Int) {
    if (root == null) {
        return
    }
    if (level == res.size + 1) {
        res.add(root.`val`)
    } else {
        res[level - 1] = Math.max(res[level - 1], root.`val`)
    }
    largestValuesHelper(root.left, res, level + 1)
    largestValuesHelper(root.right, res, level + 1)
}
