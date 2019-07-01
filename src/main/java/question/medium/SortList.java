package question.medium;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-07-01 14:21.
 * @version V1.0
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 *
 *
 */
public class SortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next  =new ListNode(1);
        printListNode(head);

        printListNode(sortList(head));

    }

    public static ListNode sortList(ListNode head) {

        if (head == null) {
            return head;
        } else {
            List<Integer> list = new ArrayList<>();

            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            Collections.sort(list);

            ListNode newNode = new ListNode(list.get(0));
            ListNode temp = newNode;

            for (int i = 1; i < list.size(); i++) {
                temp.next = new ListNode(list.get(i));
                temp = temp.next;
            }

            return newNode;
        }
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

}
