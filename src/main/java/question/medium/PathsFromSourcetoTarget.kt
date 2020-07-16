package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-16 14:08
 * @version V1.0
 *
    Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

    The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1. 
    graph[i] is a list of all nodes j for which the edge (i, j) exists.

    Example:
    Input: [[1,2], [3], [3], []]
    Output: [[0,1,3],[0,2,3]]
    Explanation: The graph looks like this:
    0--->1
    |    |
    v    v
    2--->3
    There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
    Note:

    The number of nodes in the graph will be in the range [2, 15].
    You can print different paths in any order, but you should keep the order of nodes inside one path.

 *
 */
fun main() {

}

fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
    return solve(graph, 0)
}

fun solve(graph: Array<IntArray>, node: Int): List<MutableList<Int>> {
    val N = graph.size
    val res = arrayListOf<MutableList<Int>>()

    if (node == N - 1) {
        val path = arrayListOf<Int>()
        path.add(N - 1)
        res.add(path)
        return res
    }

    for (nei in graph[node]) {
        for (path in solve(graph, nei)) {
            path.add(0, node)
            res.add(path)
        }
    }

    return res
}
