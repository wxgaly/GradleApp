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
}
