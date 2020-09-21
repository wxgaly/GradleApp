package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-15 14:41
 * @version V1.0
 * <p>
 * �ַ���������ת�����ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
 * �붨��һ������ʵ���ַ�������ת�����Ĺ��ܡ����磬�����ַ���"abcdefg"������2���ú�������������ת��λ�õ��Ľ��"cdefgab"��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ����: s = "abcdefg", k = 2
 * ���:?"cdefgab"
 * ʾ�� 2��
 * <p>
 * ����: s = "lrloseumgh", k = 6
 * ���:?"umghlrlose"
 * ?
 * <p>
 * ���ƣ�
 * <p>
 * 1 <= k < s.length <= 10000
 *
 * ��ָoffer����
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
        n = n % len;// ��len=3��n=4����ʵ�൱������ת1λ��������Ҫȡ��
        char[] charstr = str.toCharArray();
        //����תǰ���
        reverse(charstr, 0, n - 1);
        //����ת������ַ���
        reverse(charstr, n, len - 1);
        //������巴ת
        reverse(charstr, 0, len - 1);
        return String.valueOf(charstr);
    }

    //ʵ�ֵ���charstrs��i��j�ķ�ת��Ҳ����ʹ��������stringbuffer�ķ�ת��ʽ
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
