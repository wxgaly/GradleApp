package question.medium


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-10 16:41
 * @version V1.0
 *

    Given an integer n, return a list of all simplified fractions between 0 and 1 (exclusive) such that
    the denominator is less-than-or-equal-to n. The fractions can be in any order.

     
    Example 1:

        Input: n = 2
        Output: ["1/2"]
        Explanation: "1/2" is the only unique fraction with a denominator less-than-or-equal-to 2.

    Example 2:

        Input: n = 3
        Output: ["1/2","1/3","2/3"]

    Example 3:

        Input: n = 4
        Output: ["1/2","1/3","1/4","2/3","3/4"]
        Explanation: "2/4" is not a simplified fraction because it can be simplified to "1/2".

    Example 4:

        Input: n = 1
        Output: []
     

    Constraints:

        1 <= n <= 100

 *
 */
fun main() {
    simplifiedFractions(6).forEach {
        print("$it, ")
    }
}

fun simplifiedFractions(n: Int): List<String> {
    if (n < 2) {
        return emptyList()
    }

    val list = arrayListOf<String>()

    for (i in 1 until n) {
        for (j in i + 1..n) {
            if (gcd(i, j) == 1) {
                list.add("$i/$j")
            }
        }
    }
    return list
}

/**
 * 求最大公约数
 */
fun gcd(x: Int, y: Int): Int {
    if (y == 0) return x
    return gcd(y, x % y)
}

/**
 * 判断是否存在公约数
 */
fun hasCommonDivisor(a: Int, b: Int): Boolean {
    for (i in 2..a) {
        if (a % i == 0 && b % i == 0) {
            return false
        }
    }
    return true
}
