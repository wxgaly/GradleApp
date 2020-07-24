package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-24 17:04
 * @version V1.0
 *
    Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Example:

    Given the sorted linked list: [-10,-3,0,5,9],

    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

            0
           / \
        -3   9
        /   /
     -10   5
 *
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val head = ListNode(-10)
    head.next = ListNode(-3)
    head.next?.next = ListNode(0)
    head.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next = ListNode(9)

    midPrint(sortedListToBST1(head))
}
val listRes = arrayListOf<Int>()
/**
 * 解题思路：
 * 1. 二叉搜索树的特点是每个节点的左节点小于当前节点，右节点大于当前节点；
 * 2. 二叉搜索树的中序遍历是递增数组；
 *
 * 所以，需要先将链表转成数组
 * 找到中间节点作为二叉搜索树的根节点
 * 然后用左右两个指针，分别给左节点和右节点赋值
 *
 * 循环使用的有些问题，使用遍历应该
 */
fun sortedListToBST(head: ListNode?): TreeNode? {
    //一趟遍历，将链表转成数组

    var temp = head
    while (temp != null) {
        listRes.add(temp.`val`)
        temp = temp.next
    }

    if (listRes.isEmpty()) {
        return null
    }
    val mid = listRes.size / 2
    if (mid == 0) {
        return TreeNode(listRes[0])
    }
    var left = mid - 1
    var right = listRes.size - 1

    var leftOver = false
    var rightOver = false

    val root = TreeNode(listRes[mid])
    var leftNode = TreeNode(listRes[left])
    var rightNode = TreeNode(listRes[right])

    root.left = leftNode
    root.right = rightNode
    left--
    right--

    //从中间节点开始，左子树从中间递减，右子树从末尾递减到中间节点
    while (true) {
        if (left < 0) {
            leftOver = true
        } else {
            leftNode.left = TreeNode(listRes[left])
            leftNode = leftNode.left!!
            left--
        }

        if (right <= mid) {
            rightOver = true
        } else {
            rightNode.left = TreeNode(listRes[right])
            rightNode = rightNode.left!!
            right--
        }

        if (leftOver && rightOver) {
            break
        }
    }

    return root
}

fun sortedListToBST1(head: ListNode?): TreeNode? {
    var temp = head
    while (temp != null) {
        listRes.add(temp.`val`)
        temp = temp.next
    }

    return convertListToBST(0, listRes.size - 1)
}

fun convertListToBST(left: Int, right: Int):TreeNode? {
    if (left > right) {
        return null
    }

    val mid = (left + right) / 2
    val node = TreeNode(listRes[mid])

    if (left == right) {
        return node
    }

    node.left = convertListToBST(left, mid - 1)
    node.right = convertListToBST(mid + 1, right)
    return node
}

fun midPrint(root: TreeNode?) {
    var temp = root
    if (temp != null) {
        midPrint(temp.left)
        println(temp.`val`)
        midPrint(temp.right)
    }
}
