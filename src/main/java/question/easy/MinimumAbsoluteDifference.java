package question.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-11-23 15:25
 * @version V1.0
 *
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *  
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *  
 *
 * Constraints:
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 *
 */
public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();
        int[] arr = new int[]{
                3,8,-10,23,19,-4,-14,27
        };
        List<List<Integer>> lists = minimumAbsoluteDifference.minimumAbsDifference(arr);
        for (List<Integer> list : lists) {
            System.out.println("[" + list.get(0) + ", " + list.get(1) + "]");
        }
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Arrays.sort(arr);
        int length = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i + 1 < length) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                res.add(temp);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = res.get(0);
        result.add(list1);
        int min = list1.get(1) - list1.get(0);
        int size = res.size();
        for (int i = 1; i < size; i++) {
            List<Integer> list = res.get(i);
            int temp = list.get(1) - list.get(0);
            if (temp < min) {
                result.clear();
                result.add(list);
                min = temp;
            } else if (temp == min) {
                result.add(list);
            }
        }

        return result;
    }

    public List<List<Integer>> minimumAbsDifference1(int[] arr) {
        Arrays.sort(arr);
        int l = arr.length;
        int min = arr[l-1] - arr[0];
        List<List<Integer>> res = new ArrayList<>();

        // 遍历第一遍找出min gap
        for (int i = 1; i < l; i++) {
            min = Math.min(min, arr[i] - arr[i-1]);
        }

        // 遍历第二遍相邻元素gap与min gap比较即可
        for (int i = 1; i < l; i++) {
            List<Integer> pair = new ArrayList<>();
            if (min == arr[i] - arr[i-1]) {
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                res.add(pair);
            }
        }
        return res;
    }

    public List<List<Integer>> min(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int dif = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i + 1] - arr[i] < dif) {
                dif = arr[i + 1] - arr[i];
                res.clear();
                List<Integer> l = new ArrayList<Integer>();
                l.add(arr[i]);
                l.add(arr[i + 1]);
                res.add(l);
            } else if(arr[i + 1] - arr[i] == dif) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(arr[i]);
                l.add(arr[i + 1]);
                res.add(l);
            }
        }
        return res;
    }

}
