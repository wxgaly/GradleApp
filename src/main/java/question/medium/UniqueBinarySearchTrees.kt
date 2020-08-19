package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-19 13:52
 * @version V1.0
 *

    Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

    Example:

    Input: 3
    Output: 5
    Explanation:
    Given n = 3, there are a total of 5 unique BST's:

    1         3      3           2           1
     \        /      /          / \           \
     3      2       1          1   3           2
    /     /         \                           \
   2      1          2                           3
     

    Constraints:

    1 <= n <= 19

 *
 */
fun main() {

}

/**
 * 这是个动态规划的问题，自己没写出来。。。
 */
fun numTrees(n: Int): Int {
    if (n <= 0) {
        return 0
    }
    val list = IntArray(n)
    for (i in 1..n) {
        list[i - 1] = i
    }
    var count = 0

    return count
}

/**
 * 但是动态规划的时间复杂度是O(n2)，所以数学法牛皮，当然面向测试用例编程才是更牛批的。
 * 以下是数学法解法：
 * https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
 */
fun numTrees1(n: Int): Int {
    var C = 1L
    for (i in 0 until n) {
        C = C * 2 * (2 * i + 1) / (i + 2)
    }
    return C.toInt()
}

