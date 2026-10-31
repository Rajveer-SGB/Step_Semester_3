package week10.assignment_problems;

import java.util.Scanner;

public class SecondBestScore {

    static int secondHighest(int[] scores) {
        int highest = -1;   // scores are 0..100, so -1 means "not found"
        int second = -1;

        for (int i = 0; i < scores.length; i++) {
            int s = scores[i];
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;       // a score equal to highest is skipped
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter " + n + " scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.println(secondHighest(scores));
        sc.close();
    }
}

/*
 Complexity: time O(n), extra space O(1).
 Sorting first would take O(n log n) time (and O(1) to O(n) space depending on
 the algorithm), so the single pass is faster and does not change the input.
*/