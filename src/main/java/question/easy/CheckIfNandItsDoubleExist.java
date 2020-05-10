package question.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-10 21:18
 * @version V1.0
 *
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 *
 * More formally check if there exists two indices i and j such that :
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *  
 *
 * Example 1:
 *
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 * Example 2:
 *
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 * Example 3:
 *
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 *  
 *
 * Constraints:
 *
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 *
 *
 */
public class CheckIfNandItsDoubleExist {

    public static void main(String[] args) {
        CheckIfNandItsDoubleExist checkIfNandItsDoubleExist = new CheckIfNandItsDoubleExist();
        int[] arr = new int[]{
                10, 2, 5, 3
        };
        arr = new int[]{
                7, 1, 14, 11
        };
        arr = new int[]{
                3, 1, 7, 11
        };
        System.out.println(checkIfNandItsDoubleExist.checkIfExist(arr));
    }

    public boolean checkIfExist(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int x = arr[i];
                int y = arr[j];
                if (x == y * 2 || x == y - x) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkIfExist1(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
