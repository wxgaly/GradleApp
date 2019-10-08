package question.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * question.easy.
 *
 *
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
 * return a sorted array of only the integers that appeared in all three arrays.
 *
 *  
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 *  
 *
 * Constraints:
 *
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 *
 *
 * @author Created by WXG on 2019-10-08 16:59
 * @version V1.0
 */
public class IntersectionOfThreeSortedArrays {

    public static void main(String[] args) {
        IntersectionOfThreeSortedArrays intersectionOfThreeSortedArrays = new IntersectionOfThreeSortedArrays();
        int[] arr1 = new int[]{
                1, 2, 3, 4, 5
        };
        int[] arr2 = new int[]{
                1, 2, 5, 7, 9
        };
        int[] arr3 = new int[]{
                1, 3, 4, 5, 8
        };
        ArrayList arrayList = (ArrayList) intersectionOfThreeSortedArrays.arraysIntersection1(arr1, arr2, arr3);
        System.out.println(arrayList.toString());
    }

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            for (int i1 : arr2) {
                for (int i2 : arr3) {
                    if (i == i1 && i == i2) {
                        list.add(i);
                    }
                }
            }
        }
        return list;
    }

    public List<Integer> arraysIntersection1(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for (int i : arr1) {
            list1.add(i);
        }

        for (int i : arr2) {
            list2.add(i);
        }

        for (int i : arr3) {
            list3.add(i);
        }

        list1.retainAll(list2);
        list1.retainAll(list3);

        return list1;
    }

}
