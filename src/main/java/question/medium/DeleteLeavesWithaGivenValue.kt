package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-31 13:58
 * @version V1.0
 *
    Given a binary tree root and an integer target, delete all the leaf nodes with value target.

    Note that once you delete a leaf node with value target, 
    if it's parent node becomes a leaf node and has the value target,
    it should also be deleted (you need to continue doing that until you can't).

     

    Example 1:



    Input: root = [1,2,3,2,null,2,4], target = 2
    Output: [1,null,3,null,4]
    Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
    After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
    Example 2:



    Input: root = [1,3,3,3,2], target = 3
    Output: [1,3,null,null,2]
    Example 3:



    Input: root = [1,2,null,2,null,2], target = 2
    Output: [1]
    Explanation: Leaf nodes in green with value (target = 2) are removed at each step.
    Example 4:

    Input: root = [1,1,1], target = 1
    Output: []
    Example 5:

    Input: root = [1,2,3], target = 1
    Output: [1,2,3]
     

    Constraints:

    1 <= target <= 1000
    The given binary tree will have between 1 and 3000 nodes.
    Each node's value is between [1, 1000].

 *
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right?.left = TreeNode(2)
    root.right?.right = TreeNode(4)
    val node = removeLeafNodes(root, 2)
    println(node?.`val`)
}

fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
    if (root == null) {
        return null
    }
    root.left = removeLeafNodes(root.left, target)
    root.right = removeLeafNodes(root.right, target)
    if (root.left == null && root.right == null && root.`val` == target) {
        return null
    }
    return root
}

/**
 * 忽略了回溯，只是一直向下，应该到下之后再上来
 */
fun firstOrder(parentNode: TreeNode?, leftNode: TreeNode?, rightNode: TreeNode?, target: Int) {
    if (leftNode != null) {
        if (leftNode.left == null && leftNode.right == null && leftNode.`val` == target) {
            if (parentNode?.left != null) {
                if (parentNode.left?.`val` == target) {
                    parentNode.left = null
                }
            }
        } else {
            firstOrder(parentNode?.right, parentNode?.right?.left, parentNode?.right?.right, target)
        }
    }
    if (rightNode != null) {
        if (rightNode.left == null && rightNode.right == null && rightNode.`val` == target) {
            if (parentNode?.right != null) {
                if (parentNode.right?.`val` == target) {
                    parentNode.right = null
                }
            }
        } else {
            firstOrder(parentNode?.left, parentNode?.left?.left, parentNode?.left?.right, target)
        }
    }
}
