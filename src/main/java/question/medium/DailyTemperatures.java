package question.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-07-24 16:34.
 * @version V1.0
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] T = new int[]{
                73, 74, 75, 71, 69, 72, 76, 73
        };

        System.out.println(Arrays.toString(dailyTemperatures(T)));
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        // ����ջ ������� �ǵ�������
        Stack<Integer> stack = new Stack<>();
        // �Ӻ���ǰ����
        for (int i = T.length - 1; i >= 0; i--) {
            // ��ǰԪ�ر�ջ��Ԫ�ش� ��ջ ���µ���ջֱ������Ҫ��
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            // ջΪ�� ������û�бȵ�ǰ���¶ȸߵ�
            // ��Ϊ�� ջ��Ԫ�ض�Ӧ���±��ȥ��ǰ�±꼴Ϊ����������¶ȱȵ�ǰ���¶ȸ�
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            // ��ǰԪ�ؽ�ջ
            stack.push(i);
        }
        return res;

    }

}
