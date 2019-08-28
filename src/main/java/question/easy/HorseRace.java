package question.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-08-28 14:12.
 * @version V1.0
 */
public class HorseRace {

    public static void main(String[] args) {

        ArrayList<Integer> horses = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

//        permutation(horses, new ArrayList<>());
//
//        System.out.println();

        combine(horses, new ArrayList<>(), 3);
    }

    /**
     * 排列，全排列
     *
     * @param horses
     * @param result
     */
    public static void permutation(ArrayList<Integer> horses, ArrayList<Integer> result) {

        if (horses.size() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < horses.size(); i++) {
            ArrayList<Integer> new_result = (ArrayList<Integer>) result.clone();
            new_result.add(horses.get(i));

            ArrayList<Integer> rest_horses = (ArrayList<Integer>) horses.clone();
            rest_horses.remove(i);

            permutation(rest_horses, new_result);
        }
    }

    /**
     *
     * 组合，几选几
     *
     * @param horses
     * @param result
     * @param m
     */
    public static void combine(ArrayList<Integer> horses, ArrayList<Integer> result, int m) {

        if (result.size() == m) {
            System.out.println(result);

            return;
        }

        for (int i = 0; i < horses.size(); i++) {
            ArrayList<Integer> new_result = (ArrayList<Integer>) result.clone();
            new_result.add(horses.get(i));

            ArrayList<Integer> rest_horses = new ArrayList<>(horses.subList(i + 1, horses.size()));

            combine(rest_horses, new_result, m);
        }
    }

}
