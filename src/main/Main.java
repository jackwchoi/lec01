package main;

public class Main {

    public static int projectEuler01() {
        int sum = 0;
        for (int i = 1; i < 1000; i++) {     // for every positive integer less than 1000
            if (i % 3 == 0 || i % 5 == 0) {  // if divisible by 3 or 5
                sum += i;                    // accumulate the sum
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        // print the answer for question 1
        System.out.println(projectEuler01());
    }
}
