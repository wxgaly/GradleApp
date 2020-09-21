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
 * Return the minimum number of students not standing in the right positions.?
 * (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * <p>
 * ?
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 * ?
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
     * ����Ͱ�����˼��
     *
     * @param heights
     * @return
     */
    public int heightChecker1(int[] heights) {
        // ֵ�ķ�Χ��1 <= heights[i] <= 100�������Ҫ1,2,3,...,99,100����101��Ͱ
        int[] arr = new int[101];
        // ��������heights������ÿ��Ͱ���ж��ٸ�Ԫ�أ�Ҳ��������heights���ж��ٸ�1�����ٸ�2�������������ٸ�100
        // ����101��Ͱ�е�Ԫ�أ�һ��һ��Ͱ��ȡ������Ԫ�ؾ��������
        for (int height : heights) {
            arr[height]++;
        }

        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            // arr[i]��i����Ͱ�д�ŵ�Ԫ�ص�ֵ��arr[i]��Ԫ�صĸ���
            // arr[i]-- ����ÿ��ȡ��һ����һֱȡ��û��Ԫ�أ���Ϊ��Ͱ
            while (arr[i]-- > 0) {
                // ��Ͱ��ȡ��Ԫ��ʱ��Ԫ�ص�����˳����Ƿǵݼ��ģ�Ȼ����heights�е�Ԫ�رȽϣ������ͬ���������ͼ�1
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }

}
