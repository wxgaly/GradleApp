package question.medium

/**
 * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).

In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal. It is guaranteed that all the elements of the array can be made equal using some operations.

Given an integer n, the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.

 

Example 1:

Input: n = 3
Output: 2
Explanation: arr = [1, 3, 5]
First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].
Example 2:

Input: n = 6
Output: 9
 

Constraints:

1 <= n <= 10^4

 */

fun main() {
    println("dasd")
}

/**
 * f(1) = 0; [1]
 * f(2) = 1; [1, 3]
 * f(3) = 2; [1, 3, 5]
 * f(4) = 2 + 2 = 4; [1, 3, 5, 7]
 * f(5) = 4 + 2 = 6; [1, 3, 5, 7, 9]
 * f(6) = 5 + 3 + 1 = 9; [1, 3, 5, 7, 9, 11]
 * f(7) = 6 + 4 + 2 = 12; [1, 3, 5, 7, 9, 11, 13]
 * f(8) = 7 + 5 + 3 + 1 = 16; [1, 3, 5, 7, 9, 11, 13, 15]
 * f(9) = 8 + 6 + 4 + 2 = 20; [1, 3, 5, 7, 9, 11, 13, 15, 17]
 * f(10) = 9 + 7 + 5 + 3 + 1 = 25; [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
 */
fun minOperations(n: Int): Int = n * n / 4

fun minOperations1(n: Int): Int {
    var ret = 0
    for (i in 0 until n) {
        val x = 2 * i + 1
        if (x > n) {
            ret += x - n
        }
    }
    return ret
}