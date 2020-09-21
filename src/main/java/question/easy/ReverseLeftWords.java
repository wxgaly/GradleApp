package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-15 14:41
 * @version V1.0
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * ?
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出:?"cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出:?"umghlrlose"
 * ?
 * <p>
 * 限制：
 * <p>
 * 1 <= k < s.length <= 10000
 *
 * 剑指offer试题
 *
 */
public class ReverseLeftWords {

    public static void main(String[] args) {

    }

    public String reverseLeftWords(String str, int n) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        int len = str.length();
        n = n % len;// 当len=3，n=4，其实相当于左旋转1位，所以需要取余
        char[] charstr = str.toCharArray();
        //先旋转前面的
        reverse(charstr, 0, n - 1);
        //再旋转后面的字符串
        reverse(charstr, n, len - 1);
        //最后整体反转
        reverse(charstr, 0, len - 1);
        return String.valueOf(charstr);
    }

    //实现的是charstrs从i到j的反转，也可以使用上题中stringbuffer的反转方式
    private void reverse(char[] charStrs, int i, int j) {
        while (i < j) {
            char temp = charStrs[i];
            charStrs[i] = charStrs[j];
            charStrs[j] = temp;
            i++;
            j--;
        }
    }

}
