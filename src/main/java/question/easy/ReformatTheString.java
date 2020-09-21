package question.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-14 14:10
 * @version V1.0
 *
 * Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 *
 * You have to find a permutation of?the string where no letter is followed by another letter and no digit is followed by another digit.
 * That is, no two adjacent characters have the same type.
 *
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 *
 * ?
 *
 * Example 1:
 *
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 * Example 2:
 *
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 * Example 3:
 *
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by characters.
 * Example 4:
 *
 * Input: s = "covid2019"
 * Output: "c2o0v1i9d"
 * Example 5:
 *
 * Input: s = "ab123"
 * Output: "1a2b3"
 * ?
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters and/or digits.
 *
 *
 */
public class ReformatTheString {

    public static void main(String[] args) {
        ReformatTheString reformatTheString = new ReformatTheString();
        System.out.println(reformatTheString.reformat("avn1235"));
    }

    public String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> nums = new ArrayList<>();

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                nums.add(aChar);
            } else {
                letters.add(aChar);
            }
        }

        if (Math.abs(letters.size() - nums.size()) >= 2) {
            return "";
        }

        int num = 0, letter = 1;
        if (letters.size() > nums.size()) {
            num = 1;
            letter = 0;
        }

        for (int i1 = 0; i1 < letters.size(); i1++, letter += 2) {
            chars[letter] = letters.get(i1);
        }
        for (int i1 = 0; i1 < nums.size(); i1++, num += 2) {
            chars[num] = nums.get(i1);
        }


        return new String(chars);
    }

    public String reformat1(String s) {
        int num1 = 0, num2 = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                num1++;
            } else {
                num2++;
            }
        }//看数字字符比较多还是字母字符比较多
        if (num1 - num2 < -1 || num1 - num2 > 1) {
            return "";
        }
        if (num1 > num2) {
            num1 = 0;
            num2 = 1;
        } else {
            num1 = 1;
            num2 = 0;
        }
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                chars[num1] = c;
                num1 += 2;
            } else {
                chars[num2] = c;
                num2 += 2;
            }
        }
        return new String(chars);
    }


}
