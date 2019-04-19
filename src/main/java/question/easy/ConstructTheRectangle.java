package question.easy;

import java.util.Arrays;

/**
 * question.easy.ConstructTheRectangle
 *
 * @author Created by WXG on 2019-4-19 13:54.
 * @version V1.0
 * <p>
 * For a web developer, it is very important to know how to design a web page's size.
 * So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page,
 * whose length L and width W satisfy the following requirements:
 * <p>
 * 1. The area of the rectangular web page you designed must equal to the given target area.
 * <p>
 * 2. The width W should not be larger than the length L, which means L >= W.
 * <p>
 * 3. The difference between length L and width W should be as small as possible.
 * You need to output the length L and the width W of the web page you designed in sequence.
 * Example:
 * Input: 4
 * Output: [2, 2]
 * Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
 * But according to requirement 2, [1,4] is illegal; according to requirement 3,
 * [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
 * Note:
 * The given area won't exceed 10,000,000 and is a positive integer
 * The web page's width and length you designed must be positive integers.
 */

public class ConstructTheRectangle {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructRectangle1(12)));
    }

    public static int[] constructRectangle(int area) {
        if (area <= 0) {
            return null;
        }

        int end = area / 2;

        int width = 1;
        int height = area;

        for (int i = 1; i <= end; i++) {
            if (area % i == 0) {
                int temp = area / i;
                if (Math.abs(temp - i) < Math.abs(height - width)) {
                    width = i;
                    height = temp;
                }
            }
        }

        return new int[]{height, width};
    }

    /**
     * 用开平方求得最小取值处，然后递减找到整除数即可
     *
     * @param area
     * @return
     */
    public static int[] constructRectangle1(int area) {
        int n = (int) Math.sqrt(area);
        for (int L = n; L >= 2; L--) {
            if (area % L == 0) {
                return new int[]{area / L, L};
            }
        }
        return new int[]{area, 1};
    }

}
