package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-09 16:15
 * @version V1.0
 *
    In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there.
    We are allowed to increase the height of any number of buildings,
    by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well. 

    At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left,
    and right, must be the same as the skyline of the original grid.
    A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance.
    See the following example.

    What is the maximum total sum that the height of the buildings can be increased?

    Example:
    Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
    Output: 35
    Explanation:
    The grid is:
    [ [3, 0, 8, 4],
    [2, 4, 5, 7],
    [9, 2, 6, 3],
    [0, 3, 1, 0] ]

    The skyline viewed from top or bottom is: [9, 4, 8, 7]
    The skyline viewed from left or right is: [8, 7, 9, 3]

    The grid after increasing the height of buildings without affecting skylines is:

    gridNew = [ [8, 4, 8, 7],
    [7, 4, 7, 7],
    [9, 4, 8, 7],
    [3, 3, 3, 3] ]

    Notes:

    1 < grid.length = grid[0].length <= 50.
    All heights grid[i][j] are in the range [0, 100].
    All buildings in grid[i][j] occupy the entire grid cell: that is, they are a 1 x 1 x grid[i][j] rectangular prism

 *
 */
fun main() {
    println(maxIncreaseKeepingSkyline(arrayOf(intArrayOf(3, 0, 8, 4), intArrayOf(2, 4, 5, 7), intArrayOf(9, 2, 6, 3), intArrayOf(0, 3, 1, 0))))
}

fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {

    val row = grid.size
    val col = grid[0].size

    val l_r = IntArray(row)
    val t_b = IntArray(col)

    // 先求从上到下的
    for (i in 0 until col) {
        var max = grid[0][i]
        for (j in 1 until row) {
            if (grid[j][i] > max) {
                max = grid[j][i]
            }
        }
        t_b[i] = max
    }

    // 再求从左到右的
    for (i in 0 until row) {
        var max = grid[i][0]
        for (j in 1 until col) {
            if (grid[i][j] > max) {
                max = grid[i][j]
            }
        }
        l_r[i] = max
    }

    println(Arrays.toString(l_r))
    println(Arrays.toString(t_b))

    var sum = 0
    for (i in 0 until row) {
        for (j in 0 until col) {
            val min = Math.min(l_r[i], t_b[j])
            if (min > grid[i][j]) {
                sum += min - grid[i][j]
            }
        }
    }

    return sum

}

fun maxIncreaseKeepingSkyline1(grid: Array<IntArray>): Int {
    val N = grid.size
    val rowMaxes = IntArray(N)
    val colMaxes = IntArray(N)

    for (r in 0 until N) {
        for (c in 0 until N) {
            rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c])
            colMaxes[c] = Math.max(colMaxes[c], grid[r][c])
        }
    }

    var ans = 0
    for (r in 0 until N) {
        for (c in 0 until N) {
            ans += Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c]
        }
    }

    return ans
}

