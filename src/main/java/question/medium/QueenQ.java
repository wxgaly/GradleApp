package question.medium;

/**
 * question.medium.QueenQ
 *
 * @author Created by WXG on 2019/4/1 001 15:02.
 * @version V1.0
 */

public class QueenQ {

    public static void main(String[] args) {
        cal8queens(0);
    }

    static int[] result = new int[8];

    public static void cal8queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    private static boolean isOk(int row, int column) {
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }

            if (rightup < 8) {
                if (result[i] == leftup) {
                    return false;
                }
            }

            --leftup;
            ++rightup;
        }
        return true;
    }

    private static void printQueens(int[] result) {
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
