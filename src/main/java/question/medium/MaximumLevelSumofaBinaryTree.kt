package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-21 13:45
 * @version V1.0
 *

    Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

    Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

     

    Example 1:



    Input: [1,7,0,7,-8,null,null]
    Output: 2
    Explanation:
    Level 1 sum = 1.
    Level 2 sum = 7 + 0 = 7.
    Level 3 sum = 7 + -8 = -1.
    So we return the level with the maximum sum which is level 2.
     

    Note:

    The number of nodes in the given tree is between 1 and 10^4.
    -10^5 <= node.val <= 10^5

 *
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    println(maxLevelSum(root))
}

fun maxLevelSum(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    var currLevel = 1
    var maxLevel = 1
    var maxSum = root.`val`
    var currSum = 0
    val queue = LinkedList<TreeNode>()
    val marker: TreeNode? = null
    var x = root
    queue.addLast(root)
    queue.addLast(marker)

    while (queue.size > 1) {
        x = queue.removeFirst()
        if (x != marker) {
            currSum += x.`val`
            if (x.left != null) queue.addLast(x.left)
            if (x.right != null) queue.addLast(x.right)
        } else {
            if (currSum > maxSum) {
                maxSum = currSum
                maxLevel = currLevel
            }
            currSum = 0
            currLevel++
            queue.addLast(marker)
        }
    }
    return maxLevel
}
