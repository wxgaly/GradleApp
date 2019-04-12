package question.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * question.easy.NTreePostorderTraversal
 *
 * @author Created by WXG on 2019-4-12 14:01.
 * @version V1.0
 * <p>
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * <p>
 * Return its postorder traversal as: [5,6,3,2,4,1].
 * <p>
 * <p>
 * Note:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 */

public class NTreePostorderTraversal {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        List<Node> children = new ArrayList<>();
        Node root = new Node(1, children);
        List<Node> children1 = new ArrayList<>();
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        children1.add(node5);
        children1.add(node6);
        Node node3 = new Node(3, children1);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        children.add(node3);
        children.add(node2);
        children.add(node4);

//        postorder(root).forEach(System.out::println);
        postorderNonRecursive(root).forEach(System.out::println);
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.children == null || root.children.isEmpty()) {
            list.add(root.val);
        } else {
            for (Node child : root.children) {
                if (child != null) {
                    list.addAll(postorder(child));
                }
            }
            list.add(root.val);
        }

        return list;
    }

    public static List<Integer> postorderNonRecursive(Node root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node.children == null) {
                res.add(stack.pop().val);
            } else {
                // for (int i = node.children.size() - 1; i >= 0; i--) {
                //     stack.push(node.children.get(i));
                // }
                stack.addAll(0, node.children);
                // 表示已遍历过其子节点（不太好，直接改变原节点信息了，但比较简单）
                node.children = null;
            }
        }
        return res;
    }

}
