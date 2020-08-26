package question.medium

import java.util.HashMap

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-26 13:50
 * @version V1.0
 *

    Given a non-empty array of integers, every element appears three times except for one,
    which appears exactly once. Find that single one.

    Note:

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:

    Input: [2,2,3,2]
    Output: 3
    Example 2:

    Input: [0,1,0,1,0,1,99]
    Output: 99


 *
 */
fun main() {
    println(singleNumberII1(intArrayOf(2, 2, 3, 2)))
}

fun singleNumberII(nums: IntArray): Int {
    val hashmap = HashMap<Int, Int>()
    for (num in nums)
        hashmap[num] = hashmap.getOrDefault(num, 0) + 1

    for (k in hashmap.keys)
        if (hashmap[k] == 1) return k
    return -1
}

fun singleNumberII1(nums: IntArray): Int {
    var seenOnce = 0
    var seenTwice = 0
    for (num in nums) {
        seenOnce = seenTwice.inv() and (seenOnce xor num)
        seenTwice = seenOnce.inv() and (seenTwice xor num)
    }
    return seenOnce
}
