package question.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * question.hard.
 *
 * @author Created by WXG on 2019-06-30 16:17.
 * @version V1.0
 *
 * Median is the middle value in an ordered integer list. If the size of the list is even,
 * there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * ?
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * ?
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0?and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 *
 */
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(6);
        System.out.println(finder.findMedian());
        finder.addNum(10);
        System.out.println(finder.findMedian());
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(6);
        System.out.println(finder.findMedian());
        finder.addNum(5);
        System.out.println(finder.findMedian());
        finder.addNum(0);
        System.out.println(finder.findMedian());
        finder.addNum(6);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(1);
        System.out.println(finder.findMedian());
        finder.addNum(0);
        System.out.println(finder.findMedian());
        finder.addNum(0);
        System.out.println(finder.findMedian());
    }

    /**
     * 每次排序，会超时
     */
    public static class MedianFinder {

        private List<Integer> list;
        private int size = 0;
        private double median = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            list = new ArrayList<>(100);
        }

        public void addNum(int num) {
            size++;
            list.add(num);
            Collections.sort(list);
            if (size % 2 == 0) {
                median = (list.get(size / 2 - 1) + list.get(size / 2)) / 2.0;
            } else {
                median = list.get(size / 2);
            }
        }

        public double findMedian() {
            return median;
        }
    }

    /**
     * 最大堆，最小堆解法
     */
    public class MedianFinder1 {

        /**
         * 当前大顶堆和小顶堆的元素个数之和
         */
        private int count;
        private PriorityQueue<Integer> maxheap;
        private PriorityQueue<Integer> minheap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder1() {
            count = 0;
            maxheap = new PriorityQueue<>((x, y) -> y - x);
            minheap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            count += 1;
            maxheap.offer(num);
            minheap.add(maxheap.poll());
            // 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
            if ((count & 1) != 0) {
                maxheap.add(minheap.poll());
            }
        }

        public double findMedian() {
            if ((count & 1) == 0) {
                // 如果两个堆合起来的元素个数是偶数，数据流的中位数就是各自堆顶元素的平均值
                return (double) (maxheap.peek() + minheap.peek()) / 2;
            } else {
                // 如果两个堆合起来的元素个数是奇数，数据流的中位数大顶堆的堆顶元素
                return (double) maxheap.peek();
            }
        }
    }


}
