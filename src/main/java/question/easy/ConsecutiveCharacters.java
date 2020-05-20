package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-20 13:36
 * @version V1.0
 *
 * Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
 *
 * Return the power of the string.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * Example 2:
 *
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * Example 3:
 *
 * Input: s = "triplepillooooow"
 * Output: 5
 * Example 4:
 *
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 * Example 5:
 *
 * Input: s = "tourist"
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s contains only lowercase English letters.
 *
 *
 */
public class ConsecutiveCharacters {

    public static void main(String[] args) {
        ConsecutiveCharacters consecutiveCharacters = new ConsecutiveCharacters();
        System.out.println(consecutiveCharacters.maxPower("leetcode"));
        System.out.println(consecutiveCharacters.maxPower("abbcccddddeeeeedcba"));
        System.out.println(consecutiveCharacters.maxPower("triplepillooooow"));
        System.out.println(consecutiveCharacters.maxPower("hooraaaaaaaaaaay"));
        System.out.println(consecutiveCharacters.maxPower("tourist"));
    }

    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        char temp = chars[0];
        int maxCount = 1;
        int sameCount = 1;

        for (int i = 1, len = chars.length; i < len; i++) {
            if (chars[i] == temp) {
                sameCount++;
            } else {
                sameCount = 1;
                temp = chars[i];
            }
            maxCount = Math.max(maxCount, sameCount);
        }

        return maxCount;
    }

}
