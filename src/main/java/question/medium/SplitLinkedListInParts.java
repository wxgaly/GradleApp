package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-07-22 14:34.
 * @version V1.0
 *
 * Given a (singly) linked list with head node root,
 * write a function to split the linked list into k consecutive linked list "parts".
 *
 * The length of each part should be as equal as possible:
 * no two parts should have a size differing by more than 1. This may lead to some parts being null.
 *
 * The parts should be in order of occurrence in the input list,
 * and parts occurring earlier should always have a size greater than or equal parts occurring later.
 *
 * Return a List of ListNode's representing the linked list parts that are formed.
 *
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3,
 * and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2:
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1,
 * and earlier parts are a larger size than the later parts.
 * Note:
 *
 * The length of root will be in the range [0, 1000].
 * Each value of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50].
 *
 */
public class SplitLinkedListInParts {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }

        int len = 0;
        ListNode temp = root;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (len % k == len) {
            ListNode[] listNodes = new ListNode[k];
            temp = root;
            for (int i = 0; i < len; i++) {
                listNodes[i] = temp;
                temp = temp.next;
            }

            return listNodes;
        } else {
            int count = len / k;
            return new ListNode[count];
        }
    }

    /**
     * 注意断链问题
     *
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts1(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int n = getLength(root);
        int len = n / k, left = n % k;
        ListNode pre = null;    // 记录链尾
        for (int i = 0; i < k && root != null; ++i) {
            res[i] = root;
            int step = len;
            if (left > 0) {
                --left;
                ++step;
            }
            for (int j = 0; j < step; ++j) {
                pre = root;
                root = root.next;
            }
            pre.next = null;    // 断链
        }
        return res;
    }

    private int getLength(ListNode root) {
        int res = 0;
        while (root != null) {
            ++res;
            root = root.next;
        }
        return res;
    }


}
