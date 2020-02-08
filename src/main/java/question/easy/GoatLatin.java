package question.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-08 14:31
 * @version V1.0
 *
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *  
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *  
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin. 
 *
 *  
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *  
 *
 * Notes:
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 *
 *
 */
public class GoatLatin {

    Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        GoatLatin goatLatin = new GoatLatin();
        System.out.println(goatLatin.toGoatLatin("I speak Goat Latin"));
        System.out.println(goatLatin.toGoatLatin1("The quick brown fox jumped over the lazy dog"));
    }

    public GoatLatin() {
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        map.put('A', 1);
        map.put('E', 1);
        map.put('I', 1);
        map.put('O', 1);
        map.put('U', 1);
    }

    public String toGoatLatin(String S) {

        String[] strings = S.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int len = strings.length;

        for (int i = 0; i < len; i++) {
            String temp = strings[i];

            char first = temp.charAt(0);
            //case 'a','e','i','o','u' or 'A','E','I','O','U'
            if (map.getOrDefault(first, -1) != -1) {
                stringBuilder.append(temp);
            } else {
                stringBuilder.append(temp.substring(1)).append(first);
            }

            //add ma
            stringBuilder.append("ma");

            //add a by (i + 1)
            for (int j = 0; j < i + 1; j++) {
                stringBuilder.append("a");
            }

            stringBuilder.append(" ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    public String toGoatLatin1(String S) {

        String[] strings = S.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        int t = 1;
        for (String string : strings) {
            char first = string.charAt(0);
            //case 'a','e','i','o','u' or 'A','E','I','O','U'
            if (map.getOrDefault(first, -1) != -1) {
                stringBuilder.append(string);
            } else {
                stringBuilder.append(string.substring(1)).append(first);
            }

            //add ma
            stringBuilder.append("ma");

            //add a by (i + 1)
            for (int i = 0; i < t; i++) {
                stringBuilder.append("a");
            }
            t++;

            stringBuilder.append(" ");
        }


        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

}
