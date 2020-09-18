package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-18 13:58
 * @version V1.0
 *
    Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array
    that is constructed by these N numbers successfully if one of the following is true
    for the ith position (1 <= i <= N) in this array:

    The number at the ith position is divisible by i.
    i is divisible by the number at the ith position.
     

    Now given N, how many beautiful arrangements can you construct?

    Example 1:

    Input: 2
    Output: 2
    Explanation:

    The first beautiful arrangement is [1, 2]:

    Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

    Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

    The second beautiful arrangement is [2, 1]:

    Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

    Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
     

    Note:

    N is a positive integer and will not exceed 15.

 *
 */
fun main() {
    countArrangement(2)
}

var arrangementCount = 0

fun countArrangement(N: Int): Int {
    val visited = BooleanArray(N + 1)
    calculate(N, 1, visited)
    return arrangementCount
}

/**
 * 太菜了，半天没写出全排列
 * https://leetcode-cn.com/problems/beautiful-arrangement/solution/you-mei-de-pai-lie-by-leetcode/
 */
fun calculate(n: Int, pos: Int, visited: BooleanArray) {
    if (pos > n) {
        arrangementCount++
    }
    for (i in 1..n) {
        if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
            visited[i] = true
            calculate(n, pos + 1, visited)
            visited[i] = false
        }
    }
}
