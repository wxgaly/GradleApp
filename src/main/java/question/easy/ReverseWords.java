package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-17 17:21
 * @version V1.0
 *
 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣Ϊ������������ź���ͨ��ĸһ������
 * ���������ַ���"I am a student. "�������"student. a am I"��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ����: "the sky is blue"
 * ���:?"blue is sky the"
 * ʾ�� 2��
 *
 * ����: " ?hello world! ?"
 * ���:?"world! hello"
 * ����: �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ʾ�� 3��
 *
 * ����: "a good ? example"
 * ���:?"example good a"
 * ����: ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 * ?
 *
 * ˵����
 *
 * �޿ո��ַ�����һ�����ʡ�
 * �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
 * ����������ʼ��ж���Ŀո񣬽���ת�󵥴ʼ�Ŀո���ٵ�ֻ��һ����
 *
 *
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords("the sky is blue"));
        System.out.println(reverseWords.reverseWords("  hello world!  "));
    }

    public String reverseWords(String s) {

        String[] strings = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        int len = strings.length;
        for (int i = len - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]);
            if (i != 0) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

    public String reverseWords1(String s) {
        s = s.trim(); // ɾ����β�ո�
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--; // �����׸��ո�
            res.append(s.substring(i + 1, j + 1) + " "); // ��ӵ���
            while (i >= 0 && s.charAt(i) == ' ') i--; // �������ʼ�ո�
            j = i; // j ָ���¸����ʵ�β�ַ�
        }
        return res.toString().trim(); // ת��Ϊ�ַ���������
    }


}
