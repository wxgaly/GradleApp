package question.medium;

import java.util.*;

/**
 * question.medium.NonoverlappingIntervals
 *
 * @author Created by WXG on 2019/3/13 013 17:22.
 * @version V1.0
 */

public class NonoverlappingIntervals {

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval(1, 2), new Interval(2, 3),
                new Interval(3, 4), new Interval(1, 3)
        };

//        intervals = new Interval[]{
//                new Interval(1, 2), new Interval(1, 2), new Interval(1, 2)
//        };

//        intervals = new Interval[]{
//                new Interval(1, 5), new Interval(2, 3)
//        };

//        intervals = new Interval[]{
//                new Interval(1, 2), new Interval(2, 3)
//        };

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {

        int ilen = intervals.length;
        if (ilen == 0) {
            return 0;
        }
        // 按结尾升序排序
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) {
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        int res = 1;
        // 前一个结尾区间的索引
        int pre = 0;
        for (int i = 1; i < ilen; i++) {
            if (intervals[i].start >= intervals[pre].end) {
                res++;
                pre = i;
            }
        }
        return ilen - res;
    }

}
