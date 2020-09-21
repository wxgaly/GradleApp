package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-19 15:07
 * @version V1.0
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));
        System.out.println(palindromeNumber.isPalindrome1(1221));
    }

    /**
     * 左边剩余的数比右边小的时候，就走到了一半，
     * 时间复杂度：O(\log_{10}(n))O(log10(n))，对于每次迭代，我们会将输入除以10，因此时间复杂度为 O(\log_{10}(n))O(log10(n))。
     * 空间复杂度：O(1)O(1)。
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int a = 0;
        while (x > a) {
            a = a * 10 + x % 10;
            x = x / 10;
        }
        return x == a || x == a / 10;
    }

    public boolean isPalindrome1(int x) {
        String s = Integer.toString(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}
