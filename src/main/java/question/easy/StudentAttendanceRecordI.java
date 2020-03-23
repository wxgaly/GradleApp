package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-03-23 14:28
 * @version V1.0
 * <p>
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * You need to return whether the student could be rewarded according to his attendance record.
 * <p>
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 */
public class StudentAttendanceRecordI {

    public static void main(String[] args) {
        StudentAttendanceRecordI studentAttendanceRecordI = new StudentAttendanceRecordI();
        System.out.println(studentAttendanceRecordI.checkRecord("PPALLP"));
        System.out.println(studentAttendanceRecordI.checkRecord("PPALLL"));
    }

    public boolean checkRecord(String s) {
        boolean res = true;

        int aCount = 0;

        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char aChar = chars[i];
            if (aChar == 'A') {
                aCount++;
                if (aCount > 1) {
                    res = false;
                    break;
                }
            }

            if (aChar == 'L' && i + 2 < len) {
                if (chars[i + 1] == 'L' && chars[i + 2] == 'L') {
                    res = false;
                    break;
                }
            }
        }

        return res;
    }

    /**
     * 正则表达式匹配
     *
     * @param s
     * @return
     */
    public boolean checkRecord1(String s) {
        return !s.matches(".*(A.*A|LLL).*");
    }

}
