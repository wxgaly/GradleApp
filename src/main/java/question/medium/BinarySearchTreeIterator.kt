package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-21 14:19
 * @version V1.0
 *
    Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

    Calling next() will return the next smallest number in the BST.

     

    Example:



    BSTIterator iterator = new BSTIterator(root);
    iterator.next();    // return 3
    iterator.next();    // return 7
    iterator.hasNext(); // return true
    iterator.next();    // return 9
    iterator.hasNext(); // return true
    iterator.next();    // return 15
    iterator.hasNext(); // return true
    iterator.next();    // return 20
    iterator.hasNext(); // return false
     

    Note:

    next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    You may assume that next() call will always be valid, that is,
    there will be at least a next smallest number in the BST when next() is called.

 *
 */
fun main() {
    val root = TreeNode(7)
    root.left = TreeNode(3)
    root.right = TreeNode(15)
    root.right?.left = TreeNode(9)
    root.right?.right = TreeNode(20)

    val iterator = BSTIterator(root)
    println(iterator.next())    // 返回 3
    println(iterator.next())    // 返回 7
    println(iterator.hasNext()) // 返回 true
    println(iterator.next())   // 返回 9
    println(iterator.hasNext()) // 返回 true
    println(iterator.next())   // 返回 15
    println(iterator.hasNext()) // 返回 true
    println(iterator.next())    // 返回 20
    println(iterator.hasNext()) // 返回 false

}

/**
 * 时间复杂度O(N)不符合要求
 */
class BSTIterator(root: TreeNode?) {

    private val list = arrayListOf<TreeNode>()
    private var iterator: MutableIterator<TreeNode>

    init {
        convertBST(root)
        iterator = list.iterator()
    }

    /** @return the next smallest number */
    fun next(): Int {
        return iterator.next().`val`
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return iterator.hasNext()
    }

    private fun convertBST(rootNode: TreeNode?) {
        if (rootNode == null) {
            return
        }

        convertBST(rootNode.left)
        list.add(rootNode)
        convertBST(rootNode.right)
    }

}

/**
 * 官方题解，
 * 拆解递归步骤
 * 初始化时将所有左树节点推入，找到最小值，
 * next的时候取出当前节点，然后推入右树节点
 * hasNext则是看栈是否为空
 */
class BSTIterator1(root: TreeNode?) {

    var stack: Stack<TreeNode> = Stack()

    init {
        leftmostInorder(root)
    }

    /** @return the next smallest number */
    fun next(): Int {
        val node = stack.pop()

        if (node.right != null) {
            leftmostInorder(node.right)
        }

        return node.`val`
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return this.stack.isNotEmpty()
    }

    private fun leftmostInorder(root: TreeNode?) {
        var temp = root
        while (temp != null) {
            stack.push(temp)
            temp = temp.left
        }
    }

}
