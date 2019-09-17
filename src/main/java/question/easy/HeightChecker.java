package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-09-16 18:14
 * @version V1.0
 * <p>
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * <p>
 * Return the minimum number of students not standing in the right positions. 
 * (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 *  
 * <p>
 * Note:
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightChecker {

    public static void main(String[] args) {
        int[] heights = new int[]{
                1, 1, 4, 2, 1, 3
        };
        HeightChecker heightChecker = new HeightChecker();
        System.out.println(heightChecker.heightChecker(heights));
    }

    public int heightChecker(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int count = 0;

        int len = heights.length;
        int[] heights1 = new int[len];
        System.arraycopy(heights, 0, heights1, 0, len);
        Arrays.sort(heights);

        for (int i = 0; i < len; i++) {
            if (heights[i] != heights1[i]) {
                count++;
            }
        }

        System.out.println(Arrays.toString(heights));

        return count;
    }

    /**
     * 借助桶排序的思想
     *
     * @param heights
     * @return
     */
    public int heightChecker1(int[] heights) {
        // 值的范围是1 <= heights[i] <= 100，因此需要1,2,3,...,99,100，共101个桶
        int[] arr = new int[101];
        // 遍历数组heights，计算每个桶中有多少个元素，也就是数组heights中有多少个1，多少个2，。。。，多少个100
        // 将这101个桶中的元素，一个一个桶地取出来，元素就是有序的
        for (int height : heights) {
            arr[height]++;
        }

        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            // arr[i]，i就是桶中存放的元素的值，arr[i]是元素的个数
            // arr[i]-- 就是每次取出一个，一直取到没有元素，成为空桶
            while (arr[i]-- > 0) {
                // 从桶中取出元素时，元素的排列顺序就是非递减的，然后与heights中的元素比较，如果不同，计算器就加1
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }

}
