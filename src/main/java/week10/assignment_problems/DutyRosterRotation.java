package week10.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;                        // remove full turns
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = names[i];   // each name moves k places right
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        System.out.println("Enter " + n + " names:");
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        System.out.println(Arrays.toString(rotateRoster(names, k)));
        sc.close();
    }
}

/*
 Complexity: time O(n), extra space O(n) for the result array.
 Rotating one place at a time, k times, costs O(n * k). With k up to 10^9 and
 n up to 100 that is about 10^11 operations, far too slow. Using k % n shrinks
 the work to at most n shifts, and the index formula does it in one pass.
*/