package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-27 14:24
 * @version V1.0
 *
 * How would you design a stack which, in addition to push and pop,
 * has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> return -3.
 * minStack.pop();
 * minStack.top();      --> return 0.
 * minStack.getMin();   --> return -2.
 *
 *
 */
public class MinStackLCCI {

    public static void main(String[] args) {

    }

    class MinStack {

        class Node {
            int val;
            int min;
            Node next;

            public Node(int val, int min) {
                this.val = val;
                this.min = min;
            }

            public Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        private Node head = null;

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if (head == null) head = new Node(x, x);
                /*新加入节点的min字段（最小值）为：自己的值和栈顶的值较小的那个*/
            else if (head != null) {
                int min = Math.min(x, head.min);
                Node node = new Node(x, min, head);
                head = node;
            }
        }

        public void pop() {
            if (head == null) return;
            head = head.next;
        }

        public int top() {
            return head.val;
        }

        public int getMin() {
            return head.min;
        }
    }

}
