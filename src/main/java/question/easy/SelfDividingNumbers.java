package question.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-09-27 14:38
 * @version V1.0
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound, output a list of every possible self dividing number,
 * including the bounds if possible.
 *
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 *
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 *
 *
 */
public class SelfDividingNumbers {

    public static void main(String[] args) {
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        ArrayList<Integer> list = (ArrayList<Integer>) selfDividingNumbers.selfDividingNumbers1(1, 22);
        System.out.println(list.toString());
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            String s = Integer.toString(i);
            boolean isSelf = false;
            if (!s.contains("0")) {
                int length = s.length();
                for (int j = 0; j < length; j++) {
                    String str = s.substring(j, j + 1);
                    Integer integer = Integer.valueOf(str);
                    if (i % integer != 0) {
                        isSelf = false;
                        break;
                    }
                    isSelf = true;
                }
            }

            if (isSelf) {
                ans.add(i);
            }
        }

        return ans;
    }

    public List<Integer> selfDividingNumbers1(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isDividingNumber(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    /**
     * 每次模10，取个位数，然后每次除10，减少位数
     * @param num
     * @return
     */
    private boolean isDividingNumber(int num) {
        int temp = 0;
        int n = num;
        while (num > 0) {
            temp = num % 10;
            if (temp == 0 || n % temp != 0) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }


}
