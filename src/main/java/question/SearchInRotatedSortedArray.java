package question;

/**
 * question.SearchInRotatedSortedArray
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * @author Created by WXG on 2019/2/27 027 15:18.
 * @version V1.0
 */

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        //test1
//        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int[] nums = new int[]{1, 3};
        int target = 3;
        System.out.println("测试用例1： " + search(nums, target));

        //test2
//        target = 0;
//        System.out.println("测试用例2： " + search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int result = -1;

        if (nums == null || nums.length <= 0) {
            return result;
        }

        int length = nums.length;
        int mid = length / 2;
        int front = mid - 1;
        int back = mid + 1;

        //1.猜测中间节点与目标值相等
        if (target == nums[mid]) {
            return mid;
        } else {
            if (length == 2) {
                if (target == nums[0]) {
                    return 0;
                } else {
                    return result;
                }
            } else {
                //此处不是最优，应该用递归，每次二分
                for (int i = 0; i < mid; i++) {
                    if (target == nums[front]) {
                        return front;
                    }

                    if (back < length) {
                        if (target == nums[back]) {
                            return back;
                        }
                    }

                    front--;
                    back++;
                }
            }
        }

        return result;
    }

}
