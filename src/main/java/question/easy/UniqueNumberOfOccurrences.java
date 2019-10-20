package question.easy;

import java.util.*;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-20 15:40
 * @version V1.0
 *
 * Given an array of integers arr, write a function that returns true if
 * and only if the number of occurrences of each value in the array is unique.
 *
 *  
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 *  
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 *
 */
public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        UniqueNumberOfOccurrences uniqueNumberOfOccurrences = new UniqueNumberOfOccurrences();
        int[] arr = new int[]{
                1, 2, 2
        };
        System.out.println(uniqueNumberOfOccurrences.uniqueOccurrences(arr));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> arrMap = new HashMap<>();

        for (int i : arr) {
            Integer value = arrMap.getOrDefault(i, -1);
            if (value != -1) {
                arrMap.put(i, ++value);
            } else {
                arrMap.put(i, 1);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : arrMap.entrySet()) {
            if (!set.add(entry.getValue())) {
                return false;
            }
        }


        return set.size() == arrMap.size();
    }

}
