package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-28 15:33
 * @version V1.0
 *
 *
    Return the root node of a binary search tree that matches the given preorder traversal.

    (Recall that a binary search tree is a binary tree where for every node, any descendant of node.
    left has a value < node.val, and any descendant of node.right has a value > node.val. 
    Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

    It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

    Example 1:

    Input: [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]

     

    Constraints:

    1 <= preorder.length <= 100
    1 <= preorder[i] <= 10^8
    The values of preorder are distinct.

 *
 */
fun main() {

}

lateinit var preorderX: IntArray
var index = 0
var len = 0

fun bstFromPreorder(preorder: IntArray): TreeNode? {
    preorderX = preorder
    len = preorder.size
    return helper(Integer.MIN_VALUE, Integer.MAX_VALUE)
}

fun helper(lower: Int, upper: Int): TreeNode? {
    if (index == len) return null

    val temp = preorderX[index]
    if (temp < lower || temp > upper) {
        return null
    }

    ++index
    val root = TreeNode(temp)
    root.left = helper(lower, temp)
    root.right = helper(temp, upper)
    return root
}
