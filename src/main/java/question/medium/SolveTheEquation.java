package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-09 18:14.
 * @version V1.0
 * Solve a given equation and return the value of x in the form of string "x=#value".
 * The equation contains only '+', '-' operation, the variable x and its coefficient.
 *
 * If there is no solution for the equation, return "No solution".
 *
 * If there are infinite solutions for the equation, return "Infinite solutions".
 *
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 *
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 */
public class SolveTheEquation {

    public static void main(String[] args) {

    }

    public String solveEquation(String equation) {
        /**
         1、统计左右两边的x总个数，以及左右两边数字和
         2、左右两边x相等以及数字相等为无限解；左右两边相等但是数字和不等为无解
         */
        String[] strs = equation.split("=");
        String leftPart = strs[0];
        String rightPart = strs[1];
        int[] leftSum = countXAndNum(leftPart);
        int[] rightSum = countXAndNum(rightPart);
        if (leftSum[0] == rightSum[0]) {
            if (leftSum[1] == rightSum[1]) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + String.valueOf((rightSum[1] - leftSum[1]) / (leftSum[0] - rightSum[0]));
        }
    }

    private int[] countXAndNum(String part) {
        int[] res = new int[2];
        int isNegative = 1;
        String[] strs_negative = part.split("-");
        for (int j = 0; j < strs_negative.length; j++) {
            if (j != 0) isNegative = -1;
            String[] strs = strs_negative[j].split("\\+");
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= 0) continue;
                if (i != 0) isNegative = 1;
                if (strs[i].charAt(strs[i].length() - 1) == 'x') {
                    if (strs[i].length() > 1) {
                        res[0] += isNegative * Integer.valueOf(strs[i].substring(0, strs[i].length() - 1));
                    } else {
                        res[0] += isNegative;
                    }
                } else {
                    res[1] += isNegative * Integer.valueOf(strs[i]);
                }
            }
        }
        return res;
    }

}
