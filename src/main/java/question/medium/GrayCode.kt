package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-20 13:50
 * @version V1.0
 *

    The gray code is a binary numeral system where two successive values differ in only one bit.

    Given a non-negative integer n representing the total number of bits in the code,
    print the sequence of gray code. A gray code sequence must begin with 0.

    Example 1:

    Input: 2
    Output: [0,1,3,2]
    Explanation:
    00 - 0
    01 - 1
    11 - 3
    10 - 2

    For a given n, a gray code sequence may not be uniquely defined.
    For example, [0,2,3,1] is also a valid gray code sequence.

    00 - 0
    10 - 2
    11 - 3
    01 - 1
    Example 2:

    Input: 0
    Output: [0]
    Explanation: We define the gray code sequence to begin with 0.
                 A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
                 Therefore, for n = 0 the gray code sequence is [0].


 *
 */
fun main() {
    grayCode1(3).forEach {
        print("$it, ")
    }
}

/**
 * 题意没有理解正确
 */
fun grayCode(n: Int): List<Int> {
    return if (n == 0) {
        listOf(0)
    } else {
        val list = arrayListOf<Int>()
        for (i in 0 until Math.pow(2.toDouble(), n.toDouble()).toInt()) {
            list.add(i)
        }
        list
    }
}

/**
 * https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
 */
fun grayCode1(n: Int): List<Int> {
    val list = arrayListOf(0)
    var head = 1
    for (i in 0 until n) {
        for (j in list.size - 1 downTo 0) {
            list.add(head + list[j])
        }
        head = head.shl(1)
    }
    return list
}
