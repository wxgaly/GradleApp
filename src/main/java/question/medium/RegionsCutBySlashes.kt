package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-01 14:05
 * @version V1.0
 *

    In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \,
    or blank space.  These characters divide the square into contiguous regions.

    (Note that backslash characters are escaped, so a \ is represented as "\\".)

    Return the number of regions.

     

    Example 1:

    Input:
    [
      " /",
      "/ "
    ]
    Output: 2
    Explanation: The 2x2 grid is as follows:

    Example 2:

    Input:
    [
      " /",
      "  "
    ]
    Output: 1
    Explanation: The 2x2 grid is as follows:

    Example 3:

    Input:
    [
      "\\/",
      "/\\"
    ]
    Output: 4
    Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
    The 2x2 grid is as follows:

    Example 4:

    Input:
    [
      "/\\",
      "\\/"
    ]
    Output: 5
    Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
    The 2x2 grid is as follows:

    Example 5:

    Input:
    [
      "//",
      "/ "
    ]
    Output: 3
    Explanation: The 2x2 grid is as follows:

     

    Note:

    1 <= grid.length == grid[0].length <= 30
    grid[i][j] is either '/', '\', or ' '.


 *
 */
fun main() {
    println(regionsBySlashes(arrayOf(" /", "/ ")))
}


fun regionsBySlashes(grid: Array<String>): Int {
    val N = grid.size
    val dsu = DSU(4 * N * N)
    for (r in 0 until N)
        for (c in 0 until N) {
            val root = 4 * (r * N + c)
            val `val` = grid[r][c]
            if (`val` != '\\') {
                dsu.union(root + 0, root + 1)
                dsu.union(root + 2, root + 3)
            }
            if (`val` != '/') {
                dsu.union(root + 0, root + 2)
                dsu.union(root + 1, root + 3)
            }

            // north south
            if (r + 1 < N)
                dsu.union(root + 3, root + 4 * N + 0)
            if (r - 1 >= 0)
                dsu.union(root + 0, root - 4 * N + 3)
            // east west
            if (c + 1 < N)
                dsu.union(root + 2, root + 4 + 1)
            if (c - 1 >= 0)
                dsu.union(root + 1, root - 4 + 2)
        }

    var ans = 0
    for (x in 0 until 4 * N * N) {
        if (dsu.find(x) == x)
            ans++
    }

    return ans
}

class DSU(N: Int) {
    var parent: IntArray = IntArray(N)

    init {
        for (i in 0 until N)
            parent[i] = i
    }

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        parent[find(x)] = find(y)
    }
}
