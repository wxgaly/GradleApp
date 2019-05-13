package question.medium;


import java.util.Stack;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-13 13:44.
 * @version V1.0
 * <p>
 * Given two sequences pushed and popped with distinct values,
 * return true if and only if this could have been the result of
 * a sequence of push and pop operations on an initially empty stack.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * Example 2:
 * <p>
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed is a permutation of popped.
 * pushed and popped have distinct values.
 */
public class ValidateStackSequences {

    public static void main(String[] args) {

        int[] pushed = new int[]{
                1, 2, 3, 4, 5
        };

        int[] popped = new int[]{
                4, 5, 3, 2, 1
        };

        popped = new int[]{
                4, 3, 5, 1, 2
        };

        pushed = new int[]{
                1, 0
        };

        popped = new int[]{
                1, 0
        };

        System.out.println(validateStackSequences(pushed, popped));

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }

        int length = popped.length;
        if (pushed.length == 0 && length == 0) {
            return true;
        } else if (pushed.length == 0) {
            return false;
        } else if (length == 0) {
            return false;
        } else {

            if (pushed.length != length) {
                return false;
            }

            Stack<Integer> tempStack = new Stack<>();
            int temp = 0;

            for (int i = 0; i < length; i++) {
                tempStack.push(pushed[i]);

                if (tempStack.peek() == popped[temp]) {
                    tempStack.pop();
                    temp++;
                    while (temp < length) {
                        if (!tempStack.isEmpty()) {
                            if (tempStack.peek() == popped[temp]) {
                                tempStack.pop();
                                temp++;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }


            return tempStack.isEmpty();
        }
    }

    // 剑指offer解答
    public static boolean IsPopOrder(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length == 0
                || popped.length == 0)
            return false;
        int index = 0; //作为弹出序列的一个索引
        Stack<Integer> stack = new Stack<>();
        for (int value : pushed) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {// 当栈不为空且栈顶元
                //素等于弹出序列元素时候，就弹出一个，同时让弹出序列后移一个
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();//如果最后，栈不为空，相当于没有按照给定的弹出popA弹出完毕，
        //就说明不能按照popA，返回false
    }


}
