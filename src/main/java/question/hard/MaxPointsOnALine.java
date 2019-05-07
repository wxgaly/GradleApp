package question.hard;

import java.util.*;

/**
 * question.hard.
 *
 * @author Created by WXG on 2019-05-07 15:19.
 * @version V1.0
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * NOTE: input types have been changed on April 15, 2019.
 * Please reset to default code definition to get new method signature.
 *
 */
public class MaxPointsOnALine {

    public static void main(String[] args) {

    }

    /**
     * 1. 用字典记录结果，最后返回重复次数最多的
     * 2. 可能存在斜率不存在的情况，
     * 3. 使用除法可能存在精度问题
     *
     * @param points
     * @return
     */
    public static int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Map<float[], Integer> map = new HashMap<>();

        int len = points.length;

        for (int i = 0; i < len; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < len; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];


            }
        }

        int max = -1;

        for (Integer value : map.values()) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    private static float[] getPara(int x1, int y1, int x2, int y2) {
        float[] paras = new float[2];

        float k = (float) (y2 - y1) / (x2 - x1);
        float b = y1 - k * x1;

        paras[0] = k;
        paras[1] = b;

        return paras;
    }


    /**
     * 评论区正确答案
     *
     * @param points
     * @return
     */
    public int maxPoints1(int[][] points) {
        if (points.length <= 2)
            return points.length;
        int result = 0;
        int n = points.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.clear(); // clear the map to avoid counting points in different parallel lines
            int samePoints = 1;
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                if (dx == 0 && dy == 0) {  // check for the duplicate points
                    samePoints++;
                    continue;
                }

                // find the greatest common divisor of dx and dy
                int gcd = GCD(dx, dy);
                String slope = (dx / gcd) + "#" + (dy / gcd);

                if (!map.containsKey(slope))
                    map.put(slope, 1);
                else
                    map.put(slope, map.get(slope) + 1);

            }

            if (map.isEmpty()) {
                if (samePoints > result)
                    result = samePoints;
            } else {
                for (int num : map.values()) {
                    if (num + samePoints > result)
                        result = num + samePoints;
                }
            }
        }
        return result;
    }

    private int GCD(int a, int b) {
        return (b == 0) ? a : GCD(b, a % b);
    }

}
