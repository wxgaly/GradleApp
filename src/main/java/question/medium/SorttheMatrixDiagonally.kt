package question.medium

import java.util.*


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-30 16:42
 * @version V1.0
 *
    Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.

     

    Example 1:


    Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
    Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
     

    Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 100
    1 <= mat[i][j] <= 100

 *
 */
fun main() {
    val mat = arrayOf(intArrayOf(3, 3, 1, 1), intArrayOf(2, 2, 1, 2), intArrayOf(1, 1, 1, 2))
    mat.forEach { arr ->
        println(Arrays.toString(arr))
    }

    diagonalSort(mat)

    mat.forEach { arr ->
        println(Arrays.toString(arr))
    }

}

class Item(var j: Int = 0, var i: Int = 0, var value: Int = 0) : Comparable<Item> {
    override fun compareTo(other: Item): Int =
            if (value > other.value) {
                1
            } else {
                -1
            }

    override fun toString(): String {
        return "Item(j=$j, i=$i, value=$value)"
    }

}

fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    val row = mat.size
    val col = mat[0].size
    val res = Array(row) {
        IntArray(col)
    }

    var j = 0
    //横方向遍历
    for (i in 0 until col) {
        val set = hashSetOf<Item>()
        while (j < row) {
            set.add(Item(j, i, mat[j][i]))
            j++
        }

        j = 0
        var index = 0
        set.forEach {
            mat[j][index] = it.value
            index++
            j++
        }
        j = 0
    }

    //纵方向遍历
    j = 0
    for (i in 0 until row) {
        val set = hashSetOf<Item>()
        while (j < col) {
            set.add(Item(i, j, mat[i][j]))
            j++
        }

        j = 0
        var index = 0
        set.forEach {
            mat[j][index] = it.value
            index++
            j++
        }
        j = 0
    }

    return mat
}

fun diagonalSort1(mat: Array<IntArray>): Array<IntArray> {
    // 行数
    val m = mat.size
    // 列数
    val n = mat[0].size
    // 主对角线的条数
    val dLen = m + n - 1

    // 每一条对角线都创建一个动态数组
    val diagonal = Array<MutableList<Int>>(dLen) {
        mutableListOf()
    }

    // 遍历原始矩阵，把原始矩阵中的元素放进对应的动态数组中
    // 主对角线上元素的特点是：纵坐标 - 横坐标 = 定值
    // 加上偏移 m - 1 是为了能够放进数组中
    for (i in 0 until m) {
        for (j in 0 until n) {
            diagonal[j - i + (m - 1)].add(mat[i][j])
        }
    }

    // 对每一个对角线上的动态数组分别进行升序排序
    for (i in 0 until dLen) {
        diagonal[i].sort()
    }

    val res = Array(m) { IntArray(n) }

    // 对角线数组上还未取出的元素的下标，初始化的时候均为 0
    val next = IntArray(dLen)
    for (i in 0 until m) {
        for (j in 0 until n) {
            // 对角线的坐标
            val index = j - i + (m - 1)
            // 记录结果
            res[i][j] = diagonal[index][next[index]]
            // 维护 next 数组的值
            next[index]++
        }
    }

    return res
}


