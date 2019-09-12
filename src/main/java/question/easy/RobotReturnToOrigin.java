package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-09-12 15:53
 * @version V1.0
 *
 * here is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves,
 * judge if this robot ends up at (0, 0) after it completes its moves.
 *
 * The move sequence is represented by a string, and the character moves[i] represents its ith move.
 * Valid moves are R (right), L (left), U (up), and D (down).
 * If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
 *
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once,
 * "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 *
 * Example 1:
 *
 * Input: "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude,
 * so it ended up at the origin where it started. Therefore, we return true.
 *  
 *
 * Example 2:
 *
 * Input: "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin.
 * We return false because it is not at the origin at the end of its moves.
 *
 *
 */
public class RobotReturnToOrigin {

    public static void main(String[] args) {
        RobotReturnToOrigin robotReturnToOrigin = new RobotReturnToOrigin();
        System.out.println(robotReturnToOrigin.judgeCircle("UDLR"));
    }

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) {
            return true;
        }

        int len = moves.length();
        if (len % 2 == 1) {
            return false;
        } else {
            char U = 'U';
            char D = 'D';
            char L = 'L';
            char R = 'R';

            int uCount = 0;
            int lCount = 0;

            char[] chars = moves.toCharArray();
            for (char aChar : chars) {
                if (aChar == U) {
                    uCount++;
                } else if (aChar == D) {
                    uCount--;
                } else if (aChar == L) {
                    lCount++;
                } else if (aChar == R) {
                    lCount--;
                }
            }

            return uCount == 0 && lCount == 0;
        }
    }

}
