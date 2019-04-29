package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-04-29 20:27.
 * @version V1.0
 * <p>
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(15));
    }

    public static int nthUglyNumber(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int count = 1;
        int num = 1;

        for (int i = 1; i <= 1690; i++) {
            if (((i % 2) == 0) || ((i % 3) == 0) || ((i % 5) == 0)) {
                boolean isFind = false;
                for (int j = i + 1; j < 1690; j++) {
                    if (i <= j) {
                        break;
                    }
                    if ((i % j) == 0) {
                        isFind = true;
                    }
                }

                if (!isFind) {
                    count++;
                }
            }

            if (count == n) {
                num = i;
                break;
            }
        }

        return num;
    }

    /**
     * 三指针法
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber1(int n) {
        int[] num = new int[n];
        int two_index = 0;
        int three_index = 0;
        int five_index = 0;
        int min = 0;
        num[0] = 1;
        for (int i = 1; i < n; i++) {
            min = Math.min(Math.min(num[two_index] * 2, num[three_index] * 3), num[five_index] * 5);
            if (min == num[two_index] * 2) {
                two_index++;
            }
            if (min == num[three_index] * 3) {
                three_index++;
            }
            if (min == num[five_index] * 5) {
                five_index++;
            }
            num[i] = min;
        }
        return num[n - 1];
    }

}
