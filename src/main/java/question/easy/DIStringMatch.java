package question.easy;

import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-09-26 15:38
 * @version V1.0
 *
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 *
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0,?..., N-1:
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 * ?
 *
 * Example 1:
 *
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 *
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 *
 * Input: "DDI"
 * Output: [3,2,0,1]
 * ?
 *
 * Note:
 *
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 *
 *
 */
public class DIStringMatch {

    public static void main(String[] args) {
        DIStringMatch diStringMatch = new DIStringMatch();
        System.out.println(Arrays.toString(diStringMatch.diStringMatch1("DDI")));

    }

    public int[] diStringMatch(String S) {
        int len = S.length() + 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i;
        }

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'I') {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            } else if (aChar == 'D') {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        return arr;
    }

    /**
     *
     * ����
     *
     * �������ȿ����ַ����еĵ�һ����ĸ����� S[0] == 'I'����ô����ֻҪ�� A[0] = 0����һ�������� A[0] < A[1]����� S[0] == 'D'��
     * ͬ������ֻҪ�� A[0] = N����һ�������� A[0] > A[1]��
     *
     * �������������ǿ��� S ��ʣ�µ� N - 1 ����ĸʱ����ʣ�� N ��������ʹ�ã��� N ����Ϊ [0 .. N - 1] �� [1 .. N]�����Է��֣�
     * ���� S[0] ��ֵ�Ѿ�ȷ������ôʣ�� S �е� N - 1 ����ĸ�� N �����õ��������һ����ԭ������ͬ������ģΪ N - 1 �����⡣
     * ����� S[1] == 'I'�����Ǿ��� A[1] Ϊʣ��������С���Ǹ�������� S[1] == 'D'�����Ǿ��� A[1] Ϊʣ�����������Ǹ�����
     *
     * ����ÿ�λ�ѿ���ʹ�õ����ļ����е���Сֵ�����ֵȡ�������ŵ���ǰ��λ�ã���˿���ʹ�õ����ļ������������ģ��Ϳ��Էǳ�����Ľ���ά����
     *
     * �㷨
     *
     * ����ά����ǰδʹ�õ���С�������������Ƕ�Ӧ������Ϊ��ǰδʹ�õ����ļ��ϡ���������ɨ���ַ������������ 'I'����ȡ����ǰ��С������
     * ����ȡ����ǰ��������
     *
     *
     *
     * @param S
     * @return
     */
    public int[] diStringMatch1(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }

}
