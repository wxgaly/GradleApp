package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-23 16:48
 * @version V1.0
 *
 * A bus?has n stops numbered from 0 to n - 1 that form?a circle.
 * We know the distance between all pairs of neighboring stops where distance[i]
 * is the distance between the stops number?i and (i + 1) % n.
 *
 * The bus goes along both directions?i.e. clockwise and counterclockwise.
 *
 * Return the shortest distance between the given?start?and destination?stops.
 *
 * ?
 *
 * Example 1:
 *
 *
 *
 * Input: distance = [1,2,3,4], start = 0, destination = 1
 * Output: 1
 * Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 * ?
 *
 * Example 2:
 *
 *
 *
 * Input: distance = [1,2,3,4], start = 0, destination = 2
 * Output: 3
 * Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 * ?
 *
 * Example 3:
 *
 *
 *
 * Input: distance = [1,2,3,4], start = 0, destination = 3
 * Output: 4
 * Explanation: Distance between 0 and 3 is 6 or 4, minimum is 4.
 * ?
 *
 * Constraints:
 *
 * 1 <= n?<= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 *
 *
 */
public class DistanceBetweenBusStops {

    public static void main(String[] args) {
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops1(new int[]{1, 2, 3, 4}, 0, 3));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int min = 0;

        /**
         * ÏÈ¼ÆËãË³Ê±Õë¾àÀë[start, destination)
         */
        for (int i = start; i < destination; i++) {
            min += distance[i];
        }

        int temp = 0;
        /**
         * ÔÙ¼ÆËãÄæÊ±Õë¾àÀë[0, start), [destination, length)
         */
        for (int i = 0; i < start; i++) {
            temp += distance[i];
        }

        int len = distance.length;
        for (int i = destination; i < len; i++) {
            temp += distance[i];
        }

        return min > temp ? temp : min;
    }

    public int distanceBetweenBusStops1(int[] distance, int start, int destination) {
        int d1 = 0;
        int d2 = 0;
        if (start > destination) {
            int n = destination;
            destination = start;
            start = n;
        }
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                d1 += distance[i];
            } else {
                d2 += distance[i];
            }
        }
        return d1 > d2 ? d2 : d1;
    }


}
