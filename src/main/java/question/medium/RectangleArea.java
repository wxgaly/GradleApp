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

    //��Ŀ������Given a collection of distinct integers, return all possible permutations.������һ�鲻ͬ�����������������еĿ�����ϣ�
    public static List<List<Integer>> permute(int[] nums) {
        //һ��ȫ�ֱ��������ڱ������м���
        List<List<Integer>> list = new ArrayList<>();
        //��������������û�и��Ӳ���
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        //һ���ս�������Ҳ��������������ʱ��
        if (tempList.size() == nums.length) {
            //ȫ�ֱ������һ�����������ļ���
            list.add(new ArrayList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue;
                //���tempListû�а���nums[i]�����
                tempList.add(num);
                //�ݹ���ã���ʱ��tempListһֱ�ڱ仯��ֱ�������ս������Ž���
                backtrack(list, tempList, nums);
//                System.out.println("tempList������:" + tempList + "-------" + "i��ֵ:" + i);
                //���Ƴ�tempList���һ��Ԫ�ص����þ��Ƿ�����һ�ε���ʱ�����ݣ�Ҳ����ϣ������֮ǰ�Ľڵ���ȥ��������������������������ʵ�ֻ���
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}
