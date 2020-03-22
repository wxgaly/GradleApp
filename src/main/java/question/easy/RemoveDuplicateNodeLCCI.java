package question.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-22 22:17
 * @version V1.0
 *
 * Write code to remove duplicates from an unsorted linked list.
 *
 * Example1:
 *
 *  Input: [1, 2, 3, 3, 2, 1]
 *  Output: [1, 2, 3]
 * Example2:
 *
 *  Input: [1, 1, 1, 1, 2]
 *  Output: [1, 2]
 * Note:
 *
 * The length of the list is within the range[0, 20000].
 * The values of the list elements are within the range [0, 20000].
 *
 */
public class RemoveDuplicateNodeLCCI {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = new ListNode(0);
        ListNode current = head;
        prev.next = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (current != null) {
            if (map.getOrDefault(current.val, -1) == -1) {
                map.put(current.val, 1);
                prev = current;
            } else {
                prev.next = current.next;
            }

            current = current.next;
        }

        return head;
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        Set<Integer> s = new HashSet<Integer>();
        while (current != null) {
            if (!s.contains(current.val)) {
                s.add(current.val);
                prev = current;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return head;
    }

}
