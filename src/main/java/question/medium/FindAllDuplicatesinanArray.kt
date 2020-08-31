package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-27 11:10
 * @version V1.0
 *

    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

    Find all the elements that appear twice in this array.

    Could you do it without extra space and in O(n) runtime?

    Example:
    Input:
    [4,3,2,7,8,2,3,1]

    Output:
    [2,3]


 *
 */
fun main() {
    findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)).forEach {
        print("$it, ")
    }
}

fun findDuplicates(nums: IntArray): List<Int> {
    if (nums.isEmpty()) {
        return emptyList()
    }

    val map = hashMapOf<Int, Int>()
    for (num in nums) {
        val value = map.getOrDefault(num, 0)
        map[num] = value + 1
    }

    val res = arrayListOf<Int>()
    map.forEach { t, u ->
        if (u == 2) {
            res.add(t)
        }
    }

    return res
}
