package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-06-13 14:23.
 * @version V1.0
 */
public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printNode(head);

        printNode(oddEvenList1(head));
    }

    /**
     * ˫ָ�룬û�ú�
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode next = head.next;
        ListNode last = null;
        ListNode temp = head;

        int i = 1;
        while (head != null) {
            i += 2;
            head = head.next.next;

            head.next = head.next.next.next;

            if (head.next == null) {
                last = head;
                break;
            }

            head = head.next.next;
        }

        return temp;
    }

    /**
     * ��ָ�뷨�� ��������˼·
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head Ϊ������ͷ��㣬o Ϊ������β�ڵ�
        ListNode o = head;

        // p Ϊż����ͷ���
        ListNode p = head.next;

        // e Ϊż����β�ڵ�
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }

    private static void printNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }

}
