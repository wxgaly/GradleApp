package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-18 14:18
 * @version V1.0
 *
    Given a non negative integer number num.
    For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

    Example 1:

    Input: 2
    Output: [0,1,1]
    Example 2:

    Input: 5
    Output: [0,1,1,2,1,2]

 *
 */
fun main() {
    println(Arrays.toString(countBits(2)))
    println(Arrays.toString(countBits(5)))
    println(Arrays.toString(countBits(15)))
    println(Arrays.toString(countBits(31)))
}

fun countBits(num: Int): IntArray {
    val res = IntArray(num + 1)
    for (i in 1..num) {
        val str = i.toString(2)
        val len = str.length
        var count = 0
        for (j in 0 until len) {
            if (str[j] == '1') {
                count++
            }
        }
        res[i] = count
    }
    return res
}

/**
 * 官网题解，第二种
 * https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
 *
 * 动态规划的方法得找到状态转移公式，找规律
 */
fun countBits1(num: Int): IntArray {
    val res = IntArray(num + 1)
    var i = 0
    var b = 1
    while (b <= num) {
        while (i < b && i + b <= num) {
            res[i + b] = res[i] + 1
            ++i
        }
        i = 0
        b = b.shl(1)
    }
    return res
}
