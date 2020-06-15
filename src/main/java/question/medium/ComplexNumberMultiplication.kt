package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-06-15 13:45
 * @version V1.0
 *
 *
 * Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100].
And the output should be also in this form.

 *
 */
fun main() {
    println(complexNumberMultiply("1+-1i", "0+0i"))
}

fun complexNumberMultiply(a: String, b: String): String {
    val c1 = resolveComplex(a)
    val c2 = resolveComplex(b)
    val result = (c1.first * c2.first + c1.second * c2.second * -1).toString() + "+" + ((c1.first * c2.second + c1.second * c2.first).toString() + "i")
    return result
}

fun resolveComplex(num: String): Pair<Int, Int> {
    val split = num.split("+")
    val a = split[0].toInt()
    val b = split[1].substring(0, split[1].indexOf("i")).toInt()
    return Pair(a, b)
}

fun complexNumberMultiply1(a: String, b: String): String {
    val x = a.split("\\+|i")
    val y = b.split("\\+|i")
    val a_real = Integer.parseInt(x[0])
    val a_img = Integer.parseInt(x[1])
    val b_real = Integer.parseInt(y[0])
    val b_img = Integer.parseInt(y[1])
    return (a_real * b_real - a_img * b_img).toString() + "+" + (a_real * b_img + a_img * b_real).toString() + "i"
}


