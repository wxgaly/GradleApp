package question.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-24 14:26
 * @version V1.0
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 *
 *
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber1("ZY"));
        System.out.println('A' + 1);
    }

    public int titleToNumber(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i), i + 1);
        }

        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += map.get(chars[chars.length - i - 1]) * Math.pow(26, i);
        }

        return result;
    }

    /**
     * ��ʹ��mapӳ�䣬��Ϊ�ַ�����������
     *
     * @param s
     * @return
     */
    public int titleToNumber1(String s) {

        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += (chars[chars.length - i - 1] - 64) * Math.pow(26, i);
        }

        return result;
    }

    /**
     * ��ʹ��ƽ����ÿ�ν��������26���ټ�����ĸ����������ĵ�ֵ
     *
     * @param s
     * @return
     */
    public int titleToNumber2(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;

    }

}
