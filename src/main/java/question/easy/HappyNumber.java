package question.easy;

import java.util.LinkedList;

/**
 * question.easy.HappyNumber
 *
 * @author Created by WXG on 2019-4-17 13:49.
 * @version V1.0
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

public class HappyNumber {

    public static void main(String[] args) {

        System.out.println(isHappy(11));
    }

    /**
     * 思路应该是不能递归，因为可能会出现无限循环，所以应该用一个map将每次计算的值保存起来
     * 然后每次计算完成在map中查找是否已经出现重复的值，如果出现则说明循环，返回false。
     */
    public static boolean isHappy(int n) {
        boolean ret = false;
        try {
            if (n <= 0) {
                return ret;
            }

            if (n == 1) {
                return true;
            }

            String number = Integer.toString(n);

            int sum = 0;
            int len = number.length();
            for (int i = 0; i < len; i++) {
                int temp;
                if (i == len - 1) {
                    temp = n % 10;
                } else {
                    temp = Integer.valueOf(number.substring(i, i + 1));
                }
                sum += temp * temp;
            }

            if (sum == 1) {
                ret = true;
            } else {
                return isHappy(sum);
            }
            return ret;
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public boolean isHappy1(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        while (true) {
            if (change(n) == 1) {
                return true;
            } else {
                if (list.contains(n)) {
                    return false;
                }
                list.add(n);
                n = change(n);
            }
        }
    }

    public int change(int n) {
        int value = 0;
        while (n > 0) {
            value += Math.pow(n % 10, 2);
            n /= 10;
        }
        return value;
    }
}
