package question.medium;

import java.util.*;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-07-27 14:24.
 * @version V1.0
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 *
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String tree = "tree";

        tree = "Aabb";
        System.out.println(frequencySort1(tree));

    }

    public static class StringInfo implements Comparable {
        int count = 0;
        char ch;

        public StringInfo(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }

        @Override
        public int compareTo(Object obj) {
            if (obj instanceof StringInfo) {
                StringInfo other = (StringInfo) obj;
                return Integer.compare(this.count, other.count);
            }
            return 0;
        }
    }

    public static String frequencySort(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] chars = s.toCharArray();
        Set<StringInfo> stringInfos = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char aChar : chars) {
            Integer integer = map.get(aChar);
            if (integer != null) {
                map.put(aChar, ++integer);
            } else {
                map.put(aChar, 1);
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            stringInfos.add(new StringInfo(characterIntegerEntry.getValue(), characterIntegerEntry.getKey()));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringInfo stringInfo : stringInfos) {
            int count = stringInfo.count;
            for (int i = 0; i < count; i++) {
                stringBuilder.append(stringInfo.ch);
            }
        }

        return stringBuilder.toString();
    }

    public static String frequencySort1(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxTimes = -1;
        //统计每个字母的频次，并存入哈希表
        for (char c : chs) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            maxTimes = map.get(c) > maxTimes ? map.get(c) : maxTimes;
        }
        //新建一个桶，将字母存入索引为它的频次的桶里
        ArrayList<Character>[] buckets = new ArrayList[maxTimes + 1];
        for (char c : map.keySet()) {
            int frequency = map.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }
        //倒着遍历桶，将桶里的字母取出来，并按照它的频次插入字符数组中
        int p = 0;
        for (int i = maxTimes; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    //buckets[i]这个桶里的字母的频次为i，因此要插入i个到结果集中
                    for (int j = 0; j < i; j++) {
                        //复用chs作为结果集
                        chs[p++] = c;
                    }
                }
            }
        }
        return new String(chs);

    }

}
