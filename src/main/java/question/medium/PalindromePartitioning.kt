package question.medium

import java.util.*
import java.util.ArrayList


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-22 16:05
 * @version V1.0

    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    Example:

    Input: "aab"
    Output:
    [
        ["aa","b"],
        ["a","a","b"]
    ]


 *
 */
fun main() {
    partition("aab").forEach { list ->
        list.forEach {
            print("$it, ")
        }
        println()
    }
}

/**
 * 动态规划还得继续加强，状态转移方程这块没怎么研究，只是看到是子问题的时候能想到是动态规划
 * https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
 */
fun partition(s: String): List<List<String>> {
    val len = s.length
    val res = ArrayList<ArrayList<String>>()
    if (len == 0) {
        return res
    }

    // 预处理
    // 状态：dp[i][j] 表示 s[i][j] 是否是回文
    val dp = Array(len) {
        BooleanArray(len)
    }

    // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
    for (right in 0 until len) {
        // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
        for (left in 0..right) {
            if (s[left] == s[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                dp[left][right] = true
            }
        }
    }

    val stack = ArrayDeque<String>()
    backtrackingPalindrome(s, 0, len, dp, stack, res)
    return res
}

fun backtrackingPalindrome(
        s: String,
        start: Int,
        len: Int,
        dp: Array<BooleanArray>,
        path: Deque<String>,
        res: ArrayList<ArrayList<String>>
) {
    if (start == len) {
        res.add(ArrayList(path))
        return
    }

    for (i in start until len) {
        // 剪枝
        if (!dp[start][i]) {
            continue
        }
        path.addLast(s.substring(start, i + 1))
        backtrackingPalindrome(s, i + 1, len, dp, path, res)
        path.removeLast()
    }
}
