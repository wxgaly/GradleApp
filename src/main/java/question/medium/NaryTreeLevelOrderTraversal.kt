package question.medium

import java.util.*
import kotlin.collections.ArrayList

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-13 14:55
 * @version V1.0
 *

    Given an n-ary tree, return the level order traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal,
    each group of children is separated by the null value (See examples).

     

    Example 1:



    Input: root = [1,null,3,2,4,null,5,6]
    Output: [[1],[3,2,4],[5,6]]
    Example 2:



    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
    Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
     

    Constraints:

    The height of the n-ary tree is less than or equal to 1000
    The total number of nodes is between [0, 10^4]


 *
 */
fun main() {

}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

fun levelOrder(root: Node?): List<List<Int>> {
    if (root == null) return emptyList()
    val queue = LinkedList<Node?>()
    queue.push(root)
    val res = arrayListOf<ArrayList<Int>>()
    while (queue.isNotEmpty()) {
        val resList = ArrayList<Int>()
        val size = queue.size
        for (i in 0 until size) {
            val node = queue.poll()
            node?.apply {
                resList.add(`val`)
                queue.addAll(children)
            }
        }
        res.add(resList)
    }
    return res
}
