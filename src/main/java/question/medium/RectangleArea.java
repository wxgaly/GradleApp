package question.medium;

/**
 * question.medium.RectangleArea
 *
 * @author Created by WXG on 2019/3/25 025 16:33.
 * @version V1.0
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Rectangle Area
 *
 * Example:
 *
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * Note:
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 */

public class RectangleArea {

    public static void main(String[] args) {
        int A = -3, B = 0, C = 3, D = 4;
        int E = 0, F = -1, G = 9, H = 2;

        System.out.println(computeArea(-3, -3, 3, 3, -2, -2, 2, 2));
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

}
