package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-11-18 17:23
 * @version V1.0
 *
 * You are given an array of strings?words?and a string?chars.
 *
 * A string is good?if?it can be formed by?characters from chars?(each character?can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 * ?
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 * ?
 *
 * Note:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length?<= 100
 * All strings contain lowercase English letters only.
 *
 *
 */
public class FindWordsThatBeFormedbyCharacters {

    public static void main(String[] args) {
        String word = "abcd";
        System.out.println(word.substring(0, 2));
    }

    public int countCharacters(String[] words, String chars) {
        int count = 0;

        for (String word : words) {
            char[] wordChars = word.toCharArray();
            String temp = new String(chars.getBytes());
            for (char wordChar : wordChars) {
                int len = temp.length();
                int index = 0;
                boolean isFind = false;
                for (; index < len; index++) {
                    if (temp.charAt(index) == wordChar) {
                        isFind = true;
                        if (index == 0) {
                            temp = temp.substring(index + 1);
                        } else if(index == len - 1) {
                            temp = temp.substring(0, index);
                        } else {
                            temp = temp.substring(0, index) + temp.substring(index, len);
                        }

                    }
                }
                //有一个char没有找到，直接找下一个单词
                if (!isFind) {
                    break;
                }
            }
        }

        return count;
    }

    /**
     * 1. 用字典记录所有字符出现次数
     * 2. 遍历words，
     * 3. 遍历word找到char与之匹配的char，然后次数减一，并且
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters1(String[] words, String chars) {
        char[] target = chars.toCharArray();
        int[] temp = new int[26];
        int result = 0;
        for (char c : target) {
            temp[c - 'a']++;
        }
        for (String word : words) {
            char[] src = word.toCharArray();
            int one = 0;
            int[] t = temp.clone();
            for (char c : src) {
                if(t[c - 'a']-- > 0){
                    one++;
                }
            }
            if (one == word.length()){
                result += one;
            }
        }
        return result;
    }

}
