package question.easy;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-07-17 13:56.
 * @version V1.0
 *
 * n a deck of cards, each card has an integer written on it.
 *
 * Return true if and only if you can choose?X >= 2 such that?
 * it is possible to split the entire deck?into 1 or more groups of cards, where:
 *
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 * ?
 *
 * Example 1:
 *
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 *
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * Example 3:
 *
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 *
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * Example 5:
 *
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 *
 * Note:
 *
 * 1 <= deck.length <= 10000
 * 0 <= deck[i] <?10000
 *
 *
 */
public class XOfAKindInADeckOfCards {

    public static void main(String[] args) {
        int[] deck = new int[]{
                1, 2, 3, 4, 4, 3, 2, 1
        };
        System.out.println(hasGroupsSizeX(deck));
    }

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length <= 1) {
            return false;
        }

        int[] a = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            a[deck[i]]++;
        }

        // 使用有序的set
        Set<Integer> sameLength = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                if (a[i] == 1) {
                    return false;
                }
                sameLength.add(a[i]);
            }
        }
        if (sameLength.size() == 1) {
            return true;
        }

        // 如果sameLenth中元素个数不一致，那么其他的都应该把X能整除
        Iterator<Integer> iterator = sameLength.iterator();
        int min = iterator.next();

        for (int i=2; i<=min; i++){

            boolean isFindX = true;
            Iterator<Integer> iterator2 = sameLength.iterator();
            while (iterator2.hasNext()) {
                int temp = iterator2.next();
                if (temp % i != 0) {
                    isFindX = false;
                    break;
                }
            }

            if (isFindX){
                return true;
            }
        }
        return false;

    }

}
