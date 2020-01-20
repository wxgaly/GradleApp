package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-01-20 18:04
 * @version V1.0
 *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right,
 * and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 *  
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 *  
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 *
 *
 */
public class ReplaceElementswithGreatestElementonRightSide {

    public static void main(String[] args) {
        int[] arr = new int[]{
                9074, 25898, 7237, 60756, 17678, 88969, 4837, 43425, 57865, 53350
        };
        ReplaceElementswithGreatestElementonRightSide side = new ReplaceElementswithGreatestElementonRightSide();
        System.out.println(Arrays.toString(side.replaceElements1(arr)));
    }

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return new int[]{
                    -1
            };
        }
        int[] res = new int[len];
        System.arraycopy(arr, 0, res, 0, len);
        int index = binarySearchMax(arr, 1);
        int max = arr[index];
        for (int i = 0; i < len; i++) {
            if (i < index) {
                res[i] = max;
            } else {
                if (i == len - 1) {
                    res[i] = -1;
                } else {
                    index = binarySearchMax(arr, i + 1);
                    max = arr[index];
                    i--;
                }
            }
        }
        return res;
    }

    /**
     * 逆序遍历
     *
     * @param arr
     * @return
     */
    public int[] replaceElements1(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        ans[n - 1] = -1;
        for (int i = n - 2; i >= 0; --i) {
            ans[i] = Math.max(ans[i + 1], arr[i + 1]);
        }
        return ans;
    }

    public int binarySearchMax(int[] arr, int offset) {
        int len = arr.length;
        int left = offset;
        int right = len - 1;
        int index = offset;
        int max = arr[offset];
        while (left <= right) {
            if (max < arr[left]) {
                max = arr[left];
                index = left;
            }

            if (max < arr[right]) {
                max = arr[right];
                index = right;
            }

            left++;
            right--;
        }
        return index;
    }

}
