package question.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-23 17:45
 * @version V1.0
 *
 *
 * Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
 *
 * Return a lucky integer in the array. If there are multiple lucky integers return the largest of them.
 * If there is no lucky integer return -1.
 *
 *  
 *
 * Example 1:
 *
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * Example 2:
 *
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 * Example 3:
 *
 * Input: arr = [2,2,2,3,3]
 * Output: -1
 * Explanation: There are no lucky numbers in the array.
 * Example 4:
 *
 * Input: arr = [5]
 * Output: -1
 * Example 5:
 *
 * Input: arr = [7,7,7,7,7,7,7]
 * Output: 7
 *  
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 *
 */
public class FindLuckyIntegerinanArray {

    public static void main(String[] args) {
        FindLuckyIntegerinanArray findLuckyIntegerinanArray = new FindLuckyIntegerinanArray();
        int[] arr = new int[]{
                1, 2, 2, 3, 3, 3
        };
        System.out.println(findLuckyIntegerinanArray.findLucky(arr));
    }

    public int findLucky(int[] arr) {
        int res = -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            Integer integer = map.get(i);
            if (integer == null) {
                map.put(i, 1);
            } else {
                integer++;
                map.put(i, integer);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().intValue() == entry.getValue().intValue()) {
                if (res < entry.getKey()) {
                    res = entry.getKey();
                }
            }
        }

        return res;
    }

    public int findLucky1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        int res = -1;
        for(int key : map.keySet()){
            if(key == map.get(key))
                res = Math.max(res, key);
        }
        return res;
    }

}
