package question;

import java.util.Stack;

/**
 * question.ExcelSheetColumnTitle
 *
 * @author Created by WXG on 2019/3/6 006 17:29.
 * @version V1.0
 */

public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(convertToTitle(i));
        }
    }

    public static String convertToTitle(int n) {

        int scale = 26;

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = convertToStack(n, scale);
        while (!stack.isEmpty()) {
            char c = (char) ('A' + stack.pop() - 1);
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public static Stack<Integer> convertToStack(int n, int scale) {

        Stack<Integer> stack = new Stack<>();

        while (n != 0) {
            int mod = n % scale;
            n /= scale;
            if (mod == 0) {
                mod = scale;
                n -= 1;
            }
            stack.push(mod);
        }

        return stack;
    }

}
