package question.medium;

/**
 * question.medium.PrimePalindrome
 *
 * @author Created by WXG on 2019/3/29 029 14:56.
 * @version V1.0
 * Find the smallest prime palindrome greater than or equal to N.
 * <p>
 * Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.
 * <p>
 * For example, 2,3,5,7,11 and 13 are primes.
 * <p>
 * Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.
 * <p>
 * For example, 12321 is a palindrome.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: 7
 * Example 2:
 * <p>
 * Input: 8
 * Output: 11
 * Example 3:
 * <p>
 * Input: 13
 * Output: 101
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^8
 * The answer is guaranteed to exist and be less than 2 * 10^8.
 */

public class PrimePalindrome {

    public static void main(String[] args) {
        System.out.println(primePalindrome1(1000));
//        printPrime(10301);
    }

    private static void printPrime(int N) {
        for (int j = 0; j <= N; j++) {
            for (int i = 2; i <= j; i++) {
                if (j % i == 0 && i != j) {
                    break;
                } else if (i == j) {
                    System.out.println(i);
                }
            }
        }
    }

    public static int primePalindrome(int N) {

        int MAX = (int) Math.pow(10, 8);

        int num = 0;

        for (int i = N; i <= MAX; i++) {
            if (isPrime(i) && isPalindromic(i)) {
                num = i;
                break;
            }
        }

        return num;
    }

    public static int primePalindrome1(int N) {
        if (N <= 11) {
            if (N <= 2)
                return 2;
            else if (N == 3)
                return 3;
            else if (N <= 5)
                return 5;
            else if (N <= 7)
                return 7;
            else
                return 11;
        }
        // when N > 11
        int modulus = N % 6;
        switch (modulus) {
            case 0:
                N++;
            case 1:
                modulus = 1;
                break;
            case 2:
                N++;
            case 3:
                N++;
            case 4:
                N++;
            case 5:
                modulus = 5;
                break;
        }
        int[] nums = new int[10];
        for (; ; ) {
            int length = getNumLength(N, nums);
            if ((length & 1) == 0) {
                // if length is even, palindrome must be divided by 11
                N = (int) Math.pow(10, length) + 1;
                modulus = 5; // modulus must be 5
                continue;
            }
            // here modulus must be 1 or 5
            if (isPalindrome(length, nums) && isPrime(N)) {
                return N;
            }
            if (modulus == 1) {
                N += 4;
                modulus = 5;
            } else { // modulus == 5
                N += 2;
                modulus = 1;
            }
        }
    }

    public static int getNumLength(int N, int[] nums) {
        int length = 0;
        while (N > 0) {
            nums[length++] = N % 10;
            N /= 10;
        }
        return length;
    }

    public static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);
        // We have filtered nums what "N % 6 != 1 || N % 6 != 5"
        for (int i = 5; i <= sqrt; i += 6) {
            // So here just check "i % 6 == 1 || i % 6 == 5"
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int length, int[] nums) {
        for (int i = 0; i < length / 2; i++) {
            if (nums[i] != nums[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromic(int num) {
        String s = String.valueOf(num);
        char[] nums = s.toCharArray();
        int length = nums.length;
        for (int i = 0; i < length / 2; i++) {
            if (nums[i] != nums[length - i - 1]) {
                return false;
            }
        }
        return true;
    }


}
