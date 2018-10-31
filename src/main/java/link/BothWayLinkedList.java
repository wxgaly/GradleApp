package link;

/**
 * link.BothWayLinkedList
 *
 * @author Created by WXG on 2018/10/31 031 17:19.
 * @version V1.0
 */

public class BothWayLinkedList<T> {

    private Node<T> head;
    private Node<T> last;

    private int size;

    public BothWayLinkedList() {
    }

    /**
     * add node.
     *
     * @param value something.
     * @return true or false.
     */
    public boolean add(T value) {

        Node<T> preNode = this.last;
        Node<T> nextNode = new Node<>(preNode, null, value);
        this.last = nextNode;

        if (preNode == null) {
            this.head = nextNode;
        } else {
            preNode.nextNode = nextNode;
        }

        ++this.size;

        return true;
    }

    /**
     * remove node.
     *
     * @param value something.
     * @return true or false.
     */
    public boolean remove(T value) {

        if (value != null) {
            Node<T> temp;

            for (temp = this.head; temp != null; temp = temp.nextNode) {
                if (value.equals(temp.value)) {

                    Node<T> preNode = temp.preNode;
                    Node<T> nextNode = temp.nextNode;

                    if (preNode == null) {
                        this.head = nextNode;
                    } else {
                        preNode.nextNode = nextNode;
                        temp.preNode = null;
                    }

                    if (nextNode == null) {
                        this.last = preNode;
                    } else {
                        nextNode.preNode = preNode;
                        temp.nextNode = null;
                    }

                    temp.value = null;

                    --this.size;

                    return true;
                }
            }
        }

        return false;
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

    /**
     * get value.
     *
     * @param index the index of list.
     * @return value.
     */
    public T getValue(int index) {
        T value = null;

        Node<T> temp;
        int i;

        if (index < (this.size / 2)) {
            temp = this.head;

            for (i = 0; i < index; i++) {
                temp = temp.nextNode;
            }

            value = temp.value;

        } else {
            temp = this.last;

            for (i = this.size - 1; i > index; i--) {
                temp = temp.preNode;
            }

            value = temp.value;
        }

        return value;
    }
}
