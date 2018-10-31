package link;

/**
 * link.OneWayLinkedList
 *
 * @author Created by WXG on 2018/10/31 031 19:25.
 * @version V1.0
 */

public class OneWayLinkedList<T> {

    private Node<T> head;
    private Node<T> last;

    private int size;

    public OneWayLinkedList() {
    }

    public boolean add(T value) {

        Node<T> preNode = this.last;
        Node<T> nextNode = new Node<>(null, null, value);
        this.last = nextNode;

        if (preNode == null) {
            this.head = nextNode;
        } else {
            preNode.nextNode = nextNode;
        }

        ++this.size;

        return true;

    }

    public boolean remove(T value) {
        if (value != null) {

            if (this.head != null && value.equals(this.head.value)) {
                this.head = this.head.nextNode;
                --this.size;
                return true;
            }

            Node<T> temp;
            for (temp = this.head; temp != null; temp = temp.nextNode) {
                Node<T> nextNode = temp.nextNode;

                if (nextNode != null) {
                    if (value.equals(nextNode.value)) {
                        temp.nextNode = nextNode.nextNode;
                        if (temp.nextNode == null) {
                            this.last = temp;
                        }
                        --this.size;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public T getValue(int index) {

        Node<T> temp = this.head;

        for (int i = 0; i < index; i++) {
            temp = temp.nextNode;
        }

        return temp.value;
    }

    /**
     * get size.
     *
     * @return this size of list.
     */
    public int getSize() {
        return size;
    }

    /**
     * get value of head.
     *
     * @return value.
     */
    public T getHead() {
        T value = null;

        if (head != null) {
            value = head.value;
        }

        return value;
    }

    /**
     * get value of last.
     *
     * @return value.
     */
    public T getLast() {
        T value = null;

        if (last != null) {
            value = last.value;
        }

        return value;
    }
}
