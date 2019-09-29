package question.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-09-29 14:35
 * @version V1.0
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * For example, given a 3-ary tree:
 *  
 *
 * Return its preorder traversal as: [1,3,5,6,2,4].
 *
 *  
 *
 * Note:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 *
 */
public class NaryTreePreorderTraversal {

    public static void main(String[] args) {
        NaryTreePreorderTraversal treePreorderTraversal = new NaryTreePreorderTraversal();

        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);

        List<Node> children56 = new ArrayList<>();
        children56.add(node5);
        children56.add(node6);
        Node node3 = new Node(3, children56);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);

        List<Node> children234 = new ArrayList<>();
        children234.add(node3);
        children234.add(node2);
        children234.add(node4);

        Node root = new Node(1, children234);

        List<Integer> list = treePreorderTraversal.preorder1(root);
        if (list instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) list;
            System.out.println(arrayList.toString());
        }

    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            //头结点加入结果集
            res.add(cur.val);
            //将该节点的子节点从右往左压入栈
            List<Node> nodeList = cur.children;
            for (int i = nodeList.size() - 1; i >= 0; i--) {
                stack.push(nodeList.get(i));
            }
        }
        return res;
    }


    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for (Node child : root.children) {
                    list.addAll(preorder1(child));
                }
            }
        }

        return list;
    }

}
