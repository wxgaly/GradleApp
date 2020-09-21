package link;

/**
 * link.Node
 *
 * @author Created by WXG on 2018/10/16 016 11:06.
 * @version V1.0
 */

class Node<T> {

    /**
     * ��һ���ڵ�
     */
    Node<T> preNode;

    /**
     * ��һ���ڵ�
     */
    Node<T> nextNode;

    /**
     * �洢��ֵ
     */
    T value;

    Node(Node<T> preNode, Node<T> nextNode, T value) {
        this.preNode = preNode;
        this.nextNode = nextNode;
        this.value = value;
    }
}
