package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-02-17 16:53
 * @version V1.0
 *
 * Given a date, return the corresponding day of the week for that date.
 *
 * The input is given as three integers representing the day, month and year respectively.
 *
 * Return the answer as one of the following values?{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 *
 * ?
 *
 * Example 1:
 *
 * Input: day = 31, month = 8, year = 2019
 * Output: "Saturday"
 * Example 2:
 *
 * Input: day = 18, month = 7, year = 1999
 * Output: "Sunday"
 * Example 3:
 *
 * Input: day = 15, month = 8, year = 1993
 * Output: "Sunday"
 * ?
 *
 * Constraints:
 *
 * The given dates are valid?dates between the years 1971 and 2100
 *
 *
 */
public class DayoftheWeek {

    public static void main(String[] args) {
        DayoftheWeek dayoftheWeek = new DayoftheWeek();
        System.out.println(dayoftheWeek.dayOfTheWeek(3, 10, 2020));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int iWeek = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;                              //基姆拉尔森计算公式
        String[] result = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return result[iWeek];
    }

}
