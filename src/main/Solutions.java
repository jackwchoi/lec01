package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solutions {

    public static int projectEuler01() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {     // for every positive integer less than 1000
            if (i % 3 == 0 || i % 5 == 0) {  // if divisible by 3 or 5
                sum += i;                    // accumulate the sum
            }
        }
        return sum;
    }

    public static int projectEuler02() {
        int sum = 0;

        int a = 0;  // initial first fibonacci number
        int b = 1;  // initial second fibonnacci number

        while (b < 4000000) {
            int newFib = a + b;
            a = b;
            b = newFib;

            // accumulate the sum if the new fib number is divisible by 2
            if (newFib % 2 == 0) {
                sum += newFib;
            }
        }
        return sum;
    }

    /**
     * @param number the integer to check
     * @return true if `number` is palindrome, false otherwise
     */
    public static boolean isPalindrome(int number) {
        String asString = String.valueOf(number);

        // index of the last character
        int lastCharIndex = asString.length() - 1;

        // compare 1st and last, 2nd and second-last, and etc.
        for (int i = 0; i < asString.length() / 2; i++) {
            char head = asString.charAt(i);
            char tail = asString.charAt(lastCharIndex - i);
            if (head != tail) {
                return false;
            }
        }
        return true;
    }

    public static int projectEuler04() {
        int max = 0;

        for (int i = 100; i < 1000; i++) {      // 3 digit numbers
            for (int j = 100; j < 1000; j++) {  // 3 digit numbers
                int product = i * j;
                if (product > max && isPalindrome(product)) {
                    max = product;
                }
            }
        }
        return max;
    }

    /**
     * @param number
     * @param low
     * @param high
     * @return true if `number` is divisible by all integers in the range
     *         low <= number <= high
     */
    public static boolean divisibleByAll(int number, int low, int high) {
        for (int i = low; i <= high; i++) {
            if (number % i != 0) {
                return false;
            }
        }
        return true;
    }
    public static int projectEuler05() {
        int i = 1;
        while (! divisibleByAll(i, 1, 20)) {
            i++;
        }
        return i;
    }

    /**
     * @param numbers a list of numbers
     * @return square of sum of numbers in `numbers`
     */
    public static int squareOfSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum * sum;
    }
    /**
     * @param numbers a list of numbers
     * @return sum of squares of numbers in `numbers`
     */
    public static int sumOfSquares(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number * number;
        }
        return sum;
    }
    public static int projectEuler06() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        return squareOfSum(numbers) - sumOfSquares(numbers);
    }

    public static int projectEuler09() {
        for (int a = 1; a < 1000; a++) {        // 1 <= a < 1000
            for (int b = a+1; b < 1000; b++) {  // a < b < 1000
                int c = 1000 - a - b;

                // c has to be greater than b
                if (c <= b) {
                    continue;
                } else if (a*a + b*b == c*c) {
                    return a * b * c;
                }
            }
        }
        throw new RuntimeException();  // shouldn't reach this point
    }

    /**
     * @param number
     * @return the length of collatz sequence that starts from number
     */
    public static int getCollatzSeqLength(int number) {
        int len = 1;
        long current = number;
        while (current > 1) {
            if (current % 2 == 0) {  // current is even
                current /= 2;
            } else {
                current = 3*current + 1;
            }
            len++;
        }
        return len;
    }
    public static int projectEuler14() {
        int maxLength = 0;
        int maxNumber = 0;

        for (int i = 1; i < 1000000; i++) {
            int collatzLength = getCollatzSeqLength(i);
            if (collatzLength > maxLength) {
                maxLength = collatzLength;
                maxNumber = i;
            }
        }
        return maxNumber;
    }

    /**
     * @param number
     * @return sum of the proper divisors of `number`
     */
    public static int sumProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    public static int projectEuler21() {
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            int sumOfDivisors = sumProperDivisors(i);
            int sumOfDivisorsOfSOD = sumProperDivisors(sumOfDivisors);
            if (i != sumOfDivisors && i == sumOfDivisorsOfSOD) {
                sum += i;
            }
        }
        return sum;
    }

    public static int projectEuler23() {
        Set<Integer> abundantNumbers = new HashSet<>();
        for (int i = 1; i < 28123; i++) {
            if (i < sumProperDivisors(i)) {
                abundantNumbers.add(i);
            }
        }

        Set<Integer> canExpress = new HashSet<>();
        for (int a : abundantNumbers) {
            for (int b : abundantNumbers) {
                canExpress.add(a + b);
            }
        }

        int sum = 0;
        for (int i = 0; i < 28123; i++) {
            if (! canExpress.contains(i)) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.printf("Problem 01: %d\n", projectEuler01());
        System.out.printf("Problem 02: %d\n", projectEuler02());
        System.out.printf("Problem 04: %d\n", projectEuler04());
        System.out.printf("Problem 05: %d\n", projectEuler05());
        System.out.printf("Problem 06: %d\n", projectEuler06());
        System.out.printf("Problem 09: %d\n", projectEuler09());
        System.out.printf("Problem 14: %d\n", projectEuler14());
        System.out.printf("Problem 21: %d\n", projectEuler21());
        System.out.printf("Problem 23: %d\n", projectEuler23());
    }
}
