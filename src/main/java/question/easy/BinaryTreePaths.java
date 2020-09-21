package question.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-12-13 14:33
 * @version V1.0
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note:?A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 *
 */
public class BinaryTreePaths {

    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            path += Integer.toString(root.val);
            if ((root.left == null) && (root.right == null))  // ��ǰ�ڵ���Ҷ�ӽڵ�
                paths.add(path);  // ��·�����뵽����
            else {
                path += "->";  // ��ǰ�ڵ㲻��Ҷ�ӽڵ㣬�����ݹ����
                construct_paths(root.left, path, paths);
                construct_paths(root.right, path, paths);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        construct_paths(root, "", paths);
        return paths;
    }


}
