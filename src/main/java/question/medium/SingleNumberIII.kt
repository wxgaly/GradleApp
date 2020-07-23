package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-23 11:30
 * @version V1.0
 *
    Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
    Find the two elements that appear only once.

    Example:

    Input:  [1,2,1,3,2,5]
    Output: [3,5]
    Note:

    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 *
 */
fun main() {
    println(Arrays.toString(singleNumber(intArrayOf(1, 2, 1, 3, 2, 5))))
}

/**
 * 没想出来位运算，通过异或的方式
 * 官方题解： https://leetcode-cn.com/problems/single-number-iii/solution/zhi-chu-xian-yi-ci-de-shu-zi-iii-by-leetcode/
 */
fun singleNumber(nums: IntArray): IntArray {
    val hashMap = mutableMapOf<Int, Int>()
    for (num in nums) {
        var count = hashMap[num]
        if (count != null) {
            hashMap[num] = ++count
        } else {
            hashMap[num] = 1
        }
    }

    val list = mutableListOf<Int>()
    hashMap.forEach { t, u ->
        if (u == 1) {
            list.add(t)
        }
    }
    val len = list.size
    val res = IntArray(len)
    for (i in 0 until len) {
        res[i] = list[i]
    }
    return res
}
