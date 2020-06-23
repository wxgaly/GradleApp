package question.medium

import java.util.*

/**
 *  question.medium.
 *
 *

    A full binary tree is a binary tree where each node has exactly 0 or 2 children.

    Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.

    Each node of each tree in the answer must have node.val = 0.

    You may return the final list of trees in any order.

     

    Example 1:

    Input: 7
    Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
    Explanation:

     

    Note:

    1 <= N <= 20
 *
 * @author Created by WXG on 2020-06-23 13:50
 * @version V1.0
 */
fun main() {

}

val memo = HashMap<Int, List<TreeNode?>>()

fun allPossibleFBT(N: Int): List<TreeNode?> {
    if (!memo.containsKey(N)) {
        val ans = LinkedList<TreeNode>()
        if (N == 1) {
            ans.add(TreeNode(0))
        } else if (N % 2 == 1) {
            for (x in 0 until N) {
                val y = N - 1 - x
                allPossibleFBT(x).forEach { left ->
                    allPossibleFBT(y).forEach { right ->
                        val bns = TreeNode(0)
                        bns.left = left
                        bns.right = right
                        ans.add(bns)
                    }
                }
            }

        }
        memo[N] = ans
    }

    return memo[N]!!
}



