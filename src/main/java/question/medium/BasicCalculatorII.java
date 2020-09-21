package question.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-16 14:43.
 * @version V1.0
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 * Note:
 * <p>
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculatorII {

    /**
     * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
     * <p>
     * 输入: 一个byte型的数字
     * <p>
     * 输出: 无
     * <p>
     * 返回: 对应的二进制数字中1的最大连续数
     *
     * @param byte1
     */
    void max1(byte byte1) {
        int k = 0;
        for (k = 0; byte1 != 0; k++) {
            byte1 = (byte) (byte1 & (byte1 << 1));
        }
        System.out.println(k);
    }

    /**
     * 请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，
     * 总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
     *
     * @param m
     * @param n
     * @return
     */
    int func(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        return func(m, n - 1) + func(m - 1, n);
    }

    /**
     * 在命令行输入如下命令：
     * <p>
     * xcopy /s c:\ d:\，
     * <p>
     * 各个参数如下：
     * <p>
     * 参数1：命令字xcopy
     * <p>
     * 参数2：字符串/s
     * <p>
     * 参数3：字符串c:\
     * <p>
     * 参数4: 字符串d:\
     * <p>
     * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
     * <p>
     * <p>
     * <p>
     * 解析规则：
     * <p>
     * 1.参数分隔符为空格
     * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s
     * “C:\program files” “d:\”时，参数仍然是4个，第3个参数应该是字符串C:\program files，
     * 而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
     * 3.参数不定长
     * 4.输入由用例保证，不会出现不符合要求的输入
     */
    void commands() {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        int len = 0;
        int quotaNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\"') {
                quotaNum++;
                continue;
            }
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else if (quotaNum % 2 == 0) {
                sb.append('\n');
                len++;
            } else {
                sb.append(' ');
            }
        }
        System.out.println(len + 1);
        System.out.println(sb.toString());

    }

    /**
     * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
     * <p>
     * * 统计出兔子总数。
     * * @param monthCount 第几个月
     * * @return 兔子总数
     * *
     * public static int getTotalCount(int monthCount)
     * {
     * return 0;
     * }
     *
     * @param monthCount
     * @return
     */
    public static int getTotalCount(int monthCount) {
        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i < monthCount; ++i) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    /**
     * 快排
     *
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr, int start, int end) {
        //当开始位置小于结束位置时（数组有数据）  进行排序  也就是递归入口
        if (start < end) {
            int base = arr[start];
            int low = start;
            int high = end;

            while (low < high) {
                while (low < high && base <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= base) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = base;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    /**
     * 二分查找
     *
     * @param a
     * @param key
     * @return
     */
    int bsearchWithoutRecursion(int a[], int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > key)
                high = mid - 1;
            else if (a[mid] < key)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。
     * 牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
     * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
     * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
     *
     * @throws IOException
     */
    private void compareCard() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] ss = str.split("-");
            if (ss[0].equals("joker JOKER") || ss[1].equals("joker JOKER")) {
                System.out.println("joker JOKER");
                continue;
            }

            String[] str0 = ss[0].split(" ");
            String[] str1 = ss[1].split(" ");

            str0 = findString(str0);
            str1 = findString(str1);

            int len1 = str0.length, len2 = str1.length;
            if (len1 == 4 || len2 == 4) {
                if (len1 == 4 && len2 == 4) {
                    int temp = Integer.parseInt(str0[0]) - Integer.parseInt(str1[0]);
                    if (temp >= 0) {
                        System.out.println(ss[0]);
                        continue;
                    } else {
                        System.out.println(ss[1]);
                        continue;
                    }
                } else if (len1 == 4) {
                    System.out.println(ss[0]);
                    continue;
                } else {
                    System.out.println(ss[1]);
                    continue;
                }
            }
            if (len1 != len2) {
                System.out.println("ERROR");
                continue;
            }
            int temp = Integer.parseInt(str0[0]) - Integer.parseInt(str1[0]);
            if (temp >= 0) {
                System.out.println(ss[0]);
            } else {
                System.out.println(ss[1]);
            }
        }
    }

    private static String[] findString(String[] str) {
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case "J":
                    str[i] = "11";
                    break;
                case "Q":
                    str[i] = "12";
                    break;
                case "K":
                    str[i] = "13";
                    break;
                case "A":
                    str[i] = "14";
                    break;
                case "2":
                    str[i] = "15";
                    break;
            }
        }

        return str;
    }

    /**
     * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）
     * 是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
     * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
     * <p>
     * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
     *
     * @throws IOException
     */
    private void gcCount() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string1 = "";
        while ((string1 = bufferedReader.readLine()) != null) {
            int count = Integer.parseInt(bufferedReader.readLine());
            int sum = 0;
            String s = "";
            for (int i = 0; i <= string1.length() - count; i++) {
                int tmp = 0;
                for (int j = i; j < i + count; j++) {
                    if (string1.charAt(j) == 'G' || string1.charAt(j) == 'C') {
                        tmp++;
                    }
                }
                if (tmp > sum) {
                    sum = tmp;
                    s = string1.substring(i, i + count);
                }
            }
            System.out.println(s);

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);

        }

//        String s = "3+2*2";
//        System.out.println(calculate1(s));
//
//        s = " 3/2 ";
//        System.out.println(calculate1(s));
//
//        s = " 3+5 / 2 ";
//        System.out.println(calculate1(s));
//
//
//        System.out.println(calculate1(s));
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
