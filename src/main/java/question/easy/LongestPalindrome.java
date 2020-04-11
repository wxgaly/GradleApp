package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-11 21:24
 * @version V1.0
 *
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 *
 */
public class LongestPalindrome {

    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        // 找出可以构成最长回文串的长度
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }

}
