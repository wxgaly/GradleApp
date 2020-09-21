package question.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-08-09 14:11.
 * @version V1.0
 *
 * Given a non-empty, singly?linked list with head node head, return?a?middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * ?
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 * ?
 *
 * Note:
 *
 * The number of nodes in the given list will be between 1?and 100.
 *
 */
public class MiddleOfTheLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 数组取中间值
     *
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        if (head == null) {
            return head;
        }
        List<ListNode> listNodeList = new ArrayList<>();
        while (head != null) {
            listNodeList.add(head);
            head = head.next;
        }
        return listNodeList.get(listNodeList.size() / 2);
    }

    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

}
