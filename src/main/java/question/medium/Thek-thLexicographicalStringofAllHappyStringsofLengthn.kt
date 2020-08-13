package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-13 14:05
 * @version V1.0
 *

    A happy string is a string that:

    consists only of letters of the set ['a', 'b', 'c'].
    s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
    For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

    Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

    Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

     

    Example 1:

    Input: n = 1, k = 3
    Output: "c"
    Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
    Example 2:

    Input: n = 1, k = 4
    Output: ""
    Explanation: There are only 3 happy strings of length 1.
    Example 3:

    Input: n = 3, k = 9
    Output: "cab"
    Explanation: There are 12 different happy string of length 3 ["aba",
    "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
    Example 4:

    Input: n = 2, k = 7
    Output: ""
    Example 5:

    Input: n = 10, k = 100
    Output: "abacbabacb"
     

    Constraints:

    1 <= n <= 10
    1 <= k <= 100


 *
 */
fun main() {
    println(getHappyString(10, 100))
}

val wordRes = arrayListOf<String>()

fun getHappyString(n: Int, k: Int): String {
    val charList = listOf('a', 'b', 'c')
    backtracking(n, StringBuilder(), charList)
    wordRes.forEach {
        print("$it, ")
    }
    println()
    if (k > wordRes.size) {
        return ""
    }
    return wordRes[k - 1]
}

fun backtracking(n: Int, str: StringBuilder, charList: List<Char>) {
    if (str.length == n) {
        wordRes.add(str.toString())
        return
    }

    for (charItem in charList) {
        if (str.isEmpty()) {
            str.append(charItem)
        } else {
            if (str[str.length - 1] == charItem) {
                continue
            }
            str.append(charItem)
        }

        backtracking(n, str, charList)
        str.deleteCharAt(str.length - 1)
    }

}
