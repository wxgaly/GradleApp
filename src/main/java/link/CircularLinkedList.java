package link;

/**
 * link.CircularLinkedList
 *
 * @author Created by WXG on 2019/2/17 22:39.
 * @version V1.0
 */

public class CircularLinkedList<T> {

    private Node<T> head;

    public CircularLinkedList() {
        head = new Node<>(null, null, null);
        head.value = null;
        head.nextNode = head;
    }

    /**
     * add node.
     *
     * @param value something.
     * @return true or false.
     */
    public boolean add(T value) {

        Node<T> nextNode = new Node<>(null, null, value);

        if (head.nextNode.equals(head)) {
            this.head.nextNode = nextNode;
        } else {
            Node<T> tempNode = head;
            while (!tempNode.nextNode.equals(head)) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = nextNode;
        }

        nextNode.nextNode = head;

        return true;
    }

    public Node<T> getNode(int index) {
        index++;
        if (index <= 0 || index > getSize()) {
            return null;
        } else {
            int count = 0;
            Node<T> node = new Node<>(null, null, null);
            Node<T> temp = head;

            while (!temp.nextNode.equals(head)) {
                count++;
                if (count == index) {
                    node.value = temp.nextNode.value;
                    break;
                }
                temp = temp.nextNode;
            }

            return node;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> setHead(int index) {
        this.head = getNode(index);
        return this.head;
    }

    public int getSize() {
        Node node = head;
        int size = 0;
        while (!node.nextNode.equals(head)) {
            size++;
            node = node.nextNode;
        }
        return size;
    }

}
