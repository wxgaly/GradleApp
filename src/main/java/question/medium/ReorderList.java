package question.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-07-26 14:55.
 * @version V1.0
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 *
 */
public class ReorderList {

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
        reorderList1(head);

        printNode(head);
    }

    public static void reorderList(ListNode head) {
        if (head != null) {
            List<ListNode> listNodes = new ArrayList<>();

            ListNode temp = head;
            while (head != null) {
                listNodes.add(new ListNode(head.val));
                head = head.next;
            }

            head = temp;

            int len = listNodes.size();
            List<ListNode> listNodeTemp = new ArrayList<>();
            if (len % 2 == 0) {
                int n = len / 2;
                for (int i = 0; i < n; i++) {
                    listNodeTemp.add(listNodes.get(i));
                    listNodeTemp.add(listNodes.get(len - i - 1));
                }
            } else {
                int n = (len + 1) / 2;
                for (int i = 0; i < n; i++) {
                    listNodeTemp.add(listNodes.get(i));
                    int index = len - i - 1;
                    if (index != i) {
                        listNodeTemp.add(listNodes.get(index));
                    }
                }
            }

            for (ListNode listNode : listNodeTemp) {
                temp.val = listNode.val;
                temp = temp.next;
            }

        }
    }

    private static void printNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }


    /**
     * 先把链表分为两段，反转第二段链表，然后合并两个链表
     *
     * @param head
     */
    public static void reorderList1(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode p1 = head;
        ListNode p2 = head;

        // 找到链表的一半
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // 将链表分为两段
        p2 = p1.next;
        p1.next = null;
        p1 = head;

        // 将后半段进行链表的翻转
        ListNode head2 = p2;
        ListNode next2;
        while (p2.next != null) {
            next2 = p2.next;
            p2.next = next2.next;
            next2.next = head2;
            head2 = next2;
        }
        p2 = head2;

        // 两条链表进行合并
        ListNode next1;
        while (p2 != null) {
            next1 = p1.next;
            next2 = p2.next;

            p1.next = p2;
            p2.next = next1;

            p1 = next1;
            p2 = next2;
        }

    }


}
