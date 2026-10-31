package week10.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tokens: ");
        int n = sc.nextInt();

        int[] tokens = new int[n];
        System.out.println("Enter " + n + " token numbers:");
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(tokens));
        sc.close();
    }
}