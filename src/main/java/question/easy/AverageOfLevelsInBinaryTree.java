package question.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-11 14:23.
 * @version V1.0
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 *
 */
public class AverageOfLevelsInBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); //队列存储中间节点
        LinkedList<Double> res = new LinkedList<>();//返回结果结果
        double sum = 0;
        int count = 0;  //sum表示层次元素的和，count表示层次元素的个数
        TreeNode last = root, nlast = root;//last表示当前行的最后一个节点，nlast表示下一行的最后节点
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();  //取出队列首节点
            if (cur.left != null) {
                queue.add(cur.left); //每次访问孩子，豆浆nlast指向
                nlast = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nlast = cur.right;
            }
            sum += cur.val; //层集合加入当前节点
            count++;
            if (cur == last) {  //如果到了尾节点说明当前行已经访问完了
                res.add(sum / count);
                last = nlast;
                sum = 0;
                count = 0;
            }
        }
        return res;
    }
}
