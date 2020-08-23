package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-23 14:29
 * @version V1.0
 *
 *

    You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q
    where its concatenation is equal to s and the number of distinct letters in p and q are the same.

    Return the number of good splits you can make in s.

     

    Example 1:

    Input: s = "aacaba"
    Output: 2
    Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
    ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
    ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
    ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
    ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
    ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
    Example 2:

    Input: s = "abcd"
    Output: 1
    Explanation: Split the string as follows ("ab", "cd").
    Example 3:

    Input: s = "aaaaa"
    Output: 4
    Explanation: All possible splits are good.
    Example 4:

    Input: s = "acbadbaada"
    Output: 2
     

    Constraints:

    s contains only lowercase English letters.
    1 <= s.length <= 10^5

 *
 */
fun main() {
    println(numSplits1("aacaba"))
    println(numSplits1("abcd"))
    println(numSplits1("aaaaa"))
    println(numSplits1("acbadbaada"))
}

/**
 * 超出了时间限制，因为重复计算了多次字母数量
 */
fun numSplits(s: String): Int {
    val len = s.length
    var count = 0
    for (i in 1 until len) {
        val s1 = s.substring(0, i)
        val s2 = s.substring(i, len)
        if (letterCount(s1) == letterCount(s2)) {
            println("$s1 , $s2")
            count++
        }
    }
    return count
}

/**
 * 并没有使用官方的动态规划，而是选择这种相对简单一些的做法
 * https://leetcode-cn.com/problems/number-of-good-ways-to-split-a-string/solution/number-of-good-ways-by-ikaruga/
 */
fun letterCount(s: String): Int {
    val set = HashSet<Char>(s.length)
    for (c in s) {
        set.add(c)
    }
    return set.size
}

fun numSplits1(s: String): Int {
    var count = 0

    val l_dic = IntArray(26)
    val r_dic = IntArray(26)
    var left = 0
    var right = 0

    for (c in s) {
        val x = c - 'a'
        if (r_dic[x] == 0) {
            right++
        }
        r_dic[x]++
    }

    val len = s.length
    for (i in 0 until len - 1) {
        val c = s[i] - 'a'
        if (l_dic[c] == 0) {
            left++
        }
        l_dic[c]++
        r_dic[c]--
        if (r_dic[c] == 0) {
            right--
        }
        if (left == right) {
            count++
        }
    }

    return count
}
