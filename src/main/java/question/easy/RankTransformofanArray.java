package question.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-13 15:43
 * @version V1.0
 *
 * Given an array of integers arr, replace each element with its rank.
 *
 * The rank represents how large the element is. The rank has the following rules:
 *
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 *  
 *
 * Example 1:
 *
 * Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
 * Example 2:
 *
 * Input: arr = [100,100,100]
 * Output: [1,1,1]
 * Explanation: Same elements share the same rank.
 * Example 3:
 *
 * Input: arr = [37,12,28,9,100,56,80,5,12]
 * Output: [5,3,4,2,8,6,7,1,3]
 *  
 *
 * Constraints:
 *
 * 0 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 *
 *
 */
public class RankTransformofanArray {

    public static void main(String[] args) {

    }

    public int[] arrayRankTransform(int[] arr) {
        int a[] = arr.clone();
        Arrays.sort(a);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < a.length; i++) {
            if (i > 0 && a[i] != a[i - 1]) {
                map.put(a[i], index);
                index++;
            }
            if (i == 0) {
                map.put(a[i], index);
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }

}
