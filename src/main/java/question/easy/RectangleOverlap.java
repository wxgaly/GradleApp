package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-02 14:37
 * @version V1.0
 *
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner,
 * and (x2, y2) are the coordinates of its top-right corner.
 *
 * Two rectangles overlap if the area of their intersection is positive. 
 * To be clear, two rectangles that only touch at the corner or edges do not overlap.
 *
 * Given two (axis-aligned) rectangles, return whether they overlap.
 *
 * Example 1:
 *
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 *
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 *
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 *
 *
 */
public class RectangleOverlap {

    public static void main(String[] args) {

    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        boolean result = false;

        //先判断rec2四个顶点是否在rec1内部
        int[] A = new int[]{rec1[0], rec1[1]};
        int[] B = new int[]{rec1[0], rec1[3]};
        int[] C = new int[]{rec1[2], rec1[1]};
        int[] D = new int[]{rec1[2], rec2[3]};


        //在判断rec1四个顶点是否在rec2内部


        return result;
    }

    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {

        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top

    }


}
