package question.easy;

import javafx.util.Pair;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-17 14:08
 * @version V1.0
 * <p>
 * Given a n-ary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 *  
 * <p>
 * <p>
 *  
 * <p>
 * We should return its max depth, which is 3.
 * <p>
 *  
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class MaximumDepthOfNaryTree {

    public static void main(String[] args) {
        MaximumDepthOfNaryTree maximumDepthOfNaryTree = new MaximumDepthOfNaryTree();

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
        System.out.println(maximumDepthOfNaryTree.maxDepth(root));
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

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else {
            if (root.children != null) {
                List<Integer> heights = new ArrayList<>();
                for (Node child : root.children) {
                    heights.add(maxDepth(child));
                }
                return Collections.max(heights) + 1;
            } else {
                return 1;
            }
        }
    }

    public int maxDepth1(Node root) {
        Queue<Pair<Node, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                for (Node c : root.children) {
                    stack.add(new Pair(c, current_depth + 1));
                }
            }
        }
        return depth;
    }

}
