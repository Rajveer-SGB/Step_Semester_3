package week10.assignment_problems;

import java.util.Scanner;

public class ExamScoreBandCounter {

    // Returns the first index whose score is >= target (binary search).
    // If every score is smaller, it returns scores.length.
    static int firstAtLeast(int[] scores, int target) {
        int lo = 0;
        int hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) {
                hi = mid;          // keep looking on the left (handles duplicates)
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        int start = firstAtLeast(scores, low);       // first score >= low
        int end = firstAtLeast(scores, high + 1);    // first score > high (marks are integers)
        return end - start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        System.out.println("Enter " + n + " scores in ascending order:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter low and high: ");
        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countInBand(scores, low, high));
        sc.close();
    }
}

/*
 Complexity:
 - Linear scan: time O(n), extra space O(1).
 - Binary search solution: time O(log n) per query, extra space O(1).
 Duplicates: a normal binary search stops at any match, which could be in the
 middle of a run of equal scores. We keep moving left (hi = mid) so we land on
 the FIRST position of low's run, and we search for the first score above high
 so every duplicate of high is counted.
*/