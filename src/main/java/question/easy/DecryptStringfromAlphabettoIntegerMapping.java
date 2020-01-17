package question.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-01-17 13:56
 * @version V1.0
 *
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
 * Return the string formed after mapping.
 *
 * It's guaranteed that a unique mapping will always exist.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * Example 2:
 *
 * Input: s = "1326#"
 * Output: "acz"
 * Example 3:
 *
 * Input: s = "25#"
 * Output: "y"
 * Example 4:
 *
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] only contains digits letters ('0'-'9') and '#' letter.
 * s will be valid string such that mapping is always possible.
 *
 *
 */
public class DecryptStringfromAlphabettoIntegerMapping {

    public static void main(String[] args) {
        String a = "1326#";
        DecryptStringfromAlphabettoIntegerMapping decryptStringfromAlphabettoIntegerMapping = new DecryptStringfromAlphabettoIntegerMapping();
        System.out.println(decryptStringfromAlphabettoIntegerMapping.freqAlphabets("123456789"));
        System.out.println(decryptStringfromAlphabettoIntegerMapping.freqAlphabets("10#11#12"));
        System.out.println(decryptStringfromAlphabettoIntegerMapping.freqAlphabets("1326#"));
        System.out.println(decryptStringfromAlphabettoIntegerMapping.freqAlphabets("25#"));
        System.out.println(decryptStringfromAlphabettoIntegerMapping.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }

    public String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, Character> map = new HashMap<>();

        int count = 1;
        for (int i = 'a'; i <= 'i'; i++) {
            map.put(count + "", (char) i);
            count++;
        }

        for (int i = 'j'; i <= 'z'; i++) {
            map.put(count + "#", (char) i);
            count++;
        }

        if (s.contains("#")) {
            String[] split = s.split("#");
            int sLen = s.length();
            int length1 = split.length;
            for (int i = 0; i < length1; i++) {
                String s1 = split[i];
                int length = s1.length();
                if (i == length1 - 1 && s.charAt(sLen - 1) != '#') {
                    char[] chars = s1.toCharArray();
                    for (char aChar : chars) {
                        stringBuilder.append(map.get(String.valueOf(aChar)));
                    }
                } else {
                    if (length > 2) {
                        char[] chars = s1.toCharArray();
                        for (int j = 0; j < length - 2; j++) {
                            stringBuilder.append(map.get(String.valueOf(chars[j])));
                        }
                        stringBuilder.append(map.get(s1.substring(length - 2) + "#"));
                    } else {
                        stringBuilder.append(map.get(s1 + "#"));
                    }
                }
            }

        } else {
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                stringBuilder.append(map.get(String.valueOf(aChar)));
            }
        }

        return stringBuilder.toString();
    }

    public String freqAlphabets1(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = s.length();
        while (i < len) {
            if (i < len - 2 && s.charAt(i + 2) == '#') {
                sb.append((char) ('a' + Integer.parseInt(s.substring(i, i + 2)) - 1));
                i += 3;
            } else {
                sb.append((char) ('a' + Integer.parseInt(s.substring(i, i + 1)) - 1));
                i++;
            }
        }
        return sb.toString();
    }


}
