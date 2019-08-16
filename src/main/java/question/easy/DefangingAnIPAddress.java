package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-08-16 17:33.
 * @version V1.0
 *
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * A defanged IP address replaces every period "." with "[.]".
 *
 *  
 *
 * Example 1:
 *
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 * Example 2:
 *
 * Input: address = "255.100.50.0"
 * Output: "255[.]100[.]50[.]0"
 *  
 *
 * Constraints:
 *
 * The given address is a valid IPv4 address.
 *
 *
 */
public class DefangingAnIPAddress {

    public static void main(String[] args) {
        System.out.println(defangIPaddr1("1.1.1.1"));
        System.out.println(defangIPaddr1("255.100.50.0"));
    }

    public static String defangIPaddr(String address) {
        if (address == null || address.isEmpty()) {
            return address;
        }

        String[] split = address.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();

        int len = split.length;
        for (int i = 0; i < len; i++) {
            if (i < len - 1) {
                stringBuilder.append(split[i]).append("[.]");
            } else {
                stringBuilder.append(split[i]);
            }
        }

        return stringBuilder.toString();
    }

    public static String defangIPaddr1(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static String defang(String address) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                s.append('[');
                s.append('.');
                s.append(']');
            } else {
                s.append(address.charAt(i));
            }
        }
        return s.toString();

    }

}
