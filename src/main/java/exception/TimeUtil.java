package exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * exception.TimeUtil
 *
 * @author Created by WXG on 2019/1/4 23:27.
 * @version V1.0
 */

public class TimeUtil {


    final static String PAST = "past";
    final static String TO = "to";
    final static String MINUTE = "minute";
    final static String MINUTES = "minutes";
    private static final String SPACE = " ";
    private static final String COLON = ":";
    private static final String OCLOCK = "o'clock";
    private static final String QUARTER = "quarter";
    private static final String HALF = "half";

    private static final String[] INDNUM = {"zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] DECNUM = {"twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(convertNumber2String4Time(h, m));
    }

    public static String convertNumber2String4Time(int hour, int minute) {

        if (hour < 0 || hour > 12 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("numberTime is illegal, hour or minute is illegal!");
        }

        StringBuilder sb = new StringBuilder();

        if (minute == 0) {
            sb.append(INDNUM[hour]);
            sb.append(SPACE);
            sb.append(OCLOCK);
        } else if (minute < 30)  {

            if (minute == 15) {
                sb.append(QUARTER).append(SPACE);
            } else {
                if (minute < 20) {
                    if (minute == 1) {
                        sb.append(INDNUM[1]).append(SPACE);
                        sb.append(MINUTE).append(SPACE);
                    } else {
                        sb.append(INDNUM[minute]).append(SPACE);
                        sb.append(MINUTES).append(SPACE);
                    }
                } else {
                    if (minute == 20) {
                        sb.append(DECNUM[0]).append(SPACE);
                    } else {
                        sb.append(DECNUM[0]).append(SPACE);
                        sb.append(INDNUM[minute % 20]).append(SPACE);
                    }
                    sb.append(MINUTES).append(SPACE);
                }
            }

            sb.append(PAST).append(SPACE);

            sb.append(INDNUM[hour]);
        } else {
            if (minute == 30) {
                sb.append(HALF).append(SPACE);
                sb.append(PAST).append(SPACE);
                sb.append(INDNUM[hour]);
            } else {

                if (minute < 40) {
                    sb.append(DECNUM[0]).append(SPACE);
                    sb.append(INDNUM[(60 - minute) % 20]).append(SPACE);
                    sb.append(MINUTES).append(SPACE);
                } else {
                    if (minute == 45) {
                        sb.append(QUARTER).append(SPACE);
                    } else {
                        sb.append(INDNUM[60 - minute]).append(SPACE);
                        sb.append(MINUTES).append(SPACE);
                    }
                }

                sb.append(TO).append(SPACE);

                sb.append(INDNUM[hour + 1]);
            }

        }

        return sb.toString();
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

}
