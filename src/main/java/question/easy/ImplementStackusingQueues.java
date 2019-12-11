package question.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-12-11 15:10
 * @version V1.0
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 *
 * You must use only standard operations of a queue -- which means only push to back,
 * peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively.
 * You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 *
 *
 */
public class ImplementStackusingQueues {

    public static void main(String[] args) {

    }

    class MyStack {
        private Queue<Integer> q1 = new ArrayDeque<>();
        private Queue<Integer> q2 = new ArrayDeque<>();
        private int top;

        /** Initialize your data structure here. */
        public MyStack() {

        }

        /** Push element x onto stack. */
        public void push(int x) {
            q2.add(x);
            top = x;
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int temp = q1.remove();
            if (!q1.isEmpty()) {
                top = q1.peek();
            }
            return temp;
        }

        /** Get the top element. */
        public int top() {
            return this.top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty();
        }
    }

}
