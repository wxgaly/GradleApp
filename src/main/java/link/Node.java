package link;

/**
 * link.Node
 *
 * @author Created by WXG on 2018/10/16 016 11:06.
 * @version V1.0
 */

class Node<T> {

    /**
     * 上一个节点
     */
    Node<T> preNode;

    /**
     * 下一个节点
     */
    Node<T> nextNode;

    /**
     * 存储的值
     */
    T value;

    Node(Node<T> preNode, Node<T> nextNode, T value) {
        this.preNode = preNode;
        this.nextNode = nextNode;
        this.value = value;
    }
}
