package question.medium;

/**
 * question.medium.
 *
 * @author Created by WXG on 2019-05-08 16:45.
 * @version V1.0
 *
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 *
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's, the n+1 bit is 0,
 * followed by n-1 bytes with most significant 2 bits being 10.
 * This is how the UTF-8 encoding would work:
 *
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 *
 * Note:
 * The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data.
 * This means each integer represents only 1 byte of data.
 *
 * Example 1:
 *
 * data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
 *
 * Return true.
 * It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.
 * Example 2:
 *
 * data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
 *
 * Return false.
 * The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
 * The next byte is a continuation byte which starts with 10 and that's correct.
 * But the second continuation byte does not start with 10, so it is invalid.
 *
 */
public class UTF8Validation {

    public static void main(String[] args) {
        int[] data = new int[]{
                197, 130, 1
        };

//        data = new int[]{
//                235, 140, 4
//        };
        System.out.println(validUtf8(data));
    }

    public boolean validUTF8(int[] data) {
        int length = data.length;
        if (length == 0) return false;
        for (int i = 0; i < length; i++) {
            //System.out.println(data[i]);
            if ((data[i] & 248) == 240)//4字节情况
            {
                int j = i + 3;
                i++;
                if (j > length - 1)
                    return false;
                while (i <= j) {
                    if ((data[i] & 192) != 128)
                        return false;
                    i++;
                }
                i--;
            } else if ((data[i] & 240) == 224)//3字节情况
            {
                int j = i + 2;
                i++;
                if (j > length - 1)
                    return false;
                while (i <= j) {
                    if ((data[i] & 192) != 128)
                        return false;
                    i++;
                }
                i--;
            } else if ((data[i] & 224) == 192)//2字节情况
            {
                int j = i + 1;
                i++;
                if (j > length - 1)
                    return false;
                while (i <= j) {
                    if ((data[i] & 192) != 128)
                        return false;
                    i++;
                }
                i--;
            } else if ((data[i] & 128) != 0) {
                //System.out.println(data[i]);
                return false;
            }
        }
        return true;
    }

    public static boolean validUtf8(int[] data) {

        if (data == null || data.length == 0 || data.length > 4) {
            return false;
        }

        boolean isValid = false;

        int len = data.length;

        if (len == 1) {
            isValid = Integer.toBinaryString((byte) data[0]).startsWith("0");
        } else {
//            int count = validFirst((byte) data[0]);
            int count = Integer.toBinaryString(((byte) data[0]) & 0xff).indexOf("0");
            if (count < 2) {
                return false;
            }

            isValid = true;
            if (count > len) {
                count = len;
            }
            for (int i = 1; i < count; i++) {
                String value = Integer.toBinaryString(((byte) data[i]) & 0xff);
                if (value.length() != 8) {
                    isValid = false;
                    break;
                } else {
                    if (!value.startsWith("10")) {
                        isValid = false;
                        break;
                    }
                }
//                if (!validOther((byte) data[i])) {
//                    isValid = false;
//                    break;
//                }
            }
        }

        return isValid;
    }

    private static int validFirst(byte first) {
        return Integer.toBinaryString(first & 0xff).indexOf("0");
    }

    private static boolean validOther(byte value) {
        return Integer.toBinaryString(value & 0xff).startsWith("10");
    }
}
