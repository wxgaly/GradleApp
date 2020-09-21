package question.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * question.medium.
 *
 * @author Created by WXG on 2020-08-17 14:27
 * @version V1.0

    In an infinite binary tree where every node has two children, the nodes are labelled in row order.

    In the odd numbered rows (ie., the first, third, fifth,...), the labelling is left to right,
    while in the even numbered rows (second, fourth, sixth,...), the labelling is right to left.



    Given the label of a node in this tree, return the labels in the path from the root of the tree to the?node with that label.

    ?

    Example 1:

    Input: label = 14
    Output: [1,3,4,14]
    Example 2:

    Input: label = 26
    Output: [1,2,6,10,26]
    ?

    Constraints:

    1 <= label <= 10^6

 *
 */
public class PathInZigzagLabelledBinaryTree {

    public static void main(String[] args) {
        PathInZigzagLabelledBinaryTree pathInZigzagLabelledBinaryTree1 = new PathInZigzagLabelledBinaryTree();
        for (Integer integer : pathInZigzagLabelledBinaryTree1.pathInZigZagTree(14)) {
            System.out.printf(integer + ", ");
        }
    }

    /**
     * û���ҵ����ʵķ�����ʹ�������
     * ����Ŀ���˼·��Ҫ����ȫ������������
     * https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/solution/jian-dan-yi-dong-de-gong-shi-shi-jian-guo-100-by-a/
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> integers = new ArrayList<>();//0.��ʼ����Ž���ı���
        int a = (int) (Math.log(label) / Math.log(2));//2.����label���ڵĲ�
        while (label > 1) {//5.ѭ��ֱ�������������1
            integers.add(label);//3.��label�Ľ����ӵ�������
            label = (int) (3 * Math.pow(2, --a) - label / 2 - 1);//4.������һ��label��ֵ
        }
        integers.add(1);//6.���������� 1
        Collections.reverse(integers); //7.��ת����
        return integers;//1.���ؽ��
    }


}
