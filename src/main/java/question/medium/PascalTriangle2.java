package question.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * question.medium.PascalTriangle2
 *
 * @author Created by WXG on 2019/3/16 22:54.
 * @version V1.0
 */

public class PascalTriangle2 {

    public static void main(String[] args) {
        List<Integer> row = getRow(33);
        System.out.println(row);
    }

    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<Integer> list = new ArrayList<>(rowIndex);
        int[] number = getNumber(rowIndex);
        for (int i : number) {
            list.add(i);
        }
        return list;
    }

    public static int[] getNumber(int rowIndex) {
        int[] arr = new int[rowIndex];
        arr[0] = 1;

        if (rowIndex == 1) {
            return arr;
        } else if (rowIndex == 2) {
            arr[1] = 1;
            return arr;
        }

        arr[rowIndex - 1] = 1;

        int[] number = getNumber(rowIndex - 1);

        for (int i = 0; i < rowIndex - 2; i++) {
            arr[i + 1] = number[i] + number[i + 1];
        }

        return arr;
    }


}
