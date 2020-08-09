package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-09 15:06
 * @version V1.0
 *
    Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

     

    Example 1:

    Input: matrix =
    [
      [0,1,1,1],
      [1,1,1,1],
      [0,1,1,1]
    ]
    Output: 15
    Explanation:
    There are 10 squares of side 1.
    There are 4 squares of side 2.
    There is  1 square of side 3.
    Total number of squares = 10 + 4 + 1 = 15.
    Example 2:

    Input: matrix =
    [
    [1,0,1],
    [1,1,0],
    [1,1,0]
    ]
    Output: 7
    Explanation:
    There are 6 squares of side 1.
    There is 1 square of side 2.
    Total number of squares = 6 + 1 = 7.
     

    Constraints:

    1 <= arr.length <= 300
    1 <= arr[0].length <= 300
    0 <= arr[i][j] <= 1

 *
 */
fun main() {
    println(countSquares1(arrayOf(
            intArrayOf(0, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(0, 1, 1, 1)
    )))

    println(countSquares1(arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0)
    )))
}

/**
 * 暴力解法，kotlin用了800ms
 *
 */
fun countSquares(matrix: Array<IntArray>): Int {
    val row = matrix.size
    val col = matrix[0].size
    val size = Math.min(row, col)
    var count = 0
    for (i in 1..size) {
        val res = countSquare(matrix, i)
        println(res)
        count += res
    }
    return count
}

fun countSquare(matrix: Array<IntArray>, size: Int): Int {
    var res = 0
    val row = matrix.size
    val col = matrix[0].size
    for (r in 0..row - size) {
        for (c in 0..col - size) {
            if (isSquare(matrix, r, c, size)) {
                res++
            }
        }
    }
    return res
}

fun isSquare(matrix: Array<IntArray>, r: Int, c: Int, size: Int): Boolean {
    for (r1 in r until r + size) {
        for (c1 in c until c + size) {
            if (matrix[r1][c1] != 1) {
                return false
            }
        }
    }
    return true
}

/**
 * 官方题解
 * https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
 * 只能说，我是个傻子。。。
 */
fun countSquares1(matrix: Array<IntArray>): Int {
    val m = matrix.size
    val n = matrix[0].size
    val f = Array(m) {
        IntArray(n)
    }
    var ans = 0
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (i == 0 || j == 0) {
                f[i][j] = matrix[i][j]
            } else if (matrix[i][j] == 0) {
                f[i][j] = 0
            } else {
                f[i][j] = Math.min(Math.min(f[i][j - 1], f[i - 1][j]), f[i - 1][j - 1]) + 1
            }
            ans += f[i][j]
        }
    }
    return ans
}
