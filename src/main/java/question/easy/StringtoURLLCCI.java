package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-21 14:12
 * @version V1.0
 *
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 *
 * Example 1:
 *
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 * Explanation:
 * The missing numbers are [5,6,8,...], hence the third missing number is 8.
 * Example 2:
 *
 * Input: "               ", 5
 * Output: "%20%20%20%20%20"
 *  
 *
 * Note:
 *
 * 0 <= S.length <= 500000
 *
 *
 */
public class StringtoURLLCCI {

    public static void main(String[] args) {

    }

    public String replaceSpaces(String S, int length) {
        S = S.substring(0, length).replaceAll(" ", "%20");
        int left = 0;
        int right = length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (left < right) {
            if (S.charAt(left) == ' ') {
                stringBuilder.append("%20");
            }
            if (S.charAt(right) == ' ') {
                stringBuilder.append("%20");
            }
            stringBuilder.append("%20");
        }
        return stringBuilder.toString();
    }


    public String replaceSpaces1(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++){
            if(S.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

}
