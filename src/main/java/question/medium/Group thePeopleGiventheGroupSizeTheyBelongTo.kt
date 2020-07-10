package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-10 14:13
 * @version V1.0
 *
    There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group.
    Given the array groupSizes of length n telling the group size each person belongs to,
    return the groups there are and the people's IDs each group includes.

    You can return any solution in any order and the same applies for IDs.
    Also, it is guaranteed that there exists at least one solution. 

     

    Example 1:

    Input: groupSizes = [3,3,3,3,3,1,3]
    Output: [[5],[0,1,2],[3,4,6]]
    Explanation:
    Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
    Example 2:

    Input: groupSizes = [2,1,3,3,3,2]
    Output: [[1],[0,5],[2,3,4]]
     

    Constraints:

    groupSizes.length == n
    1 <= n <= 500
    1 <= groupSizes[i] <= n

 *
 */
fun main() {
    groupThePeople(intArrayOf(3, 3, 3, 3, 3, 1, 3)).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
    println()
    groupThePeople(intArrayOf(2, 1, 3, 3, 3, 2)).forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
}

fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
    val groups = HashMap<Int, MutableList<Int>>()
    val len = groupSizes.size
    for (i in 0 until len) {
        val list = groups[groupSizes[i]]
        if (list != null) {
            list.add(i)
        } else {
            groups[groupSizes[i]] = arrayListOf(i)
        }
    }

    val res = mutableListOf<MutableList<Int>>()
    groups.forEach { t, u ->
        val uLen = u.size
        var count = 0
        var index = 0
        while (index < uLen) {
            val resList = mutableListOf<Int>()
            while (count < t) {
                resList.add(u[index])
                index++
                count++
            }
            count = 0
            res.add(resList)
        }
    }

    return res
}
