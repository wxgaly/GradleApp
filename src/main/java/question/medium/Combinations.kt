package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-19 16:33
 * @version V1.0
 *

    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

    Example:

    Input: n = 4, k = 2
    Output:
    [
    [2,4],
    [3,4],
    [2,3],
    [1,2],
    [1,3],
    [1,4],
    ]

 */
fun main() {
    combine(2, 1).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
}


fun combine(n: Int, k: Int): List<List<Int>> {
    val combineRes = arrayListOf<MutableList<Int>>()
    combineBacktrack(1, n, k, arrayListOf(), combineRes)
    return combineRes
}

fun combineBacktrack(index: Int, n: Int, k: Int, list: MutableList<Int>, res: MutableList<MutableList<Int>>) {
    if (list.size == k) {
        res.add(ArrayList(list))
    }

    for (i in index until n + 1) {
        list.add(i)
        combineBacktrack(i + 1, n, k, list, res)
        println("list:$list-------i的值:$i")
        list.removeAt(list.size - 1)
    }
}
