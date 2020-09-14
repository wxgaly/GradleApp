package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-14 14:58
 * @version V1.0
 *

    A sequence of numbers is called arithmetic if it consists of at least three elements
    and if the difference between any two consecutive elements is the same.

    For example, these are arithmetic sequences:

    1, 3, 5, 7, 9
    7, 7, 7, 7
    3, -1, -5, -9
    The following sequence is not arithmetic.

    1, 1, 2, 5, 7
     
    A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

    A slice (P, Q) of the array A is called arithmetic if the sequence:
    A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

    The function should return the number of arithmetic slices in the array A.

     
    Example:

    A = [1, 2, 3, 4]

    return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.


 *
 */
fun main() {
    println(f(4))
    println(f(5))
    println(f(6))
}

fun numberOfArithmeticSlices(A: IntArray): Int {
    val len = A.size
    if (len < 3) {
        return 0
    }

    return f(len)
}

//递归求值
fun f(n: Int): Int {
    return if (n == 3) {
        1
    } else {
        f(n - 1) + n - 2
    }
}

fun numberOfArithmeticSlices1(A: IntArray): Int {
    var dp = 0
    var sum = 0
    val size = A.size
    for (i in 2 until size) {
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            dp += 1
            sum += dp
        } else {
            dp = 0
        }
    }
    return sum
}
