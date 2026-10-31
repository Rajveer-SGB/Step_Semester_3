package week10.assignment_problems;

import java.util.Scanner;

public class ClassAttendanceTracker {

    // Returns {presentDays, longestStreak}
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int current = 0;
        int longest = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                present++;
                current++;
                if (current > longest) {
                    longest = current;
                }
            } else {
                current = 0;
            }
        }
        return new int[] { present, longest };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] days = new int[n];
        System.out.println("Enter " + n + " values (1 = present, 0 = absent):");
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
        sc.close();
    }
}

/*
 Complexity: time O(n), extra space O(1).
 Yes, both answers are found in a single pass.
*/