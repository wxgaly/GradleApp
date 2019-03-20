package question.hard;

/**
 * question.hard.TrappingRainWater
 *
 * @author Created by WXG on 2019/3/20 020 14:10.
 * @version V1.0
 */

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height.length <= 2 || height == null) return 0;
        int left = 0, right = height.length - 1;
        int area = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax)
                    leftMax = height[left];
                else
                    area += leftMax - height[left];
                ++left;
            }
            else {
                if (height[right] >= rightMax)
                    rightMax = height[right];
                else
                    area += rightMax - height[right];
                --right;
            }
        }
        return area;
    }

}
