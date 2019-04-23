package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-04-23 16:38.
 * @version V1.0
 * <p>
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.  Each character in S is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("", "ddddccffgd"));
    }

    public static int numJewelsInStones(String J, String S) {

        int number = 0;

        if (J == null || J.length() == 0) {
            return number;
        }

        if (S == null || S.length() == 0) {
            return number;
        }


        char[] charS = S.toCharArray();
        char[] charT = J.toCharArray();
        for (char s : charS) {
            for (char t : charT) {
                if (s == t) {
                    number++;
                }
            }
        }

        return number;
    }

    public static String removerepeatedchar(String s) {
        if (s == null)
            return s;
        StringBuilder sb = new StringBuilder();
        int i = 0, len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            sb.append(c);
            i++;
            while (i < len && s.charAt(i) == c) {
                i++;
            }
        }
        return sb.toString();
    }

}
