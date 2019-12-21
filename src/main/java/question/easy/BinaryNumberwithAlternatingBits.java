package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-12-21 16:01
 * @version V1.0
 * <p>
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
 * <p>
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * Example 2:
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * Example 3:
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * Example 4:
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 */
public class BinaryNumberwithAlternatingBits {

    public static void main(String[] args) {
        BinaryNumberwithAlternatingBits binaryNumberwithAlternatingBits = new BinaryNumberwithAlternatingBits();
        System.out.println(binaryNumberwithAlternatingBits.hasAlternatingBits2(5));
    }

    /**
     * 3ms
     *
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len < 2) {
            return true;
        }
        char temp = chars[0];
        for (int i = 1; i < len; i++) {
            if (temp == chars[i]) {
                return false;
            } else {
                temp = chars[i];
            }
        }
        return true;
    }

    /**
     * 1ms
     *
     * @param n
     * @return
     */
    public boolean hasAlternatingBits1(int n) {
        if (n > 1) {
            int temp = n & 0x01;
            int last = n >> 1;
            String s = Integer.toBinaryString(n);
            System.out.println(s);
            int len = s.length();
            for (int i = 1; i < len; i++) {
                int x = last & 0x01;
                if (temp == x) {
                    return false;
                } else {
                    last = last >> 1;
                    temp = x;
                }
            }
        }
        return true;
    }

    /**
     * 1ms
     *
     * @param n
     * @return
     */
    public boolean hasAlternatingBits2(int n) {
        int tmp = n ^ (n >> 1);
        return (tmp & (tmp + 1)) == 0;
    }

}
