package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-15 16:59
 * @version V1.0
 *

    There is a room with n bulbs, numbered from 0 to n-1, arranged in a row from left to right.
    Initially all the bulbs are turned off.

    Your task is to obtain the configuration represented by target
    where target[i] is '1' if the i-th bulb is turned on and is '0' if it is turned off.

    You have a switch to flip the state of the bulb, a flip operation is defined as follows:

    Choose any bulb (index i) of your current configuration.
    Flip each bulb from index i to n-1.
    When any bulb is flipped it means that if it is 0 it changes to 1 and if it is 1 it changes to 0.

    Return the minimum number of flips required to form target.

     

    Example 1:

    Input: target = "10111"
    Output: 3
    Explanation: Initial configuration "00000".
    flip from the third bulb:  "00000" -> "00111"
    flip from the first bulb:  "00111" -> "11000"
    flip from the second bulb:  "11000" -> "10111"
    We need at least 3 flip operations to form target.
    Example 2:

    Input: target = "101"
    Output: 3
    Explanation: "000" -> "111" -> "100" -> "101".
    Example 3:

    Input: target = "00000"
    Output: 0
    Example 4:

    Input: target = "001011101"
    Output: 5
     

    Constraints:

    1 <= target.length <= 10^5
    target[i] == '0' or target[i] == '1'

 *
 */
fun main() {
    println(minFlips("10111"))
}

/**
 *
 * 智商不够。。。
 *
 * 方法一：模拟
根据翻转操作的定义，选定下标 ii 之后，翻转从下标 ii 到下标 n-1n−1 的每个灯泡，在下标 ii 前面的灯泡则不被翻转。因此，
如果一个灯泡被翻转，则一定是选择了该灯泡的下标或者该灯泡前面的某个下标，然后进行了翻转操作。

初始状态是所有的灯泡是关着的，即状态都是 00。对于下标为 00 的灯泡，如果其在 \textit{target}target 中的状态是 11，则一定有一次对下标为 00 的灯泡的翻转操作。

对于下标为 ii（i>0i>0）的灯泡，如果其在 \textit{target}target 中的状态与前一个灯泡（即下标为 i-1i−1 的灯泡）的状态不同，则一定有一次对下标为 ii 的灯泡的翻转操作。

因此，只需要从前往后遍历 \textit{target}target，对每个下标判断是否进行了翻转操作即可，同时计算最少翻转次数。
 */
fun minFlips(target: String): Int {
    var flips = 0
    var prev = '0'
    val length = target.length
    for (i in 0 until length) {
        val curr = target[i]
        if (curr != prev) {
            flips++
            prev = curr
        }
    }
    return flips
}
