package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-12-10 16:33
 * @version V1.0
 *
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 *  
 *
 * Example 1:
 *
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 *  
 *
 * Constraints:
 *
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 *
 *
 */
public class MaximumNumberofBalloons {

    public static void main(String[] args) {
        MaximumNumberofBalloons maximumNumberofBalloons = new MaximumNumberofBalloons();
        System.out.println(maximumNumberofBalloons.maxNumberOfBalloons("nlaebolko"));
        System.out.println(maximumNumberofBalloons.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maximumNumberofBalloons.maxNumberOfBalloons("leetcode"));
    }

    public int maxNumberOfBalloons(String text) {

        char[] balloon = new char[]{
                'b', 'a', 'l', 'o', 'n'
        };

        int len = balloon.length;
        int[] records = new int[len];
        for (int i = 0; i < records.length; i++) {
            records[i] = 0;
        }

        char[] chars = text.toCharArray();
        for (char aChar : chars) {
            int index = -1;
            for (int i = 0; i < len; i++) {
                if (balloon[i] == aChar) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                records[index]++;
            }
        }

        int min = Math.min(records[4], Math.min(records[0], records[1]));
        int count = min * 2;
        if (count == 0) {
            return 0;
        }
        if (count <= records[2] && count <= records[3]) {
            return records[0];
        }

        return 0;
    }

    public int maxNumberOfBalloons1(String text) {
        int[] letters = new int[26];
        for (char ch : text.toCharArray()) {
            letters[ch - 97]++;
        }
        letters['l' - 97] /= 2;
        letters['o' - 97] /= 2;
        int min = Integer.MAX_VALUE;
        for (char ch : "balon".toCharArray()) {
            if (letters[ch - 97] < min) {
                min = letters[ch - 97];
            }
        }
        return min;
    }

}
