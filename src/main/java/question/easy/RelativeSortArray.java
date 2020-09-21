package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-08-07 15:19.
 * @version V1.0
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 *
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.?
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * ?
 *
 * Example 1:
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * ?
 *
 * Constraints:
 *
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each?arr2[i]?is?distinct.
 * Each?arr2[i] is in arr1.
 *
 *
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{
                2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19
        };

        int[] arr2 = new int[]{
                2, 1, 4, 3, 9, 6
        };

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0) {
            return arr1;
        }

        int[] result = new int[arr1.length];
        List<Integer> resultList = new ArrayList<>();
        List<Integer> sortedArr = new ArrayList<>();
        for (int i : arr1) {
            sortedArr.add(i);
        }
        Collections.sort(sortedArr);

        //先找到对应的元素，添加到resultList,移除sortedArr元素
        for (int i : arr2) {
            for (Integer integer : sortedArr) {
                if (i == integer) {
                    resultList.add(integer);
                }
            }

            sortedArr.removeAll(resultList);
        }

        //添加到result数组中
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        int start = resultList.size();
        int i = 0;
        for (Integer integer : sortedArr) {
            result[start + i] = integer;
            i++;
        }

        return result;
    }

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] m = new int[1001];

        int[] ref = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            m[arr1[i]]++;
        }

        int cnt = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (m[arr2[i]] > 0) {
                ref[cnt++] = arr2[i];
                m[arr2[i]]--;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
            }
        }
        return ref;

    }

}
