package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-23 13:49
 * @version V1.0
 *
 *

    In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

    Return the maximum amount of gold you can collect under the conditions:

    Every time you are located in a cell you will collect all the gold in that cell.
    From your position you can walk one step to the left, right, up or down.
    You can't visit the same cell more than once.
    Never visit a cell with 0 gold.
    You can start and stop collecting gold from any position in the grid that has some gold.
     

    Example 1:

    Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
    Output: 24
    Explanation:
    [[0,6,0],
    [5,8,7],
    [0,9,0]]
    Path to get the maximum gold, 9 -> 8 -> 7.
    Example 2:

    Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
    Output: 28
    Explanation:
    [[1,0,7],
    [2,0,6],
    [3,4,5],
    [0,3,0],
    [9,0,20]]
    Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
     

    Constraints:

    1 <= grid.length, grid[i].length <= 15
    0 <= grid[i][j] <= 100
    There are at most 25 cells containing gold.


 *
 */
fun main() {
    println(getMaximumGold(arrayOf(intArrayOf(0, 6, 0), intArrayOf(5, 8, 7), intArrayOf(0, 9, 0))))
}

fun getMaximumGold(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) {
        return 0
    }

    var res = 0
    val col = grid.size
    val row = grid[0].size
    for (i in 0 until col) {
        for (j in 0 until row) {
            res = Math.max(res, goldDfs(grid, i, j))
        }
    }

    return res
}

/**
 * 有思路，还是没写出代码，对回溯法还得好好研究一下，递归写起来还是非常容易的。。。
 */
fun goldDfs(grid: Array<IntArray>, i: Int, j: Int): Int {
    if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0) {
        return 0
    }

    val temp = grid[i][j]
    grid[i][j] = 0

    val up = goldDfs(grid, i, j - 1) //往上找
    val down = goldDfs(grid, i, j + 1) //往下找
    val left = goldDfs(grid, i - 1, j) //往左找
    val right = goldDfs(grid, i + 1, j) //往右找

    val max = Math.max(left, Math.max(right, Math.max(up, down)))
    grid[i][j] = temp
    return grid[i][j] + max
}
