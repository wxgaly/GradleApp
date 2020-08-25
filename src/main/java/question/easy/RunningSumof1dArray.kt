package question.easy

import java.util.*

/**
 *  question.easy.
 *
 * @author Created by WXG on 2020-08-25 21:54
 * @version V1.0
 *

    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

    Return the running sum of nums.

     

    Example 1:

    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
    Example 2:

    Input: nums = [1,1,1,1,1]
    Output: [1,2,3,4,5]
    Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
    Example 3:

    Input: nums = [3,1,2,10,1]
    Output: [3,4,6,16,17]
     

    Constraints:

    1 <= nums.length <= 1000
    -10^6 <= nums[i] <= 10^6


 *
 */
fun main() {
    println(Arrays.toString(runningSum(intArrayOf(1, 1, 1, 1, 1))))
    println(Arrays.toString(runningSum(intArrayOf(1, 2, 3, 4))))
    println(Arrays.toString(runningSum(intArrayOf(3, 1, 2, 10, 1))))
}

fun runningSum(nums: IntArray): IntArray {
    val size = nums.size
    val sums = IntArray(size)
    sums[0] = nums[0]
    for (i in 1 until size) {
        sums[i] = sums[i - 1] + nums[i]
    }
    return sums
}

fun runningSum1(nums: IntArray): IntArray {
    val size = nums.size
    for (i in 1 until size) {
        nums[i] = nums[i - 1] + nums[i]
    }
    return nums
}
