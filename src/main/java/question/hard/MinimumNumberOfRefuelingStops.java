package question.hard;

/**
 * question.hard.MinimumNumberOfRefuelingStops
 *
 * @author Created by WXG on 2019-4-11 18:54.
 * @version V1.0
 * <p>
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 * <p>
 * Along the way, there are gas stations.
 * Each station[i] represents a gas station that is station[i][0] miles east of the starting position,
 * and has station[i][1] liters of gas.
 * <p>
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
 * It uses 1 liter of gas per 1 mile that it drives.
 * <p>
 * When the car reaches a gas station, it may stop and refuel,
 * transferring all the gas from the station into the car.
 * <p>
 * What is the least number of refueling stops the car must make in order to reach its destination?
 * If it cannot reach the destination, return -1.
 * <p>
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
 * If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 1, startFuel = 1, stations = []
 * Output: 0
 * Explanation: We can reach the target without refueling.
 * Example 2:
 * <p>
 * Input: target = 100, startFuel = 1, stations = [[10,100]]
 * Output: -1
 * Explanation: We can't reach the target (or even the first gas station).
 * Example 3:
 * <p>
 * Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * Output: 2
 * Explanation:
 * We start with 10 liters of fuel.
 * We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
 * Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
 * and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
 * We made 2 refueling stops along the way, so we return 2.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= target, startFuel, stations[i][1] <= 10^9
 * 0 <= stations.length <= 500
 * 0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 */

public class MinimumNumberOfRefuelingStops {

    public static void main(String[] args) {

        int target = 100;
        int startFuel = 10;
        int[][] stations = new int[][]{
                {10, 60},
                {20, 30},
                {30, 30},
                {60, 40}
        };

        System.out.println(minRefuelStops(target, startFuel, stations));
    }

    /**
     * ����δ������ȷ��
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int count = 0;

        if (startFuel >= target) {
            return 0;
        } else {
            if (stations.length == 0) {
                return -1;
            }
            if (startFuel < stations[0][0]) {
                return -1;
            } else {
                int startPosition = 0;
                for (int i = 0; i < stations.length; i++) {

                    int residue = target - startFuel;
                    if (startFuel > stations[i][0] - startPosition) {//��ǰ�ͻ��㹻������һ������վ
                        continue;
                    } else if (startFuel == stations[i][0] - startPosition) {//��ǰ�����ù����˼���վ
                        startFuel = stations[i][1];
                    } else {//��ǰ�����ò������˼���վ���͵�����һ������վ����
                        startFuel = startFuel - stations[i - 1][0] + stations[i - 1][1];
                    }

                    startPosition = stations[i][0];

                    if (i < stations.length - 1) {
                        if (startFuel > residue) {
                            return count;
                        } else if (startFuel + stations[i][0] < stations[i + 1][0]) {
                            return -1;
                        }
                    }

                    count++;

                }

                if (startPosition < target) {
                    if (startFuel + stations[stations.length - 1][1] > target) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /**
     * ��ȷ���
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public static int minRefuelStops1(int target, int startFuel, int[][] stations) {
        //ÿ����ʣ�������ߵ�����·�̣��ҵ����ĺ���ʼ��Χ�ڵļ���վ���ܼ�����͵��Ǹ�
        int alreadyGo = 0;
        alreadyGo += startFuel;
        int res = 0;
        boolean[] isStationUsed = new boolean[stations.length];
        while (alreadyGo < target) {
            int maxPos = 0;
            int maxFuel = -1;
            //��ʶ�Ƿ����Ϳɼ�
            boolean isAddFuel = false;
            //�ҵ�ǰ��ɼ�����͵ļ���վ������
            for (int i = 0; i < stations.length && stations[i][0] <= alreadyGo; i++) {
                if (isStationUsed[i] == false && stations[i][1] > maxFuel) {
                    maxFuel = stations[i][1];
                    maxPos = i;
                    isAddFuel = true;
                }
            }
            if (!isAddFuel) {
                return -1;
            }
            isStationUsed[maxPos] = true;
            alreadyGo += stations[maxPos][1];
            res++;
        }
        return res;
    }

}
