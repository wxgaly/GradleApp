package question.medium

import java.util.*

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-09-09 13:48
 * @version V1.0
 *

    Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.

    Return the minimum size of the set so that at least half of the integers of the array are removed.

     

    Example 1:

    Input: arr = [3,3,3,3,5,5,5,2,2,7]
    Output: 2
    Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
    Possible sets of size 2 are {3,5},{3,2},{5,2}.
    Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
    Example 2:

    Input: arr = [7,7,7,7,7,7]
    Output: 1
    Explanation: The only possible set you can choose is {7}. This will make the new array empty.
    Example 3:

    Input: arr = [1,9]
    Output: 1
    Example 4:

    Input: arr = [1000,1000,3,7]
    Output: 1
    Example 5:

    Input: arr = [1,2,3,4,5,6,7,8,9,10]
    Output: 5
     

    Constraints:

    1 <= arr.length <= 10^5
    arr.length is even.
    1 <= arr[i] <= 10^5


 *
 */
fun main() {
//    println(minSetSize(intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)))
//    println(minSetSize(intArrayOf(7, 7, 7, 7, 7, 7)))
//    println(minSetSize(intArrayOf(1, 9)))
//    println(minSetSize(intArrayOf(1000, 1000, 3, 7)))
//    println(minSetSize(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println(minSetSize(intArrayOf(72, 18, 36, 6, 12, 97, 41, 82, 44, 75, 82, 42, 75, 48, 63, 9, 61, 50, 11, 91, 24, 26, 3, 65, 31, 67, 15, 76, 54, 59, 4, 27, 33, 26, 17, 60, 100, 19, 90, 6, 80, 82, 48, 70, 85, 99, 69, 2, 78, 94, 15, 29, 75, 17, 9, 79, 99, 88, 26, 73, 88, 100, 9, 95, 2, 56, 63, 31, 25, 40, 8, 100, 56, 44, 36, 42, 21, 96, 63, 38, 96, 78, 60, 22, 21, 81)))
}

fun minSetSize(arr: IntArray): Int {
    val size = arr.size
    return if (size <= 2) {
        1
    } else {
        val hashMap = hashMapOf<Int, Int>()
        for (i in arr) {
            val value = hashMap.getOrDefault(i, 0)
            hashMap[i] = value + 1
        }

        var count = 0
        val list = hashMap.toList()
        Collections.sort(list) { o1, o2 ->
            when {
                o1.second > o2.second -> -1
                o1.second < o2.second -> 1
                else -> 0
            }
        }

        val half = size / 2
        var total = 0
        for (pair in list) {
            count += pair.second
            total++
            if (count >= half) {
                break
            }
        }

        total
    }
}
