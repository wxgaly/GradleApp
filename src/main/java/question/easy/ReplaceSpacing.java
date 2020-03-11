package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-11 14:57
 * @version V1.0
 */
public class ReplaceSpacing {

    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

}
