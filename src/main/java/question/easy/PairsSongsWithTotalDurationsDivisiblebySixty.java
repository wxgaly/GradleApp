package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-13 14:22
 * @version V1.0
 * <p>
 * In a list of songs, the i-th?song has a duration of?time[i] seconds.?
 * <p>
 * Return the number of pairs of songs for which their total?duration in seconds is divisible by 60.?
 * Formally, we want the number of?indices i < j with (time[i] + time[j]) % 60 == 0.
 * <p>
 * ?
 * <p>
 * Example 1:
 * <p>
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 * <p>
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 * ?
 * <p>
 * Note:
 * <p>
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 */
public class PairsSongsWithTotalDurationsDivisiblebySixty {

    public static void main(String[] args) {
        PairsSongsWithTotalDurationsDivisiblebySixty songs = new PairsSongsWithTotalDurationsDivisiblebySixty();
        System.out.println(songs.numPairsDivisibleBy60(new int[]{
                30, 20, 150, 100, 40
        }));
    }

    /**
     * 超时
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        if (time.length == 1) {
            return 0;
        }

        int count = 0;
        int len = time.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 题解来自：
     * https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/java-2ms-ji-bai-10000-by-keen0126/
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy601(int[] time) {
        int count = 0;
        int[] seconds = new int[60];
        for (int t : time) {
            seconds[t % 60] += 1;
        }
        count += combination(seconds[30], 2);
        count += combination(seconds[0], 2);
        int i = 1, j = 59;
        while (i < j) {
            count += seconds[i++] * seconds[j--];
        }
        return count;
    }

    // 求组合数
    public int combination(int n, int k) {
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return (int) result;
    }


}
