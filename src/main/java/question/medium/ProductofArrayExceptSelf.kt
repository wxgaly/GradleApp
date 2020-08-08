package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-08 18:10
 * @version V1.0
 *
    Given an array nums of n integers where n > 1,  
    return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Example:

    Input:  [1,2,3,4]
    Output: [24,12,8,6]
    Constraint: It's guaranteed that the product of the elements of any prefix or
    suffix of the array (including the whole array) fits in a 32 bit integer.

    Note: Please solve it without division and in O(n).

    Follow up:
    Could you solve it with constant space complexity?
    (The output array does not count as extra space for the purpose of space complexity analysis.)

 *
 */
fun main() {
    println(Arrays.toString(productExceptSelf1(intArrayOf(1, 2, 3, 4))))
    println(Arrays.toString(productExceptSelf1(intArrayOf(1, 0))))
}

fun productExceptSelf(nums: IntArray): IntArray {
    var product = nums[0]
    val len = nums.size
    for (i in 1 until len) {
        if (nums[i] != 0) {
            product *= nums[i]
        }
    }

    val res = IntArray(len)
    for (i in 0 until len) {
        if (nums[i] == 0) {
            res[i] = product
        } else {
            res[i] = product / nums[i]
        }
    }

    return res
}

/**
 * 官方题解
 * https://leetcode-cn.com/problems/product-of-array-except-self/solution/chu-zi-shen-yi-wai-shu-zu-de-cheng-ji-by-leetcode-/
 */
fun productExceptSelf1(nums: IntArray): IntArray {
    val len = nums.size
    val res = IntArray(len)
    res[0] = 1
    for (i in 1 until len) {
        res[i] = nums[i - 1] * res[i - 1]
    }

    var R = 1
    for (i in len - 1 downTo 0) {
        res[i] = res[i] * R
        R *= nums[i]
    }

    return res
}
