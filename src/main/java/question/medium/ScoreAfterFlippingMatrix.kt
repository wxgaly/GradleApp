package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-20 14:10
 * @version V1.0
 *

    We have a two dimensional matrix A where each value is 0 or 1.

    A move consists of choosing any row or column, and toggling each value in that row or column:
    changing all 0s to 1s, and all 1s to 0s.

    After making any number of moves, every row of this matrix is interpreted as a binary number,
    and the score of the matrix is the sum of these numbers.

    Return the highest possible score.

     

    Example 1:

    Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
    Output: 39
    Explanation:
    Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
    0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
     

    Note:

    1 <= A.length <= 20
    1 <= A[0].length <= 20
    A[i][j] is 0 or 1.

 *
 */
fun main() {
    println(matrixScore(arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(1, 1, 0, 0)
    )))

    println(matrixScore(arrayOf(
            intArrayOf(0)
    )))

    println(matrixScore(arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(0, 1)
    )))
}

fun matrixScore(A: Array<IntArray>): Int {
    //先扫描横列是否为最大值
    val row = A.size
    val col = A[0].size
    for (i in 0 until row) {
        //贪心，首位不是1，那该列需要翻转
        if (A[i][0] == 0) {
            for (j in 0 until col) {
                if (A[i][j] == 0) {
                    A[i][j] = 1
                } else {
                    A[i][j] = 0
                }
            }
        }
    }

    //查看转换结果
    A.forEach { arr ->
        println(Arrays.toString(arr))
    }

    //在转换纵列
    for (i in 0 until col) {
        //判断0的个数是否过半，
        var count = 0
        for (j in 0 until row) {
            if (A[j][i] == 0) {
                count++
            }
        }

        if (count >= (row + 1) / 2) {
            for (j in 0 until row) {
                if (A[j][i] == 0) {
                    A[j][i] = 1
                } else {
                    A[j][i] = 0
                }
            }
        }
    }

    println("----------")

    //查看转换结果
    A.forEach { arr ->
        println(Arrays.toString(arr))
    }

    var sum = 0

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (A[i][j] == 1) {
                sum += Math.pow(2.0, (col - j - 1).toDouble()).toInt()
            }
        }
    }

    return sum
}

/**
 * 通过异或翻转数值
 */
fun matrixScore1(A: Array<IntArray>): Int {
    val R = A.size
    val C = A[0].size
    var ans = 0

    for (c in 0 until C) {
        var col = 0
        for (r in 0 until R) {
            col += A[r][c] xor A[r][0]
        }
        ans += Math.max(col, R - col) * (1 shl (C - c - 1))
    }

    return ans
}

