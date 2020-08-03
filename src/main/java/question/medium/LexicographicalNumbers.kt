package question.medium

import java.lang.StringBuilder
import java.util.*
import java.util.ArrayList


/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-03 13:56
 * @version V1.0
 *
    Given an integer n, return 1 - n in lexicographical order.

    For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

    Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.

 *
 */
fun main() {
    lexicalOrder1(34).forEach {
        print("$it, ")
    }
}

fun lexicalOrder(n: Int): List<Int> {
    //生成数组
    val list = mutableListOf<Int>()
    for (i in 1..n) {
        list.add(i)
    }
    //后位补零的形式应该可以解决问题
    list.sortWith(Comparator { o1, o2 ->
        val str1 = o1.toString()
        val str2 = o2.toString()
        val len = Math.max(str1.length, str2.length)
        val sb1 = StringBuilder().append(str1)
        for (i in 0 until len - str1.length) {
            sb1.append("0")
        }
        val sb2 = StringBuilder().append(str2)
        for (i in 0 until len - str2.length) {
            sb2.append("0")
        }

        if (sb1.toString().toInt() >= sb2.toString().toInt()) {
            1
        } else {
            -1
        }
    })
    return list
}

var anslexicalOrder: ArrayList<Int> = ArrayList()
fun lexicalOrder1(n: Int): List<Int> {
    lexicalOrderDfs(n, 0, 0)
    return anslexicalOrder
}

fun lexicalOrderDfs(maxValue: Int, num: Int, start: Int) {
    if (num > maxValue)
        return
    if (num > 0)
        anslexicalOrder.add(num)
    var i = if (start > 0) {
        0
    } else {
        1
    }
    while (i <= 9) {
        lexicalOrderDfs(maxValue, num * 10 + i, start + 1)
        i++
    }

}
