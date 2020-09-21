package question.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * question.easy.
 *
 *
 * Given three integer arrays arr1, arr2 and arr3?sorted in strictly increasing order,
 * return a sorted array of only?the?integers that appeared in all three arrays.
 *
 * ?
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 * ?
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
        ArrayList arrayList = (ArrayList) intersectionOfThreeSortedArrays.arraysIntersection2(arr1, arr2, arr3);
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

    /**
     * 折半查找虽然速度较快，但是依然需要多次循环
     *
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public List<Integer> arraysIntersection2(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            if (Arrays.binarySearch(arr2, i) >= 0 && Arrays.binarySearch(arr3, i) >= 0) {
                list.add(i);
            }
        }

        return list;
    }

    /**
     * 标记法，一次循环。
     *
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public List<Integer> arraysIntersection4(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> nums = new LinkedList<>();
        for(int i=0,j=0,k=0;i<arr1.length&&j<arr2.length&&k<arr3.length;i++,j++,k++){
            int a = arr1[i];
            int b = arr2[j];
            int c = arr3[k];
            if(a==b&&b==c){
                nums.add(a);
            }
            if(a>b||a>c){
                i--;
            }
            if(b>a||b>c){
                j--;
            }
            if(c>a||c>b){
                k--;
            }
        }
        return nums;
    }


}
