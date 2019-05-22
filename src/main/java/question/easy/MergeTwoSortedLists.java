package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-05-22 16:19.
 * @version V1.0
 * <p>
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);
        l2.next.next.next = new ListNode(6);

        printLists(l1);
        printLists(l2);
        printLists(mergeTwoLists(l1, l2));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode listNode = new ListNode(0);

            if (l1.val > l2.val) {
                listNode.val = l2.val;
                listNode.next = mergeTwoLists(l1, l2.next);
            } else {
                listNode.val = l1.val;
                listNode.next = mergeTwoLists(l1.next, l2);
            }

            return listNode;
        }
    }

    private static void printLists(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }

}
