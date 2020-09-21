package question.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-05-08 13:50
 * @version V1.0
 *
 * �ҳ��������ظ������֡�
 *
 *
 * ��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�
 * Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
 *
 * ʾ�� 1��
 *
 * ���룺
 * [2, 3, 1, 0, 2, 5, 3]
 * �����2 �� 3
 * ?
 *
 * ���ƣ�
 *
 * 2 <= n <= 100000
 *
 *
 */
public class RepeatNumberInArray {

    public static void main(String[] args) {

    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

}
