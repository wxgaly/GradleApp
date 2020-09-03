package question.medium

import java.util.ArrayList

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-03 13:43
 * @version V1.0
 *

    Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

    Example 1:
    Input: s1 = "sea", s2 = "eat"
    Output: 231
    Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
    Deleting "t" from "eat" adds 116 to the sum.
    At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
    Example 2:
    Input: s1 = "delete", s2 = "leet"
    Output: 403
    Explanation: Deleting "dee" from "delete" to turn the string into "let",
    adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
    At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
    If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
    Note:

    0 < s1.length, s2.length <= 1000.
    All elements of each string will have an ASCII value in [97, 122].

 *
 */
fun main() {
    println(minimumDeleteSum1("sea", "eat"))
    println(minimumDeleteSum1("delete", "leet"))
}

fun minimumDeleteSum(s1: String, s2: String): Int {
    val list1 = arrayListOf<Char>()
    for (c in s1) {
        list1.add(c)
    }

    val list2 = arrayListOf<Char>()
    for (c in s2) {
        list2.add(c)
    }

    val list3 = ArrayList(list1)
    list1.removeAll(list2)
    list2.removeAll(list3)

    var sum = 0
    for (c in list1) {
        sum += c.toInt()
    }
    for (c in list2) {
        sum += c.toInt()
    }
    return sum
}

fun minimumDeleteSum1(s1: String, s2: String): Int {
    val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }

    for (i in s1.length - 1 downTo 0) {
        dp[i][s2.length] = dp[i + 1][s2.length] + s1.codePointAt(i)
    }
    for (j in s2.length - 1 downTo 0) {
        dp[s1.length][j] = dp[s1.length][j + 1] + s2.codePointAt(j)
    }
    for (i in s1.length - 1 downTo 0) {
        for (j in s2.length - 1 downTo 0) {
            if (s1[i] == s2[j]) {
                dp[i][j] = dp[i + 1][j + 1]
            } else {
                dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i),
                        dp[i][j + 1] + s2.codePointAt(j))
            }
        }
    }
    return dp[0][0]
}
