package question.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-09 13:52
 * @version V1.0
 *
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
 * and all letters reverse their positions.
 *
 *  
 *
 * Example 1:
 *
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 *
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *  
 *
 * Note:
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 *
 *
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }

        char[] chars = S.toCharArray();

        List<Character> characterList = new ArrayList<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            if ((aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z')) {
                characterList.add(aChar);
            }
        }
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ((aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z')) {
                chars[i] = characterList.get(index);
                index++;
            }
        }

        return new String(chars);
    }

    /**
     * 左右指针
     *
     * @param S
     * @return
     */
    public String reverseOnlyLetters1(String S) {
        char[] arr = S.toCharArray();
        int len = arr.length, l = -1, r = len;
        if (len < 2) return S;
        while (l++ < r--) {
            while (l < r && !valid(arr[l])) l++;
            while (l < r && !valid(arr[r])) r--;
            if (l < r) {
                arr[l] ^= arr[r];
                arr[r] ^= arr[l];
                arr[l] ^= arr[r];
            }
        }
        return new String(arr);
    }

    private boolean valid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

}
