package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-29 14:20
 * @version V1.0
 *
    Given a binary tree with the following rules:

    root.val == 0
    If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
    If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
    Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

    You need to first recover the binary tree and then implement the FindElements class:

    FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
    bool find(int target) Return if the target value exists in the recovered binary tree.
     

    Example 1:



    Input
    ["FindElements","find","find"]
    [[[-1,null,-1]],[1],[2]]
    Output
    [null,false,true]
    Explanation
    FindElements findElements = new FindElements([-1,null,-1]);
    findElements.find(1); // return False
    findElements.find(2); // return True
    Example 2:



    Input
    ["FindElements","find","find","find"]
    [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
    Output
    [null,true,true,false]
    Explanation
    FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
    findElements.find(1); // return True
    findElements.find(3); // return True
    findElements.find(5); // return False
    Example 3:



    Input
    ["FindElements","find","find","find","find"]
    [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
    Output
    [null,true,false,false,true]
    Explanation
    FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
    findElements.find(2); // return True
    findElements.find(3); // return False
    findElements.find(4); // return False
    findElements.find(5); // return True
     

    Constraints:

    TreeNode.val == -1
    The height of the binary tree is less than or equal to 20
    The total number of nodes is between [1, 10^4]
    Total calls of find() is between [1, 10^4]
    0 <= target <= 10^6

 *
 */
fun main() {
    val root = TreeNode(-1)
    root.left = TreeNode(-1)
    root.right = TreeNode(-1)
    root.left!!.left = TreeNode(-1)
    root.left!!.right = TreeNode(-1)
    val findElements = FindElements(root)
    println(findElements.find(1))
    println(findElements.find(3))
    println(findElements.find(5))
}

class FindElements(var root: TreeNode?) {

    val set = HashSet<Int>()
    init {
        root?.apply {
            `val` = 0
            set.add(0)
        }
        restoreTree(root)
    }

    /**
     * 尝试剪枝处理，到那时没成功，效率较低
     */
    fun find(target: Int): Boolean {
        val stack = Stack<TreeNode?>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val node = stack.pop()
            if (node != null) {
                if (target != node.`val`) {
                    val left = node.`val` * 2 + 1

                    if (target < left) {
                        return false
                    } else {
                        stack.push(node.right)
                        stack.push(node.left)
                    }

                } else {
                    return true
                }
            }
        }

        return false
    }

    /**
     * 还原二叉树的时候就把所有的值记录到hashset中，因为有固定的运算规则，所以不会出现重复
     */
    fun find1(target: Int): Boolean {
        return set.contains(target)
    }

    private fun restoreTree(treeNode: TreeNode?) {
        if (treeNode != null) {
            if (treeNode.left != null) {
                val value = treeNode.`val` * 2 + 1
                treeNode.left!!.`val` = value
                set.add(value)
                restoreTree(treeNode.left)
            }
            if (treeNode.right != null) {
                val value = treeNode.`val` * 2 + 2
                treeNode.right!!.`val` = value
                set.add(value)
                restoreTree(treeNode.right)
            }
        }
    }

}
