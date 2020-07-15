package question.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * question.medium.RectangleArea
 *
 * @author Created by WXG on 2019/3/25 025 16:33.
 * @version V1.0
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * <p>
 * Rectangle Area
 * <p>
 * Example:
 * <p>
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * Note:
 * <p>
 * Assume that the total area is never beyond the maximum possible value of int.
 */

public class RectangleArea {

    public static void main(String[] args) {
        int A = -3, B = 0, C = 3, D = 4;
        int E = 0, F = -1, G = 9, H = 2;

//        System.out.println(computeArea(-3, -3, 3, 3, -2, -2, 2, 2));
        for (List<Integer> list : permute(new int[]{1, 2, 3, 4})) {
            for (Integer integer : list) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
        if (C <= E || F >= D || B >= H || A >= G) {
            return area1 + area2;
        }
        int topX = Math.min(G, C), topY = Math.min(H, D);
        int bottomX = Math.max(E, A), bottomY = Math.max(B, F);
        return area1 - (topX - bottomX) * (topY - bottomY) + area2;
    }

    //题目描述：Given a collection of distinct integers, return all possible permutations.（给定一组不同的整数，返回其所有的可能组合）
    public static List<List<Integer>> permute(int[] nums) {
        //一个全局变量，用于保存所有集合
        List<List<Integer>> list = new ArrayList<>();
        //传入三个参数，没有附加参数
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        //一个终结条件，也就是满足条件的时候
        if (tempList.size() == nums.length) {
            //全局变量添加一个满足条件的集合
            list.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue;
                //如果tempList没有包含nums[i]才添加
                tempList.add(num);
                //递归调用，此时的tempList一直在变化，直到满足终结条件才结束
                backtrack(list, tempList, nums);
//                System.out.println("tempList的内容:" + tempList + "-------" + "i的值:" + i);
                //它移除tempList最后一个元素的作用就是返回上一次调用时的数据，也就是希望返回之前的节点再去重新搜索满足条件。这样才能实现回溯
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
