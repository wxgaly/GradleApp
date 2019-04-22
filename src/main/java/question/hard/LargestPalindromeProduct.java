package question.hard;

/**
 * question.hard.LargestPalindromeProduct
 *
 * @author Created by WXG on 2019-4-22 14:03.
 * @version V1.0
 */

public class LargestPalindromeProduct {

    public static void main(String[] args) {

        System.out.println(largestPalindrome1(3));

    }

    /**
     * 打表法
     *
     * @param n
     * @return
     */
    public static int largestPalindrome1(int n) {
        if (n > 8 || n < 1)
            return 0;
        int arr[] = {9, 987, 123, 597, 677, 1218, 877, 475};
        return arr[n - 1];
    }

    public static int largestPalindrome(int n) {

        int result = 0;

        int max = 1;
        int min = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }

        min = max / 10;
        max = max - 1;

        for (int i = max; i >= min; i--) {
            for (int j = max; j >= min; j--) {
                long multiply = i * j;
                if (isPalindromic(multiply)) {
                    return (int) (multiply % 1337);
                }
            }
        }

        return result;

    }

    private static boolean isPalindromic(long num) {
        String s = String.valueOf(num);
        char[] nums = s.toCharArray();
        int length = nums.length;
        for (int i = 0; i < length / 2; i++) {
            if (nums[i] != nums[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
