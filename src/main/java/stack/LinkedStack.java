package stack;

import link.OneWayLinkedList;

/**
 * stack.LinkedStack
 *
 * @author Created by WXG on 2018/11/1 001 11:56.
 * @version V1.0
 */

public class LinkedStack<T> {

    private int head = 0;
    private OneWayLinkedList<T> linkedList;
    private int size = 0;

    public LinkedStack() {
        this(10);
        linkedList = new OneWayLinkedList<>();
    }

    public LinkedStack(int size) {
        this.size = size;
    }

    public boolean push(T value) {

        //栈满
        if (head == size) {
            return false;
        }

        linkedList.add(value);
        head++;

        return true;
    }

    public T pop() {

        T value = null;

        if (head >= 0) {

            if (head != 0) {
                head--;
            }

            value = linkedList.getValue(head);
            linkedList.remove(value);
        }

        return value;
    }

    public T getValue(int index) {
        T value = null;

        if (index < size) {
            value = linkedList.getValue(index);
        }

        return value;
    }

    public boolean isEmpty() {
        return this.head == 0;
    }

    public int getSize() {
        return this.head;
    }

}
