package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-07 17:39
 * @version V1.0
 *
    Write a function to swap a number in place (that is, without temporary vari­ ables).

    Example:

    Input: numbers = [1,2]
    Output: [2,1]
    Note:

    numbers.length == 2
 *
 */
fun main() {
    println(Arrays.toString(swapNumbers(intArrayOf(1, 2))))
}

fun swapNumbers(numbers: IntArray): IntArray {
    numbers[0] = numbers[0].xor(numbers[1])
    numbers[1] = numbers[1].xor(numbers[0])
    numbers[0] = numbers[0].xor(numbers[1])
    return numbers
}
