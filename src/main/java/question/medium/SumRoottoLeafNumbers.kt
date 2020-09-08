package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-08 13:56
 * @version V1.0
 *

    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

    An example is the root-to-leaf path 1->2->3 which represents the number 123.

    Find the total sum of all root-to-leaf numbers.

    Note: A leaf is a node with no children.

    Example:

    Input: [1,2,3]
       1
      / \
     2  3
    Output: 25
    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.


 *
 */
fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    println(sumNumbers1(root))
}

fun sumNumbers(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val list = arrayListOf<TreeNode>()
    var sum = 0
    var temp = root
    while (true) {
        while (temp != null) {
            list.add(temp)
            if (temp.left == null && temp.right == null) {
                var x = 0
                val len = list.size - 1
                for (i in len downTo 0) {
                    x += list[i].`val` * pow(10, len - i)
                }
                sum += x
            }
            temp = temp.left
        }

        if (list.isEmpty()) {
            break
        }

        temp = list.removeAt(list.size - 1)
        temp = temp.right

    }

    return sum
}

fun pow(a: Int, b: Int): Int {
    var res = 1
    for (i in 0 until b) {
        res *= a
    }
    return res
}

/**
 * 想法还是有问题，应该使用递归
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/0-ms-jiao-ke-shu-ji-jie-da-by-liuzhaoce/
 */
fun sumNumbers1(root: TreeNode?): Int {
   return sumNumbersHepler(root, 0)
}

fun sumNumbersHepler(root: TreeNode?, i: Int): Int {
    if (root == null) {
        return 0
    }
    val temp = i * 10 + root.`val`
    if (root.left == null && root.right == null)
        return temp
    return sumNumbersHepler(root.left, temp) + sumNumbersHepler(root.right, temp)
}
