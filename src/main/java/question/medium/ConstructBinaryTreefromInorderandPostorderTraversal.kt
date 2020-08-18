package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-18 13:48
 * @version V1.0
 *

    Given inorder and postorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.

    For example, given

    inorder = [9,3,15,20,7]
    postorder = [9,15,7,20,3]
    Return the following binary tree:

        3
       / \
      9  20
     /    \
    15    7


 *
 */
fun main() {

}

/**
 * 官方题解
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/cong-zhong-xu-yu-hou-xu-bian-li-xu-lie-gou-zao-e-5/
 */
class CBT {
    var post_idx_cbt = 0
    lateinit var postorder: IntArray
    lateinit var inorder: IntArray
    val idx_map = hashMapOf<Int, Int>()

    fun cbt_helper(in_left: Int, in_right: Int): TreeNode? {
        if (in_left > in_right)
            return null
        val root_val = postorder[post_idx_cbt]
        val root = TreeNode(root_val)

        // root splits inorder list
        // into left and right subtrees
        val index = idx_map[root_val]
        post_idx_cbt--
        root.right = cbt_helper(index!! + 1, in_right)
        root.left = cbt_helper(in_left, index - 1)
        return root
    }

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        this.postorder = postorder
        this.inorder = inorder

        this.post_idx_cbt = postorder.size - 1
        var idx = 0
        for (i in inorder) {
            idx_map[i] = idx++
        }
        return cbt_helper(0, inorder.size - 1)
    }
}


