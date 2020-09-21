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
        // 单调栈 里面的数 非递增排序
        Stack<Integer> stack = new Stack<>();
        // 从后往前遍历
        for (int i = T.length - 1; i >= 0; i--) {
            // 当前元素比栈顶元素大 出栈 重新调整栈直至满足要求
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            // 栈为空 即后面没有比当前天温度高的
            // 不为空 栈顶元素对应的下标减去当前下标即为经过几天后温度比当前天温度高
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            // 当前元素进栈
            stack.push(i);
        }
        return res;

    }

}
