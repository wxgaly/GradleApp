package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-06 14:32
 * @version V1.0
 *

    Given two strings: s1 and s2 with the same size,
    check if some permutation of string s1 can break some permutation of string s2 or vice-versa (in other words s2 can break s1).

    A string x can break string y (both of size n) if x[i] >= y[i] (in alphabetical order) for all i between 0 and n-1.

     

    Example 1:

    Input: s1 = "abc", s2 = "xya"
    Output: true
    Explanation: "ayx" is a permutation of s2="xya" which can break to string "abc" which is a permutation of s1="abc".
    Example 2:

    Input: s1 = "abe", s2 = "acd"
    Output: false
    Explanation: All permutations for s1="abe" are: "abe", "aeb", "bae", "bea", "eab" and "eba"
    and all permutation for s2="acd" are: "acd", "adc", "cad", "cda", "dac" and "dca". However,
    there is not any permutation from s1 which can break some permutation from s2 and vice-versa.
    Example 3:

    Input: s1 = "leetcodee", s2 = "interview"
    Output: true
     

    Constraints:

    s1.length == n
    s2.length == n
    1 <= n <= 10^5
    All strings consist of lowercase English letters.

 *
 */
fun main() {
    println(checkIfCanBreak("abc", "xya"))
    println(checkIfCanBreak("abe", "acd"))
    println(checkIfCanBreak("leetcodee", "interview"))
}

fun checkIfCanBreak(s1: String, s2: String): Boolean {

    var res = false
    val chars1 = s1.toCharArray()
    Arrays.sort(chars1)

    val chars2 = s2.toCharArray()
    Arrays.sort(chars2)

    val len = chars1.size
    res = true
    for (index in 0 until len) {
        if (chars1[index] < chars2[index]) {
            res = false
            break
        }
    }

    if (!res) {
        res = true
        for (index in 0 until len) {
            if (chars1[index] > chars2[index]) {
                res = false
                break
            }
        }
    }

    return res
}

fun checkIfCanBreak1(s1: String, s2: String): Boolean {

    val chars1 = s1.toCharArray()
    Arrays.sort(chars1)

    val chars2 = s2.toCharArray()
    Arrays.sort(chars2)

    val len = chars1.size
    var big1 = true
    var big2 = true
    for (i in 0 until len) {
        if (big1 && chars1[i] < chars2[i]) big1 = false
        if (big2 && chars1[i] > chars2[i]) big2 = false
        if (!big1 && !big2) return false
    }

    return true
}
