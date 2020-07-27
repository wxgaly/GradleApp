package question.medium

/**
 *  question.medium.
 *
 * @author Created by WXG on 2020-07-27 14:04
 * @version V1.0
 *
    Design a stack which supports the following operations.

    Implement the CustomStack class:

    CustomStack(int maxSize) Initializes the object with maxSize
    which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
    void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
    int pop() Pops and returns the top of stack or -1 if the stack is empty.
    void inc(int k, int val) Increments the bottom k elements of the stack by val.
    If there are less than k elements in the stack, just increment all the elements in the stack.
     

    Example 1:

    Input
    ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
    [[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
    Output
    [null,null,null,2,null,null,null,null,null,103,202,201,-1]
    Explanation
    CustomStack customStack = new CustomStack(3); // Stack is Empty []
    customStack.push(1);                          // stack becomes [1]
    customStack.push(2);                          // stack becomes [1, 2]
    customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
    customStack.push(2);                          // stack becomes [1, 2]
    customStack.push(3);                          // stack becomes [1, 2, 3]
    customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
    customStack.increment(5, 100);                // stack becomes [101, 102, 103]
    customStack.increment(2, 100);                // stack becomes [201, 202, 103]
    customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
    customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
    customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
    customStack.pop();                            // return -1 --> Stack is empty return -1.
     

    Constraints:

    1 <= maxSize <= 1000
    1 <= x <= 1000
    1 <= k <= 1000
    0 <= val <= 100
    At most 1000 calls will be made to each method of increment, push and pop each separately.

 *
 */
fun main() {
    var customStack = CustomStack(3)
    customStack.push(1)                         // stack becomes [1]
    customStack.push(2)                          // stack becomes [1, 2]
    println(customStack.pop1())                          // return 2 --> Return top of the stack 2, stack becomes [1]
    customStack.push(2);                          // stack becomes [1, 2]
    customStack.push(3);                          // stack becomes [1, 2, 3]
    customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
    customStack.increment1(5, 100);                // stack becomes [101, 102, 103]
    customStack.increment1(2, 100);                // stack becomes [201, 202, 103]
    println(customStack.pop1())                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
    println(customStack.pop1())                            // return 202 --> Return top of the stack 102, stack becomes [201]
    println(customStack.pop1())                         // return 201 --> Return top of the stack 101, stack becomes []
    println(customStack.pop1())
    println()

    customStack = CustomStack(3)
    customStack.push(1)                         // stack becomes [1]
    customStack.push(2)                          // stack becomes [1, 2]
    println(customStack.pop())                          // return 2 --> Return top of the stack 2, stack becomes [1]
    customStack.push(2);                          // stack becomes [1, 2]
    customStack.push(3);                          // stack becomes [1, 2, 3]
    customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
    customStack.increment(5, 100);                // stack becomes [101, 102, 103]
    customStack.increment(2, 100);                // stack becomes [201, 202, 103]
    println(customStack.pop())                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
    println(customStack.pop())                            // return 202 --> Return top of the stack 102, stack becomes [201]
    println(customStack.pop())                         // return 201 --> Return top of the stack 101, stack becomes []
    println(customStack.pop())

}

class CustomStack(maxSize: Int) {

    private val arrForStack = IntArray(maxSize)
    private val add = IntArray(maxSize)
    private var index = 0

    fun push(x: Int) {
        if (index < arrForStack.size) {
            arrForStack[index] = x
            index++
        }
    }

    fun pop(): Int {
        return if (index <= 0) {
            -1
        } else {
            index--
            return arrForStack[index]
        }
    }

    fun increment(k: Int, `val`: Int) {
        if (k >= 0) {
            var len = k
            if (len >= arrForStack.size) {
                len = arrForStack.size
            }

            for (i in 0 until len) {
                arrForStack[i] += `val`
            }
        }
    }

    fun pop1(): Int {
        return if (index <= 0) {
            -1
        } else {
            index--
            val res = arrForStack[index] + add[index]
            if (index != 0) {
                add[index - 1] += add[index]
            }
            add[index] = 0
            return res
        }
    }

    /**
     * 优化方法
     * 增加一个add数组，记录每次的增量
     */
    fun increment1(k: Int, `val`: Int) {
        val len = Math.min(k, index)
        if (len == 0) {
            return
        }
        add[len - 1] += `val`
    }

}
