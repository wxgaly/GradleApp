package question.medium;

import java.util.Arrays;

/**
 * question.medium.GenerateRandomPointInACircle
 *
 * @author Created by WXG on 2019/3/11 011 14:52.
 * @version V1.0
 * <p>
 * Given the radius and x-y positions of the center of a circle, write a function randPoint which generates a uniform random point in the circle.
 * <p>
 * Note:
 * <p>
 * input and output values are in floating-point.
 * radius and x-y position of the center of the circle is passed into the class constructor.
 * a point on the circumference of the circle is considered to be in the circle.
 * randPoint returns a size 2 array containing x-position and y-position of the random point, in that order.
 * Example 1:
 * <p>
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1,0,0],[],[],[]]
 * Output: [null,[-0.72939,-0.65505],[-0.78502,-0.28626],[-0.83119,-0.19803]]
 * Example 2:
 * <p>
 * Input:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[10,5,-7.5],[],[],[]]
 * Output: [null,[11.52438,-8.33273],[2.46992,-16.21705],[11.13430,-12.42337]]
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has three arguments,
 * the radius, x-position of the center, and y-position of the center of the circle. randPoint has no arguments.
 * Arguments are always wrapped with a list, even if there aren't any.
 */

public class GenerateRandomPointInACircle {

    public static void main(String[] args) {
        Solution solution = new Solution(1, 0, 0);
        solution = new Solution(10, 5, -7.5);
        System.out.println(Arrays.toString(solution.randPoint()));
    }

    static class Solution {

        private double radius;
        private double x_center;
        private double y_center;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            double xRandom = random(x_center - radius, x_center + radius);
            if (xRandom == x_center - radius) {
                return new double[]{radius - x_center, 0.0};
            }

            if (xRandom == x_center + radius) {
                return new double[]{radius + x_center, 0.0};
            }

            double[] yPoint = getY(xRandom);
            double yRandom = random(yPoint[0], yPoint[1]);

            return new double[]{xRandom, yRandom};
        }

        //求角度用三角函数解
//        public double[] randPoint() {
//            double r = radius * Math.sqrt(Math.random());
//            double theta = Math.PI * 2 * Math.random();
//            double[] res = new double[2];
//            res[0] = Math.cos(theta) * r + x_center;
//            res[1] = Math.sin(theta) * r + y_center;
//            return res;
//        }

        private double[] getY(double x) {
            double temp = Math.sqrt(radius * radius - (x - x_center) * (x - x_center));
            return new double[]{y_center - temp, y_center + temp};
        }

        /**
         * 取[x, y]左闭右闭随机数
         *
         * @param x 左
         * @param y 右
         * @return [x, y]范围内的随机数
         */
        private double random(double x, double y) {
            return x + Math.random() * y % (y - x + 1);
        }
    }

}
