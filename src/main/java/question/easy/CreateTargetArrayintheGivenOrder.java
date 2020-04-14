package question.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-14 14:20
 * @version V1.0
 * <p>
 * <p>
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 * <p>
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 * <p>
 * It is guaranteed that the insertion operations will be valid.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * Output: [0,1,2,3,4]
 * Explanation:
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 * Example 3:
 * <p>
 * Input: nums = [1], index = [0]
 * Output: [1]
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length, index.length <= 100
 * nums.length == index.length
 * 0 <= nums[i] <= 100
 * 0 <= index[i] <= i
 */
public class CreateTargetArrayintheGivenOrder {

    public static void main(String[] args) {

    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(index[i], nums[i]);
        }
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = res.get(i);
        }
        return target;

    }

}
