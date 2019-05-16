package question.medium;

import java.util.Stack;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-16 14:43.
 * @version V1.0
 *
 *Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * Example 1:
 *
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 *
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 *
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 *
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 *
 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate1(s));

        s = " 3/2 ";
        System.out.println(calculate1(s));

        s = " 3+5 / 2 ";
        System.out.println(calculate1(s));


        System.out.println(calculate1(s));
    }

    public static int calculate(String s) {


        if (s == null || s.length() == 0) {
            return Integer.MAX_VALUE;
        }

        int ret = 0;

        s = s.trim();

        int length = s.length();
        Stack<String> stringStack = new Stack<>();

        for (int i = 0; i < length; i++) {
            String substring = s.substring(i, i + 1);
            if (!substring.equals(" ")) {

                try {
                    int parseInt = Integer.parseInt(substring);
                } catch (NumberFormatException e) {
                    if (substring.equals("*") || substring.equals("/")) {

                    }
                }

            }
        }


        return ret;
    }


    /**
     * 一般需要符号栈、数据栈，两个。但是，看到网上一个写的不错的算法，只用了一个数据栈。
     * 符号栈用一个变量sign代替了，只存储上一个符号，主要思想如下：
     * <p>
     * 将减法转化为加法（取相反数）
     * <p>
     * 由于乘除法优先级高，直接计算
     * <p>
     * 整数不仅一位，会>10
     * <p>
     * 表达式中没有括号
     * <p>
     * 注意：
     * <p>
     * 加减乘除空格的ASCII码都小于'0'，ASCII对照表如下：http://tool.oschina.net/commons?type=4
     * <p>
     * 先做减法，避免int溢出
     * <p>
     * char类型，不能使用switch
     *
     * @param s
     * @return
     */
    public static int calculate1(String s) {
        int res = 0, d = 0;
        char sign = '+';
        Stack<Integer> nums = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            if (chars[i] >= '0') {//加减乘除和空格ASCII码都小于'0'
                d = d * 10 - '0' + chars[i];//进位(先减法)
            }
            if ((chars[i] < '0' && chars[i] != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    nums.push(d);
                } else if (sign == '-') {
                    nums.push(-d);
                } else if (sign == '*' || sign == '/') {
                    int tmp = sign == '*' ? nums.peek() * d : nums.peek() / d;
                    nums.pop();
                    nums.push(tmp);
                }
                sign = chars[i]; //保存当前符号
                d = 0;
            }
        }
        for (; !nums.empty(); nums.pop()) {
            res += nums.peek();
        }
        return res;
    }

}
