package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-06-14 14:13.
 * @version V1.0
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *  
 *
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 *
 *  
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 *
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{
                1, 8, 6, 2, 5, 4, 8, 3, 7
        };

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if (height == null) return 0;
        if (height.length == 2) {
            return height[0] > height[1] ? height[1] : height[0];
        }
        int left = 0, right = height.length - 1;
        int area = 0;

        while (left < right) {
            if (height[left] < height[right]) {

                int temp = height[left] * (right - left);
                if (area < temp) {
                    area = temp;
                }

                ++left;
            } else {

                int temp = height[right] * (right - left);
                if (area < temp) {
                    area = temp;
                }

                --right;
            }
        }

        return area;
    }

}
