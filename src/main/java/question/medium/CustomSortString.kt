package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-18 13:55
 * @version V1.0
 *
 *
 *

    S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

    S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted.
    More specifically, if x occurs before y in S, then x should occur before y in the returned string.

    Return any permutation of T (as a string) that satisfies this property.

    Example :
    Input:
    S = "cba"
    T = "abcd"
    Output: "cbad"
    Explanation:
    "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
    Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
     

    Note:

    S has length at most 26, and no character is repeated in S.
    T has length at most 200.
    S and T consist of lowercase letters only.

 *
 */
fun main() {
    val S = "cba"
    customSortString(S, S)
}

fun customSortString(S: String, T: String): String {
    val map = HashMap<Char, Int>()
    var index = 0
    S.toCharArray().forEach {
        map.putIfAbsent(it, index++)
    }
    map.forEach { t, u ->
        println("$t, $u")
    }
    val array = T.toCharArray().map { it.toChar() }
    Collections.sort(array) { c1, c2 ->
        if (map[c1]!! > map[c2]!!) {
            1
        } else {
            0
        }
    }
    return S
}

/**
 * 官方题解
 * https://leetcode-cn.com/problems/custom-sort-string/solution/zi-ding-yi-zi-fu-chuan-pai-xu-by-leetcode/
 */
fun customSortString1(S: String, T: String): String {
    val count = IntArray(26)
    for (c in T.toCharArray())
        count[c - 'a']++

    val ans = StringBuilder()

    for (c in S.toCharArray()) {
        for (i in 0 until count[c - 'a'])
            ans.append(c)
        count[c - 'a'] = 0
    }

    var c = 'a'
    while (c <= 'z') {
        for (i in 0 until count[c - 'a'])
            ans.append(c)
        ++c
    }

    return ans.toString()
}
