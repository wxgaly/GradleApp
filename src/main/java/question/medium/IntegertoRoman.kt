package question.medium

import java.lang.StringBuilder

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-01 13:52
 * @version V1.0
 *

    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
    which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
    Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

    Example 1:

    Input: 3
    Output: "III"
    Example 2:

    Input: 4
    Output: "IV"
    Example 3:

    Input: 9
    Output: "IX"
    Example 4:

    Input: 58
    Output: "LVIII"
    Explanation: L = 50, V = 5, III = 3.
    Example 5:

    Input: 1994
    Output: "MCMXCIV"
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

 *
 */
fun main() {
    println(intToRoman(58))
}

fun intToRoman(num: Int): String {
    val map = mapOf(
            Pair(1, "I"),
            Pair(4, "IV"),
            Pair(5, "V"),
            Pair(9, "IX"),
            Pair(10, "X"),
            Pair(40, "XL"),
            Pair(50, "L"),
            Pair(90, "XC"),
            Pair(100, "C"),
            Pair(400, "CD"),
            Pair(500, "D"),
            Pair(900, "CM"),
            Pair(1000, "M")
    )

    //分解为减法会简单多了，没有太多判断
    val stringBuilder = StringBuilder()
    val len = num.toString().length
    var divNum = Math.pow(10.toDouble(), len.toDouble() - 1).toInt()
    var calNum = num
    while (calNum / divNum != 0) {
        if (divNum == 1) {
            when (calNum) {
                in 2..3 -> {
                    while (calNum > 0) {
                        stringBuilder.append(map[divNum])
                        calNum--
                    }
                }
                in 6..8 -> {
                    stringBuilder.append(map[5])
                    calNum -= 5
                    while (calNum > 0) {
                        stringBuilder.append(map[divNum])
                        calNum--
                    }
                }
                else -> {
                    stringBuilder.append(map[calNum])
                }
            }
            calNum = 0
        } else {
            var temp = calNum / divNum * divNum
            stringBuilder.append(map[divNum])
            calNum %= divNum
            divNum /= 10
        }
    }

    return stringBuilder.toString()
}

val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
val symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

/**
 * 分解计算
 */
fun intToRoman1(num: Int): String {
    val stringBuilder = StringBuilder()
    val len = values.size
    var i = 0
    var temp = num
    while (i < len && temp >= 0) {
        while (values[i] <= temp) {
            temp -= values[i]
            stringBuilder.append(symbols[i])
        }
        i++
    }

    return stringBuilder.toString()
}

/**
 * 硬编码
 */
fun intToRoman2(num: Int): String {
    val thousands = arrayOf("", "M", "MM", "MMM")
    val hundreds = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val tens = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val ones = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")

    return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10]
}

