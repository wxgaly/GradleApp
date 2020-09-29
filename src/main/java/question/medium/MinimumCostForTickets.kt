package question.medium

/**
 *  question.medium.MinimumCostForTickets
 *
 * @author Created by WXG on 2020/9/29 16:09.
 * @version V1.0
 */
fun main() {
    val minimumCostForTickets = MinimumCostForTickets()
    println(minimumCostForTickets.mincostTickets(intArrayOf(1, 4, 6, 7, 8, 20), intArrayOf(2, 7, 15)))
    println(minimumCostForTickets.mincostTickets(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31), intArrayOf(2, 7, 15)))
}

/**
 * 动态规划，，，
 * 得好好搞一下了，
 */
class MinimumCostForTickets {
    private lateinit var days: IntArray
    private lateinit var costs: IntArray
    private lateinit var memo: Array<Int?>
    private var durations = intArrayOf(1, 7, 30)

    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        this.days = days
        this.costs = costs
        memo = arrayOfNulls(days.size)
        return dp(0)
    }

    private fun dp(i: Int): Int {
        if (i >= days.size) {
            return 0
        }
        if (memo[i] != null) {
            return memo[i]!!
        }
        memo[i] = Int.MAX_VALUE
        var j = i
        for (k in 0..2) {
            while (j < days.size && days[j] < days[i] + durations[k]) {
                j++
            }
            memo[i] = Math.min(memo[i]!!, dp(j) + costs[k])
        }
        return memo[i]!!
    }
}


