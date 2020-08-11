package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-11 14:04
 * @version V1.0
 *
    Given two positive integers n and k.

    A factor of an integer n is defined as an integer i where n % i == 0.

    Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.

     

    Example 1:

    Input: n = 12, k = 3
    Output: 3
    Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.
    Example 2:

    Input: n = 7, k = 2
    Output: 7
    Explanation: Factors list is [1, 7], the 2nd factor is 7.
    Example 3:

    Input: n = 4, k = 4
    Output: -1
    Explanation: Factors list is [1, 2, 4], there is only 3 factors. We should return -1.
    Example 4:

    Input: n = 1, k = 1
    Output: 1
    Explanation: Factors list is [1], the 1st factor is 1.
    Example 5:

    Input: n = 1000, k = 3
    Output: 4
    Explanation: Factors list is [1, 2, 4, 5, 8, 10, 20, 25, 40, 50, 100, 125, 200, 250, 500, 1000].
     

    Constraints:

    1 <= k <= n <= 1000

 *
 */
fun main() {
    println(kthFactor(12, 3))
    println(kthFactor(7, 2))
    println(kthFactor(4, 4))
    println(kthFactor(1, 1))
    println(kthFactor(1000, 3))
}

fun kthFactor(n: Int, k: Int): Int {
    val list = arrayListOf<Int>()
    val half = n / 2

    for (i in 1..half) {
        if (n % i == 0) {
            list.add(i)
        }
        if (list.size == k) {
            return i
        }
    }

    //特殊处理自己
    list.add(n)

    //
//    list.forEach {
//        print("$it, ")
//    }
//    println()
    if (k > list.size) {
        return -1
    }
    return list[k - 1]
}

/**
 * 官方题解
 * https://leetcode-cn.com/problems/the-kth-factor-of-n/solution/n-de-di-k-ge-yin-zi-by-leetcode-solution/
 * 如果存在k能够被n整除，那么必然存在n/k <= √n
 * 因为 n = k * n / k > √n * √n = n, 出现了矛盾
 */
fun kthFactor1(n: Int, k: Int): Int {
    var count = 0
    var factor = 1
    while (factor * factor <= n) {
        if (n % factor == 0) {
            ++count
            if (count == k) {
                return factor
            }
        }
        ++factor
    }
    --factor
    if (factor * factor == n) {
        --factor
    }
    while (factor > 0) {
        if (n % factor == 0) {
            ++count
            if (count == k) {
                return n / factor
            }
        }
        --factor
    }
    return -1
}
