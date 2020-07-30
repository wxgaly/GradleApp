package question.medium

import java.util.ArrayList


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-30 13:57
 * @version V1.0
 *
    Find all possible combinations of k numbers that add up to a number n,
    given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

    Note:

    All numbers will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:

    Input: k = 3, n = 7
    Output: [[1,2,4]]
    Example 2:

    Input: k = 3, n = 9
    Output: [[1,2,6], [1,3,5], [2,3,4]]

 *
 */
fun main() {

}

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    backtrack(k, n, 1, arrayListOf(), res)
    return res
}

/**
 * 又是回溯法，第一时间想到了，但是这个模板还是没有好好的领会，
 * 还需要再认真的学习一下。
 */
fun backtrack(k: Int, residue: Int, start: Int, path: MutableList<Int>, res: MutableList<MutableList<Int>>) {
    if (residue == 0 && k == 0) {
        res.add(ArrayList(path))
        return
    }
    for (i in start..9) {
        if (residue - i < 0) break
        path.add(i)
        backtrack(k - 1, residue - i, i + 1, path, res)
        path.removeAt(path.size - 1)
    }
}
