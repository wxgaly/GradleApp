package question.medium

import java.util.*
import java.util.LinkedList


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-07 14:41
 * @version V1.0
 *

    Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
    where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h.
    Write an algorithm to reconstruct the queue.

    Note:
    The number of people is less than 1,100.

     
    Example

    Input:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    Output:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]


 *
 */
fun main() {
    reconstructQueue(arrayOf(intArrayOf(7, 0), intArrayOf(4, 4), intArrayOf(7, 1), intArrayOf(5, 0), intArrayOf(6, 1), intArrayOf(5, 2)))
            .forEach {
                println(Arrays.toString(it))
            }
}

/**
 * 还是题解牛皮
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode/
 */
fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    Arrays.sort(people) { o1, o2 ->
        if (o1[0] == o2[0]) {
            o1[1] - o2[1]
        } else {
            o2[0] - o1[0]
        }
    }
    val output = LinkedList<IntArray>()
    for (p in people) {
        output.add(p[1], p)
    }
    val n = people.size
    return output.toArray(Array(n) {
        IntArray(2)
    })
}
