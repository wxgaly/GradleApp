package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-05-12 17:57.
 * @version V1.0
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(2);

        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        printfListNode(head);
        printfListNode(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) head = head.next;
        return head;
    }

    private static void printfListNode(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("======打印完毕======");
    }

}
