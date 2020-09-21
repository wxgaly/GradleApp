package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-01 16:34
 * @version V1.0
 *
 * ��һ��ͬѧ��ѧϰ��ʽ������Ҫ��һ�����������������������ܰ�������
 *
 *
 *
 * ��������������ͼ�ķ�ʽ���ڱ����У�����ϵ�����Ǵ��ڵ���0��������
 *
 * ?
 *
 * �����cont������������ϵ����cont[0]������ͼ��a0���Դ����ƣ�������һ������Ϊ2������[n, m]��ʹ����������ֵ����n / m����n, m���Լ��Ϊ1��
 *
 * ?
 *
 * ʾ�� 1��
 *
 * ���룺cont = [3, 2, 0, 2]
 * �����[13, 4]
 * ���ͣ�ԭ�������ȼ���3 + (1 / (2 + (1 / (0 + 1 / 2))))��ע��[26, 8], [-13, -4]��������ȷ�𰸡�
 * ʾ�� 2��
 *
 * ���룺cont = [0, 0, 3]
 * �����[3, 1]
 * ���ͣ�����������������ĸΪ1���ɡ�
 * ���ƣ�
 *
 * cont[i] >= 0
 * 1 <= cont�ĳ��� <= 10
 * cont���һ��Ԫ�ز�����0
 * �𰸵�n, m��ȡֵ���ܱ�32λint���ʹ��£���������2 ^ 31 - 1����
 *
 */
public class DeepDarkFraction {

    public static void main(String[] args) {

    }

    public int[] fraction1(int[] cont) {
        int a = 0, b = 0;

        int len = cont.length;
        for (int i = len - 1; i >= 0; i--) {
            if (i == 0) {

            } else {
                a = cont[i];
            }
        }

        return new int[]{
                a, b
        };
    }

    private int[] recursive(int[] count, int index) {
        if (index == count.length - 1) {
            return new int[]{count[index], 1};
        }

        int[] nextRes = recursive(count, index+1);
        return new int[]{count[index] * nextRes[0] + nextRes[1], nextRes[0]};
    }

    public int[] fraction(int[] cont) {
        return recursive(cont, 0);
    }

}
