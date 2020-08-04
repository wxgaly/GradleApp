package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-04 14:52
 * @version V1.0
 *
    Given a m * n matrix mat and an integer K,
    return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K,
    j - K <= c <= j + K, and (r, c) is a valid position in the matrix.
     

    Example 1:

    Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
    Output: [[12,21,16],[27,45,33],[24,39,28]]
    Example 2:

    Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
    Output: [[45,45,45],[45,45,45],[45,45,45]]
     

    Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n, K <= 100
    1 <= mat[i][j] <= 100

 *
 */
fun main() {
    val mat = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))

    printfArr(matrixBlockSum1(mat, 1))
    printfArr(matrixBlockSum1(mat, 2))
}

fun printfArr(array: Array<IntArray>) {
    array.forEach { arr ->
        arr.forEach {
            print("$it, ")
        }
        println()
    }
}

fun matrixBlockSum(mat: Array<IntArray>, K: Int): Array<IntArray> {
    val row = mat.size
    val col = mat[0].size
    val res = Array(row) {
        IntArray(col)
    }

    for (i in 0 until row) {
        for (j in 0 until col) {
            val startR = Math.max(i - K, 0)
            val endR = Math.min(i + K, row - 1)
            val startC = Math.max(j - K, 0)
            val endC = Math.min(j + K, col - 1)
            //此处可以优化，将之前计算的和都映射起来
            res[i][j] = getTotal(startR, endR, startC, endC, mat)
        }
    }

    return res
}

fun getTotal(startR: Int, endR: Int, startC: Int, endC: Int, mat: Array<IntArray>): Int {
    var sum = 0
    for (i in startR..endR) {
        for (j in startC..endC) {
            sum += mat[i][j]
        }
    }
    return sum
}

/**
 * 官方题解，数组前缀和
 *
 * sum = P[i + K + 1][j + K + 1] - P[i - K][j + K + 1] - P[i + K + 1][j - K] + P[i - K][j - K]
 */
fun matrixBlockSum1(mat: Array<IntArray>, K: Int): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    val P = Array(m + 1) {
        IntArray(n + 1)
    }
    for (i in 1..m) {
        for (j in 1..n) {
            P[i][j] = P[i - 1][j] + P[i][j - 1] - P[i - 1][j - 1] + mat[i - 1][j - 1]
        }
    }

    val ans = Array(m) {
        IntArray(n)
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            ans[i][j] = getIndex(P, m, n, i + K + 1, j + K + 1) - getIndex(P, m, n, i - K, j + K + 1) - getIndex(P, m, n, i + K + 1, j - K) + getIndex(P, m, n, i - K, j - K)
        }
    }
    return ans
}

//辅助函数
fun getIndex(pre: Array<IntArray>, m: Int, n: Int, x: Int, y: Int): Int {
    val xIndex = Math.max(Math.min(x, m), 0)
    val yIndex = Math.max(Math.min(y, n), 0)
    return pre[xIndex][yIndex]
}

