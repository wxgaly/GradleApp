package question.medium

import java.util.*
import java.util.LinkedList
import java.util.ArrayList


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-14 14:20
 * @version V1.0
 *
    Given a collection of distinct integers, return all possible permutations.

    Example:

    Input: [1,2,3]
    Output:
    [
    [1,2,3],
    [1,3,2],
    [2,1,3],
    [2,3,1],
    [3,1,2],
    [3,2,1]
    ]

 *
 */
fun main() {
    permute(intArrayOf(1, 2, 3)).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
}

fun backtrack(n: Int, output: ArrayList<Int>, res: MutableList<MutableList<Int>>, first: Int) {
    // 所有数都填完了
    if (first == n)
        res.add(ArrayList(output))
    var i = first
    while (i < n) {
        // 动态维护数组
        Collections.swap(output, first, i)
        // 继续递归填下一个数
        backtrack(n, output, res, first + 1)
        // 撤销操作
        Collections.swap(output, first, i)
        i++
    }
}

fun permute1(nums: IntArray): List<List<Int>> {
    val res = LinkedList<MutableList<Int>>()
    val output = ArrayList<Int>()
    for (num in nums) {
        output.add(num)
    }
    val n = nums.size
    backtrack(n, output, res, 0)
    return res
}

fun permute(nums: IntArray): List<List<Int>> {
    val len = nums.size
    val res = arrayListOf<MutableList<Int>>()
    for (i in 0 until len) {
        val list = mutableListOf<Int>()
        list.add(nums[i])
        for (j in 0 until len) {
            if (i != j) {
                list.add(nums[j])
            }
        }
        res.add(list)
    }

    return res
}
