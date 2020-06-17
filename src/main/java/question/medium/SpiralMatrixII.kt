package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-17 13:50
 * @version V1.0
 *
 *

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]
 *
 */
fun main() {
    generateMatrix(4).forEach {
        println(Arrays.toString(it))
    }
}

fun generateMatrix(n: Int): Array<IntArray> {
    var l = 0
    var r = n - 1
    var t = 0
    var b = n - 1
    val mat = Array(n) {
        IntArray(n)
    }
    var num = 1
    val tar = n * n
    while (num <= tar) {
        var i = l
        while (i <= r) {
            mat[t][i] = num++
            i++
        }
        t++

        i = t
        while (i <= b) {
            mat[i][r] = num++
            i++
        }
        r--

        i = r
        while (i >= l) {
            mat[b][i] = num++
            i--
        }
        b--

        i = b
        while (i >= t) {
            mat[i][l] = num++
            i--
        }
        l++
    }
    return mat
}
