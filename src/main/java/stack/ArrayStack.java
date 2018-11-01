package stack;

/**
 * stack.ArrayStack
 *
 * @author Created by WXG on 2018/11/1 001 10:04.
 * @version V1.0
 */

public class ArrayStack<T> {

    private int head = 0;
    private Object[] array;
    private int size;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int size) {
        this.size = size;
        array = new Object[this.size];
    }

    public boolean push(T value) {

        //栈满
        if (head == size) {
            return false;
        }

        array[head++] = value;

        return true;
    }

    public T pop() {

        T value = null;

        if (head >= 0) {

            if (head != 0) {
                head--;
            }

            value = (T) array[head];
            array[head] = null;
        }

        return value;
    }

    public T getValue(int index) {
        T value = null;

        if (index < size) {
            value = (T) array[index];
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
