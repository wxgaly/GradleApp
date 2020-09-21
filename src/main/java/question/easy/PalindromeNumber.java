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
     * ���ʣ��������ұ�С��ʱ�򣬾��ߵ���һ�룬
     * ʱ�临�Ӷȣ�O(\log_{10}(n))O(log10(n))������ÿ�ε��������ǻὫ�������10�����ʱ�临�Ӷ�Ϊ O(\log_{10}(n))O(log10(n))��
     * �ռ临�Ӷȣ�O(1)O(1)��
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
