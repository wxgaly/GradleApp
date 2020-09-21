package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-25 14:38.
 * @version V1.0
 */
public class ValidBoomerang {

    public static void main(String[] args) {

        int[][] points = new int[][]{
                {1, 1},
                {2, 1},
                {3, 3}
        };

        System.out.println(isBoomerang1(points));

    }

    /**
     * 按照斜率的方式去解，主要要解决过原点的问题
     *
     * @param points
     * @return
     */
    public static boolean isBoomerang(int[][] points) {
        if (points == null || points.length < 3) {
            return false;
        }

        int[] pa = points[0];
        int[] pb = points[1];
        int[] pc = points[2];

        int k = 0;
        int res = pa[0] - pb[0];
        if (res != 0) {
            k = (pa[1] - pb[1]) / res;
        }

        int b = pa[1] - k * pa[0];
        int y = k * pc[0] + b;

        return y != pc[1];
    }

    /**
     * 两边之和大于第三边
     *
     * @param points
     * @return
     */
    public static boolean isBoomerang1(int[][] points) {
        if (points == null || points.length < 3) {
            return false;
        }

        int[] pa = points[0];
        int[] pb = points[1];
        int[] pc = points[2];

        int ab = getPointLen(pa, pb);
        int bc = getPointLen(pb, pc);
        int ac = getPointLen(pa, pc);

        return (ab + bc) <= ac;
    }

    private static int getPointLen(int[] point1, int[] point2) {
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];

        return (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

}
