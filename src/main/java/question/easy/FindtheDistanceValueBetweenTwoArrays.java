package question.easy;

/**
 * question.easy.
 *
 * @author Created by WXG on 2020-04-19 20:56
 * @version V1.0
 */
public class FindtheDistanceValueBetweenTwoArrays {

    public static void main(String[] args) {
        FindtheDistanceValueBetweenTwoArrays arrays = new FindtheDistanceValueBetweenTwoArrays();
        int[] arr1 = new int[]{
                1, 4, 2, 3
        };
        int[] arr2 = new int[]{
                -4, -3, 6, 10, 20, 30
        };
        int d = 3;

        System.out.println(arrays.findTheDistanceValue(arr1, arr2, d));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i : arr1) {
            boolean match = false;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    match = true;
                    break;
                }
            }
            if (!match) {
                count++;
            }
        }
        return count;
    }

}
