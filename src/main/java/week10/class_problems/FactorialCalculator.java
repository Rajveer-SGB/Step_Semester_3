package week10.class_problems;

import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers");
        } else if (n > 20) {
            // long can hold factorials only up to 20!
            System.out.println("Please enter a number up to 20 (long limit)");
        } else {
            long factorial = 1;      // also handles 0! = 1
            for (int i = 1; i <= n; i++) {
                factorial = factorial * i;
            }
            System.out.println(factorial);
        }
        sc.close();
    }
}