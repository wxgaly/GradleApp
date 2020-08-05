package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-08-05 14:10
 * @version V1.0
 *

    Given an Iterator class interface with methods: next() and hasNext(),
    design and implement a PeekingIterator that support the peek() operation
    -- it essentially peek() at the element that will be returned by the next call to next().

    Example:

    Assume that the iterator is initialized to the beginning of the list: [1,2,3].

    Call next() gets you 1, the first element in the list.
    Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
    You call next() the final time and it returns 3, the last element.
    Calling hasNext() after that should return false.

 *
 */
class PeekingIterator(var iterator: Iterator<Int>) : Iterator<Int> {

    var peekValue: Int? = null

    fun peek(): Int {
        if (peekValue == null && iterator.hasNext()) {
            peekValue = iterator.next()
        }
        return peekValue!!
    }

    override fun next(): Int {
        val temp = peek()
        if (iterator.hasNext()) {
            peekValue = iterator.next()
        } else {
            peekValue = null
        }
        return temp
    }

    override fun hasNext(): Boolean = peekValue != null || iterator.hasNext()
}

fun main() {
    val arr = arrayOf(1, 2, 3)
    val peekingIterator = PeekingIterator(arr.iterator())
    val param_1 = peekingIterator.next()
    println(param_1)
    val param_2 = peekingIterator.peek()
    println(param_2)
    val param_3 = peekingIterator.hasNext()
    println(param_3)
}
