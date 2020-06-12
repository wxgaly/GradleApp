package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-12 13:52
 * @version V1.0
 *

Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes,
write a method to rotate the image by 90 degrees. Can you do this in place?

 

Example 1:

Given matrix =
[
[1,2,3],
[4,5,6],
[7,8,9]
],

Rotate the matrix in place. It becomes:
[
[7,4,1],
[8,5,2],
[9,6,3]
]
Example 2:

Given matrix =
[
[ 5, 1, 9,11],
[ 2, 4, 8,10],
[13, 3, 6, 7],
[15,14,12,16]
],

Rotate the matrix in place. It becomes:
[
[15,13, 2, 5],
[14, 3, 4, 1],
[12, 6, 8, 9],
[16, 7,10,11]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 *
 */

fun main() {
    val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
    )
    rotate(matrix)

    matrix.forEach {
        println(Arrays.toString(it))
    }
}

fun rotate(matrix: Array<IntArray>): Unit {
    var tR = 0
    var tC = 0
    var dR = matrix.size - 1
    var dC = matrix[0].size - 1
    while (tR <= dR) {
        rotateEdge(matrix, tR++, tC++, dR--, dC--)
    }

}

/**
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/xuan-zhuan-ju-zhen-by-leetcode-solution/
 */
//顺时针旋转90度打印
fun rotateEdge(matrix: Array<IntArray>, tR: Int, tC: Int, dR: Int, dC: Int) {
    // TODO Auto-generated method stub
    val times = dC - tC  // timies就是总的组数
    var temp = 0
    var i = 0
    while (i != times) {
        //一次循环就是一组调整
        temp = matrix[tR][tC + i]
        matrix[tR][tC + i] = matrix[dR - i][tC]
        matrix[dR - i][tC] = matrix[dR][dC - i]
        matrix[dR][dC - i] = matrix[tR + i][dC]
        matrix[tR + i][dC] = temp
        i++
    }

}
