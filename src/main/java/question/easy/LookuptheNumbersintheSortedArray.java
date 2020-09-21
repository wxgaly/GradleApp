package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-27 13:44
 * @version V1.0
 *
 * ͳ��һ�����������������г��ֵĴ�����
 *
 * ?
 *
 * ʾ�� 1:
 *
 * ����: nums = [5,7,7,8,8,10], target = 8
 * ���: 2
 * ʾ��?2:
 *
 * ����: nums = [5,7,7,8,8,10], target = 6
 * ���: 0
 * ?
 *
 * ���ƣ�
 *
 * 0 <= ���鳤�� <= 50000
 *
 */
public class LookuptheNumbersintheSortedArray {

    public static void main(String[] args) {
        LookuptheNumbersintheSortedArray sortedArray = new LookuptheNumbersintheSortedArray();
        int[] nums = new int[]{
                5, 7, 7, 8, 8, 10
        };
        System.out.println(sortedArray.search(nums, 6));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;

        int left = 0;
        int right = nums.length - 1;

        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                count++;
                break;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        int i = mid + 1;
        while (i <= right) {
            if (nums[i] == target) {
                count++;
                i++;
            } else {
                break;
            }
        }

        i = mid - 1;
        while (left <= i) {
            if (nums[i] == target) {
                count++;
                i--;
            } else {
                break;
            }
        }

        return count;
    }

    public int search1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }


}
