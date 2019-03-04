package question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * question.NextGreaterElementI
 *
 * @author Created by WXG on 2019/3/3 15:43.
 * @version V1.0
 */

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};

//        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));

        nums1 = new int[]{2, 4};
        nums2 = new int[]{1, 2, 3, 4};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int num1Len = nums1.length;
        int maxLen = nums2.length;
        int[] result = new int[num1Len];
        Map<Integer, Integer> mapValue = new HashMap<>(maxLen);

        for (int i = 0; i < maxLen; i++) {
            mapValue.put(nums2[i], i);
        }

        for (int i = 0; i < num1Len; i++) {
            result[i] = -1;
            int num2Index = mapValue.get(nums1[i]);
            for (int j = num2Index; j < maxLen; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }

}
