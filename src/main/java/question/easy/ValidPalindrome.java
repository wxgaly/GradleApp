package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-08-23 17:31.
 * @version V1.0
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 *
 *
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        s = "aad";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        s = s.toLowerCase(); //统一转为小写
        int i = 0, j = len - 1;
        while (i < j) {
            //跳过非法字符
            while (!isAlphanumeric(s.charAt(i))) {
                i++;
                //匹配 "   " 这样的空白字符串防止越界
                if (i == len) {
                    return true;
                }
            }
            while (!isAlphanumeric(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isAlphanumeric(char c) {
        return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9';
    }

}
