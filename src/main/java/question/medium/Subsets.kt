package question.medium

/**
 *  question.medium.
 *
 *
    Given a set of distinct integers, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: nums = [1,2,3]
    Output:
    [
    [3],
      [1],
      [2],
      [1,2,3],
      [1,3],
      [2,3],
      [1,2],
      []
    ]

 *
 * @author Created by WXG on 2020-06-24 14:18
 * @version V1.0
 */
fun main() {

}

fun subsets(nums: IntArray): List<List<Int>> {
    val output: MutableList<MutableList<Int>> = mutableListOf()
    output.add(mutableListOf())
    for (num in nums) {
        val newSubsets: MutableList<MutableList<Int>> = mutableListOf()
        output.forEach {
            val temp = mutableListOf<Int>()
            temp.addAll(it)
            temp.add(num)
            newSubsets.add(temp)
        }

        newSubsets.forEach {
            output.add(it)
        }
    }
    return output
}

fun getSubsets(set: List<Int>, index: Int): MutableList<MutableList<Int>> {
    var allSets: MutableList<MutableList<Int>> = mutableListOf()
    if (set.size == index) {
        allSets.add(mutableListOf())
    } else {
        allSets = getSubsets(set, index + 1)
        val item = set[index]
        var moresubsets: MutableList<MutableList<Int>> = mutableListOf()
        allSets.forEach {
            val newsubset = mutableListOf<Int>()
            newsubset.addAll(it)
            newsubset.add(item)
            moresubsets.add(newsubset)
        }
        allSets.addAll(moresubsets)
    }
    return allSets
}

