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



    Given the label of a node in this tree, return the labels in the path from the root of the tree to the node with that label.

     

    Example 1:

    Input: label = 14
    Output: [1,3,4,14]
    Example 2:

    Input: label = 26
    Output: [1,2,6,10,26]
     

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
     * 没有找到合适的方法，使用了题解
     * 这题的考察思路主要是完全二叉树的特性
     * https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/solution/jian-dan-yi-dong-de-gong-shi-shi-jian-guo-100-by-a/
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> integers = new ArrayList<>();//0.初始化存放结果的变量
        int a = (int) (Math.log(label) / Math.log(2));//2.计算label所在的层
        while (label > 1) {//5.循环直到遇到特殊情况1
            integers.add(label);//3.将label的结果添加到数组中
            label = (int) (3 * Math.pow(2, --a) - label / 2 - 1);//4.计算下一个label的值
        }
        integers.add(1);//6.添加特殊情况 1
        Collections.reverse(integers); //7.翻转数组
        return integers;//1.返回结果
    }


}
