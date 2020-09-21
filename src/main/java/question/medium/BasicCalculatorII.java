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
     * ����: ��һ��byte���ֶ�Ӧ�Ķ�����������1�����������������3�Ķ�����Ϊ00000011���������2��1
     * <p>
     * ����: һ��byte�͵�����
     * <p>
     * ���: ��
     * <p>
     * ����: ��Ӧ�Ķ�����������1�����������
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
     * ���дһ�����������������Ӻ�����������n x m�����̸��ӣ�nΪ����ĸ�������mΪ����ĸ����������Ÿ��Ա�Ե�ߴ����Ͻ��ߵ����½ǣ�
     * �ܹ��ж������߷���Ҫ�����߻�ͷ·������ֻ�����Һ������ߣ���������������ߡ�
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
     * �������������������
     * <p>
     * xcopy /s c:\ d:\��
     * <p>
     * �����������£�
     * <p>
     * ����1��������xcopy
     * <p>
     * ����2���ַ���/s
     * <p>
     * ����3���ַ���c:\
     * <p>
     * ����4: �ַ���d:\
     * <p>
     * ���дһ��������������ʵ�ֽ������и�����������������
     * <p>
     * <p>
     * <p>
     * ��������
     * <p>
     * 1.�����ָ���Ϊ�ո�
     * 2.�����á������������Ĳ���������м��пո񣬲��ܽ���Ϊ�������������������������xcopy /s
     * ��C:\program files�� ��d:\��ʱ��������Ȼ��4������3������Ӧ�����ַ���C:\program files��
     * ������C:\program��ע���������ʱ����Ҫ������ȥ�������Ų�����Ƕ�������
     * 3.����������
     * 4.������������֤��������ֲ�����Ҫ�������
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
     * ��һֻ���ӣ��ӳ������3������ÿ���¶���һֻ���ӣ�С���ӳ����������º�ÿ��������һֻ���ӣ��������Ӷ���������ÿ���µ���������Ϊ���٣�
     * <p>
     * * ͳ�Ƴ�����������
     * * @param monthCount �ڼ�����
     * * @return ��������
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
     * ����
     *
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr, int start, int end) {
        //����ʼλ��С�ڽ���λ��ʱ�����������ݣ�  ��������  Ҳ���ǵݹ����
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
     * ���ֲ���
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
     * �˿�����Ϸ���Ӧ�ö��Ƚ���Ϥ�ˣ�һ������54����ɣ���3~A��2��4�ţ�С��1�ţ�����1�š�
     * �����С�����������ַ����ַ�����ʾ�����У�Сдjoker��ʾС������дJOKER��ʾ��������
     * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     * ���������ƣ�������֮����"-"���ӣ�ÿ���Ƶ�ÿ�����Կո�ָ���"-"����û�пո��磺4 4 4 4-joker JOKER��
     * ��Ƚ������ƴ�С������ϴ���ƣ���������ڱȽϹ�ϵ�����ERROR��
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
     * һ��DNA������A/C/G/T�ĸ���ĸ�����������ɡ�G��C�ı���������ΪGC-Ratio��
     * ��������G��C������ĸ���ܵĳ��ִ��������ܵ���ĸ��Ŀ��Ҳ�������г��ȣ���
     * �ڻ��򹤳��У���������ǳ���Ҫ����Ϊ�ߵ�GC-Ratio�����ǻ������ʼ�㡣
     * <p>
     * ����һ���ܳ���DNA���У��Լ�Ҫ�����С�����г��ȣ��о���Ա��������Ҫ�������ҳ�GC-Ratio��ߵ������С�
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
     * һ����Ҫ����ջ������ջ�����������ǣ���������һ��д�Ĳ�����㷨��ֻ����һ������ջ��
     * ����ջ��һ������sign�����ˣ�ֻ�洢��һ�����ţ���Ҫ˼�����£�
     * <p>
     * ������ת��Ϊ�ӷ���ȡ�෴����
     * <p>
     * ���ڳ˳������ȼ��ߣ�ֱ�Ӽ���
     * <p>
     * ��������һλ����>10
     * <p>
     * ���ʽ��û������
     * <p>
     * ע�⣺
     * <p>
     * �Ӽ��˳��ո��ASCII�붼С��'0'��ASCII���ձ����£�http://tool.oschina.net/commons?type=4
     * <p>
     * ��������������int���
     * <p>
     * char���ͣ�����ʹ��switch
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
            if (chars[i] >= '0') {//�Ӽ��˳��Ϳո�ASCII�붼С��'0'
                d = d * 10 - '0' + chars[i];//��λ(�ȼ���)
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
                sign = chars[i]; //���浱ǰ����
                d = 0;
            }
        }
        for (; !nums.empty(); nums.pop()) {
            res += nums.peek();
        }
        return res;
    }

}
