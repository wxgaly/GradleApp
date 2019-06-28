package question.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * question.easy.
 *
 * @author Created by WXG on 2019-06-28 16:37.
 * @version V1.0
 */
public class FizzBuzz {

    public static void main(String[] args) {
        fizzBuzz(15).forEach(System.out::println);
    }

    public static List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int value = i + 1;
            if (value % 3 == 0 && value % 5 == 0) {
                list.add(fizzBuzz);
            } else {
                if (value % 3 == 0) {
                    list.add(fizz);
                } else if (value % 5 == 0) {
                    list.add(buzz);
                } else {
                    list.add(value + "");
                }
            }

        }

        return list;
    }

}
