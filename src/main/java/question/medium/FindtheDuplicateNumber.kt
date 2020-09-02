package question.medium

import java.util.HashSet

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-02 13:44
 * @version V1.0
 *

    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

    There is only one duplicate number in nums, return this duplicate number.

    Follow-ups:

    How can we prove that at least one duplicate number must exist in nums? 
    Can you solve the problem without modifying the array nums?
    Can you solve the problem using only constant, O(1) extra space?
    Can you solve the problem with runtime complexity less than O(n2)?
     

    Example 1:

    Input: nums = [1,3,4,2,2]
    Output: 2
    Example 2:

    Input: nums = [3,1,3,4,2]
    Output: 3
    Example 3:

    Input: nums = [1,1]
    Output: 1
    Example 4:

    Input: nums = [1,1,2]
    Output: 1
     

    Constraints:

    2 <= n <= 3 * 104
    nums.length == n + 1
    1 <= nums[i] <= n
    All the integers in nums appear only once except for precisely one integer which appears two or more times.

 *
 */
fun main() {
    println(findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
    println(findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
    println(findDuplicate(intArrayOf(1, 1)))
    println(findDuplicate(intArrayOf(1, 1, 2)))
}


fun findDuplicate(nums: IntArray): Int {
    val set = HashSet<Int>()
    var repeat = -1
    for (num in nums) {
        if (!set.add(num)) {
            repeat = num
            break
        }
    }
    return repeat
}

/**
 * 二分查找
 * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
 */
fun findDuplicate1(nums: IntArray): Int {
    val n = nums.size
    var l = 1
    var r = n - 1
    var ans = -1
    while (l <= r) {
        val mid = l + r shr 1
        var cnt = 0
        for (i in 0 until n) {
            if (nums[i] <= mid) {
                cnt++
            }
        }
        if (cnt <= mid) {
            l = mid + 1
        } else {
            r = mid - 1
            ans = mid
        }
    }
    return ans

}
