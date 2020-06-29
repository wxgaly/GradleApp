package question.medium


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-29 14:02
 * @version V1.0
 *

    Given two binary search trees root1 and root2.

    Return a list containing all the integers from both trees sorted in ascending order.


    Example 1:


    Input: root1 = [2,1,4], root2 = [1,0,3]
    Output: [0,1,1,2,3,4]
    Example 2:

    Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
    Output: [-10,0,0,1,2,5,7,10]
    Example 3:

    Input: root1 = [], root2 = [5,1,7,0,2]
    Output: [0,1,2,5,7]
    Example 4:

    Input: root1 = [0,-10,10], root2 = []
    Output: [-10,0,10]
    Example 5:


    Input: root1 = [1,null,8], root2 = [8,1]
    Output: [1,1,8,8]
     

    Constraints:

    Each tree has at most 5000 nodes.
    Each node's value is between [-10^5, 10^5].

 *
 */
fun main() {
    testMerge(arrayListOf(-10, 0, 10), arrayListOf(0, 1, 2, 5, 7))
}

fun testMerge(list1: List<Int>, list2: List<Int>) {
    val res = mutableListOf<Int>()
    var index1 = 0
    var index2 = 0

    while (index1 < list1.size && index2 < list2.size) {
        if (list1[index1] < list2[index2]) {
            res.add(list1[index1])
            index1++
        } else {
            res.add(list2[index2])
            index2++
        }
    }

    if (index1 < list1.size) {
        for (i in index1 until list1.size) {
            res.add(list1[i])
        }
    }

    if (index2 < list2.size) {
        for (i in index2 until list2.size) {
            res.add(list2[i])
        }
    }

    res.forEach {
        print("$it, ")
    }
}

fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    middleTraversal(root1, list1)
    middleTraversal(root2, list2)

    val res = mutableListOf<Int>()
    var index1 = 0
    var index2 = 0

    while (index1 < list1.size && index2 < list2.size) {
        if (list1[index1] < list2[index2]) {
            res.add(list1[index1])
            index1++
        } else {
            res.add(list2[index2])
            index2++
        }
    }

    if (index1 < list1.size) {
        for (i in index1 until list1.size) {
            res.add(list1[i])
        }
    }

    if (index2 < list2.size) {
        for (i in index2 until list2.size) {
            res.add(list2[i])
        }
    }

    return res
}


fun middleTraversal(root: TreeNode?, list: MutableList<Int>) {
    root?.let {
        middleTraversal(root.left, list)
        list.add(root.`val`)
        middleTraversal(root.right, list)
    }
}

