package question;

import java.util.*;

/**
 * question.PartitionLabels
 *
 * @author Created by WXG on 2019/3/4 004 16:51.
 * @version V1.0
 */

public class PartitionLabels {

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        System.out.println(Arrays.toString(partitionLabels(S).toArray()));
    }

    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int len = S.length();
        char[] chars = S.toCharArray();
        for (int i = 0; i < len; i++) {
            map.put(chars[i], i);
        }

        int index = 0;

        for (int i = 0; i < len; i++) {
            index = map.get(chars[i]);
            for (int j = i + 1; j < index && j < len; j++) {
                int start = map.get(chars[j]);
                if (start > index) {
                    index = start;
                }
            }
            list.add(index - i + 1);
            i = index;
        }

        return list;
    }

}
