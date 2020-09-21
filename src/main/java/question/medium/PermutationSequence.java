package question.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * question.medium.PermutationSequence
 *
 * @author Created by WXG on 2019/4/1 001 14:01.
 * @version V1.0
 * <p>
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * <p>
 * Input: n = 4, k = 9
 * Output: "2314"
 */

public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(5, 120));
    }

    /**
     * ֱ���û��ݷ����Ļ���Ҫ�ڻ��ݵ���k������ʱ��ֹ�Ͳ��ᳬʱ��, ����Ч�����ɸ���
     * ��������ѧ�ķ�������, ��Ϊ���ֶ��Ǵ�1��ʼ��������Ȼ��, ���г��ֵĴ��������
     * �����, ����n=4, k=15 �ҵ�k=15���еĹ���:
     * <p>
     * 1 + ��2,3,4��ȫ���� (3!��)
     * 2 + ��1,3,4��ȫ���� (3!��)         3, 1 + ��2,4��ȫ����(2!��)
     * 3 + ��1,2,4��ȫ���� (3!��)-------> 3, 2 + ��1,4��ȫ����(2!��)-------> 3, 2, 1 + ��4��ȫ����(1!��)-------> 3214
     * 4 + ��1,2,3��ȫ���� (3!��)         3, 4 + ��1,2��ȫ����(2!��)         3, 2, 4 + ��1��ȫ����(1!��)
     * <p>
     * ȷ����һλ:
     * k = 14(��0��ʼ����)
     * index = k / (n-1)! = 2, ˵����15�����ĵ�һλ��3
     * ����k
     * k = k - index*(n-1)! = 2
     * ȷ���ڶ�λ:
     * k = 2
     * index = k / (n-2)! = 1, ˵����15�����ĵڶ�λ��2
     * ����k
     * k = k - index*(n-2)! = 0
     * ȷ������λ:
     * k = 0
     * index = k / (n-3)! = 0, ˵����15�����ĵ���λ��1
     * ����k
     * k = k - index*(n-3)! = 0
     * ȷ������λ:
     * k = 0
     * index = k / (n-4)! = 0, ˵����15�����ĵ���λ��4
     * ����ȷ��n=4ʱ��15����Ϊ3214
     **/
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // ��ѡ����
        List<Integer> candidates = new ArrayList<>();
        // ��ĸ�Ľ׳���
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        int fact = 1;
        for (int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for (int i = n - 1; i >= 0; --i) {
            // �����ѡ���ֵ�index
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k -= index * factorials[i];
        }
        return sb.toString();
    }


}
