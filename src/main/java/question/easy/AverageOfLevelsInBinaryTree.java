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
        Queue<TreeNode> queue = new LinkedList<>(); //���д洢�м�ڵ�
        LinkedList<Double> res = new LinkedList<>();//���ؽ�����
        double sum = 0;
        int count = 0;  //sum��ʾ���Ԫ�صĺͣ�count��ʾ���Ԫ�صĸ���
        TreeNode last = root, nlast = root;//last��ʾ��ǰ�е����һ���ڵ㣬nlast��ʾ��һ�е����ڵ�
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();  //ȡ�������׽ڵ�
            if (cur.left != null) {
                queue.add(cur.left); //ÿ�η��ʺ��ӣ�����nlastָ��
                nlast = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nlast = cur.right;
            }
            sum += cur.val; //�㼯�ϼ��뵱ǰ�ڵ�
            count++;
            if (cur == last) {  //�������β�ڵ�˵����ǰ���Ѿ���������
                res.add(sum / count);
                last = nlast;
                sum = 0;
                count = 0;
            }
        }
        return res;
    }
}
