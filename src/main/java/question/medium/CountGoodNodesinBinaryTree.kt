package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-10 13:59
 * @version V1.0
 *
 *
    Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

    Return the number of good nodes in the binary tree.

     

    Example 1:



    Input: root = [3,1,4,3,null,1,5]
    Output: 4
    Explanation: Nodes in blue are good.
    Root Node (3) is always a good node.
    Node 4 -> (3,4) is the maximum value in the path starting from the root.
    Node 5 -> (3,4,5) is the maximum value in the path
    Node 3 -> (3,1,3) is the maximum value in the path.
    Example 2:



    Input: root = [3,3,null,4,2]
    Output: 3
    Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
    Example 3:

    Input: root = [1]
    Output: 1
    Explanation: Root is considered as good.
     

    Constraints:

    The number of nodes in the binary tree is in the range [1, 10^5].
    Each node's value is between [-10^4, 10^4].

 *
 */
fun main() {

}

var goodCount = 0
fun goodNodes(root: TreeNode?): Int {
    dfsGoodNodes(root, Int.MIN_VALUE)
    return goodCount
}

fun dfsGoodNodes(node: TreeNode?, max: Int) {
    if (node == null) {
        return
    }
    var temp = max
    if (node.`val` >= temp) {
        goodCount++
        temp = node.`val`
    }
    dfsGoodNodes(node.left, temp)
    dfsGoodNodes(node.right, temp)
}

/**
 * 陷入怪圈，没有找到合适的方法
 * 应该将最大值传入，每次对比最大值即可，
 * 先序遍历；
 */
fun isGoodNode(list: List<TreeNode?>, node: TreeNode?) : Boolean {
    if (node == null) {
        return false
    }
    list.forEach { item ->
        item?.let {
            if (it.`val` > node.`val`) {
                return false
            }
        }
    }
    return true
}
