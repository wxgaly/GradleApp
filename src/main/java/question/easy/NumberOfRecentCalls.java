package question.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-10-09 17:14
 * @version V1.0
 *
 * Write a class RecentCounter to count recent requests.
 *
 * It has only one method:?ping(int t), where t represents some time in milliseconds.
 *
 * Return the number of pings that have been made from 3000 milliseconds ago until now.
 *
 * Any ping with time in [t - 3000, t] will count, including the current ping.
 *
 * It is guaranteed that every call to ping uses a strictly larger value of?t than before.
 *
 * ?
 *
 * Example 1:
 *
 * Input: inputs = ["RecentCounter","ping","ping","ping","ping"], inputs = [[],[1],[100],[3001],[3002]]
 * Output: [null,1,2,3,3]
 * ?
 *
 * Note:
 *
 * Each test case will have at most 10000 calls to ping.
 * Each test case will call?ping with strictly increasing values of t.
 * Each call to ping will have 1 <= t <= 10^9.
 *
 * ���Ȿ����Щ����⣬��ʵ����Ҫ��¼3���ڵ�ping��������������һ�����У����µ�ping�ͽ�����Ԫ��ȥ�������µ�ʱ����жԱȣ�
 * ���û�г���3s���Ƴ����У���������ˣ���Ӷ����Ƴ�
 *
 */
public class NumberOfRecentCalls {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

    static class RecentCounter {
        Queue<Integer> q;
        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.add(t);
            while (q.peek() < t - 3000)
                q.poll();
            return q.size();
        }

    }

}
