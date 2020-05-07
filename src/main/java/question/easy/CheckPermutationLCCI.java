package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-07 14:04
 * @version V1.0
 *
 * Given two strings,write a method to decide if one is a permutation of the other.
 *
 * Example 1:
 *
 * Input: s1 = "abc", s2 = "bca"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "abc", s2 = "bad"
 * Output: false
 * Note:
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 *
 */
public class CheckPermutationLCCI {

    public static void main(String[] args) {

    }

    /**
     * 第一时间想到HASH，用hashset消值
     * 后来发现都是ascii码，就直接排序，重新对比字符串是否相等即可
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return new String(chars1).equals(new String(chars2));
    }

}
