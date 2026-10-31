package week10.class_problems;

import java.util.Scanner;

public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.next();

        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        String reversed = sb.toString();

        // Comparison is case-sensitive (the problem does not say otherwise)
        if (word.equals(reversed)) {
            System.out.println(reversed + " - palindrome");
        } else {
            System.out.println(reversed + " - not a palindrome");
        }
        sc.close();
    }
}