package question.easy;

import java.util.Stack;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-19 15:32.
 * @version V1.0
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 *
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printfLinkedList(head);

        printfLinkedList(reverseList(head));
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        head = stack.pop();
        ListNode listNode = head;
        while (!stack.isEmpty()) {
            listNode.next = new ListNode(stack.pop().val);
            listNode = listNode.next;
        }

        return head;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private static void printfLinkedList(ListNode head) {
        if (head != null) {
            while (head != null) {
                System.out.println(head.val);
                head = head.next;
            }
        }
    }

}
