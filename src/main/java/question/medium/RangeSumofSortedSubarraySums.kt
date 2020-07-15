package question.medium

import java.util.*


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-15 14:04
 * @version V1.0
 *
    Given the array nums consisting of n positive integers. You computed the sum of all non-empty continous subarrays
    from the array and then sort them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.

    Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array.
     Since the answer can be a huge number return it modulo 10^9 + 7.

     

    Example 1:

    Input: nums = [1,2,3,4], n = 4, left = 1, right = 5
    Output: 13
    Explanation: All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in non-decreasing
    order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.
    Example 2:

    Input: nums = [1,2,3,4], n = 4, left = 3, right = 4
    Output: 6
    Explanation: The given array is the same as example 1. We have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10].
    The sum of the numbers from index le = 3 to ri = 4 is 3 + 3 = 6.
    Example 3:

    Input: nums = [1,2,3,4], n = 4, left = 1, right = 10
    Output: 50
     

    Constraints:

    1 <= nums.length <= 10^3
    nums.length == n
    1 <= nums[i] <= 100
    1 <= left <= right <= n * (n + 1) / 2

 *
 */
fun main() {
    println(rangeSum(intArrayOf(1, 2, 3, 4), 4, 1, 5))
    println(rangeSum(intArrayOf(1, 2, 3, 4), 4, 3, 4))
    println(rangeSum(intArrayOf(1, 2, 3, 4), 4, 1, 10))
}


fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
    //记录所有和的数组，后续需要排序计算区间和
    val sumList = arrayListOf<Int>()
    val len = nums.size
    for (i in 0 until len) {
        //记录每次单独元素的和
        var sum = nums[i]
        sumList.add(sum)
        for (j in i + 1 until len) {
            //减少重复计算，每次将和保留
            sum += nums[j]
            sumList.add(sum)
        }
    }
    sumList.sort()

    var sum = 0
    for (i in left - 1 until right) {
        sum += sumList[i]
    }

    return sum
}


fun backtrack(list: MutableList<List<Int>>, tempList: MutableList<Int>, nums: IntArray) {
    //一个终结条件，也就是满足条件的时候
    if (tempList.size == nums.size) {
        //全局变量添加一个满足条件的集合
        list.add(ArrayList(tempList))
    } else {
        for (i in 0 until nums.size) {
            val num = nums[i]
            if (tempList.contains(num)) continue
            //如果tempList没有包含nums[i]才添加
            tempList.add(num)
            //递归调用，此时的tempList一直在变化，直到满足终结条件才结束
            backtrack(list, tempList, nums)
            println("tempList的内容:$tempList-------i的值:$i")
            //它移除tempList最后一个元素的作用就是返回上一次调用时的数据，也就是希望返回之前的节点再去重新搜索满足条件。这样才能实现回溯
            tempList.removeAt(tempList.size - 1)
        }
    }
}
