package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-14 14:03
 * @version V1.0
 *

    Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
    find all unique combinations in candidates where the candidate numbers sums to target.

    The same repeated number may be chosen from candidates unlimited number of times.

    Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:

    Input: candidates = [2,3,6,7], target = 7,
    A solution set is:
    [
    [7],
    [2,2,3]
    ]
    Example 2:

    Input: candidates = [2,3,5], target = 8,
    A solution set is:
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]
     

    Constraints:

    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    Each element of candidate is unique.
    1 <= target <= 500

 *
 */
fun main() {
    combinationSum(intArrayOf(2, 3, 6, 7), 7).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
}

val sumRes = arrayListOf<List<Int>>()

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    candidates.sort()
    backtrackSum(candidates, target, 0, ArrayDeque<Int>())
    return sumRes
}

/**
 * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 * 减法的剪枝比加法剪枝好做一些，
 *
 */
fun backtrackSum(candidates: IntArray, residue: Int, begin: Int, path: Deque<Int>) {
    if (residue == 0) {
        sumRes.add(ArrayList(path))
        return
    }

    val len = candidates.size
    for (i in begin until len) {
        if (residue - candidates[i] < 0) {
            break
        }
        path.addLast(candidates[i])
        backtrackSum(candidates, residue - candidates[i], i, path)
        path.removeLast()
    }
}

/**
 * 还是对回溯的运用不够熟练
 */
//fun backtrackSum(target: Int, list: MutableList<Int>, candidates: IntArray) {
//    if (list.sum() == target) {
//        sumRes.add(list)
//        return
//    }
//
//    //考虑剪枝
//    if (list.sum() > target) {
//        list.removeAt(list.size - 1)
//        return
//    }
//
//    for (candidate in candidates) {
//        list.add(candidate)
//        backtrackSum(target, list, candidates)
//        list.removeAt(list.size - 1)
//    }
//}
