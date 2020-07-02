package question.medium


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-02 14:09
 * @version V1.0
 *
 *
    We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

    Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

    (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)

    Example 1:
    Input: [1,null,0,0,1]
    Output: [1,null,0,null,1]

    Explanation:
    Only the red nodes satisfy the property "every subtree not containing a 1".
    The diagram on the right represents the answer.


    Example 2:
    Input: [1,0,1,0,0,0,1]
    Output: [1,null,1,null,1]



    Example 3:
    Input: [1,1,0,1,1,0,1,0]
    Output: [1,1,0,1,1,null,1]



    Note:

    The binary tree will have at most 100 nodes.
    The value of each node will only be 0 or 1.
 *
 */
fun main() {

}

fun pruneTree(root: TreeNode?): TreeNode? {
    dfs(root?.left)
    dfs(root?.right)
    return root
}

fun dfs(pNode: TreeNode?) {
    if (pNode == null) {
        return
    }

    val left = pNode.left
    if (left != null) {
        if (left.left == null && left.right == null) {
            if (left.`val` == 0) {
                pNode.left = null
            }
        }
    }

    val right = pNode.right
    if (right != null) {
        if (right.left == null && right.right == null) {
            if (right.`val` == 0) {
                pNode.right = null
            }
        }
    }
}

/**
 * 题解： https://leetcode-cn.com/problems/binary-tree-pruning/solution/er-cha-shu-jian-zhi-by-leetcode/
 */
fun pruneTree1(root: TreeNode?): TreeNode? {
    return if (containsOne(root)) root else null
}

fun containsOne(node: TreeNode?): Boolean {
    if (node == null) return false
    val a1 = containsOne(node.left)
    val a2 = containsOne(node.right)
    if (!a1) node.left = null
    if (!a2) node.right = null
    return node.`val` == 1 || a1 || a2
}


